package com.zrkc.test;

import com.zrkc.model.Dept;
import com.zrkc.model.Emp;
import com.zrkc.utils.GetSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;


/**
 * Created by YaoZiHao on 2017/6/12.
 */
public class TestMybatisEmpCrud {
    @Test
    public  void testselect(){
        //获取SqlSession
        SqlSession sqlSession=GetSession.getSqlSession();
      Emp e=  sqlSession.selectOne("mybatis.day01_2.selectEmp",1);
        System.out.println(e.getEname()+":"+e.getJob()+":"+e.getSalary());
       sqlSession.close();


    }
    @Test
    public  void testselect1(){
        //获取SqlSession
        SqlSession sqlSession=GetSession.getSqlSession();
       List<HashMap> hashMaps=  sqlSession.selectList("mybatis.day01_2.selectEmp2");

      for(HashMap h:hashMaps){
       String ename= (String) h.get("ename");
       String job= (String) h.get("job");
       double salary = (Double) h.get("salary");
       double year_salary=(Double)h.get("year_sal");
    System.out.println(ename+"ww"+job+"ww"+salary+"ww"+year_salary);


      }


        sqlSession.close();


    }
    @Test
    public  void testselect2(){
        //获取SqlSession
        SqlSession sqlSession=GetSession.getSqlSession();
        List<HashMap> hashMaps=  sqlSession.selectList("mybatis.day01_2.selectEmp3");

        for(HashMap map:hashMaps){
            System.out.println(map.get("_name")+":"+map.get("_job")+":"+map.get("_sal"));

        }


        sqlSession.close();


    }
    @Test
    public  void testselect3(){
        //获取SqlSession
        SqlSession sqlSession=GetSession.getSqlSession();
        List<Emp> hashMaps=  sqlSession.selectList("mybatis.day01_2.selectEmp4");

        for(Emp emp:hashMaps){
            System.out.println(emp.getEname()+":"+emp.getJob()+":"+emp.getSalary()+":"+emp.getAge()+":"+emp.getSex());

        }


        sqlSession.close();


    }

}
