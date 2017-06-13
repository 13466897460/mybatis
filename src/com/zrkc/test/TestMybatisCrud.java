package com.zrkc.test;

import com.zrkc.model.Dept;
import com.zrkc.utils.GetSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;


/**
 * Created by YaoZiHao on 2017/6/12.
 */
public class TestMybatisCrud {
    @Test
    public void testSelectOne() throws IOException {
        //1.加载解析SqlMapConfig.xml配置文件
        //1.1将SqlMapConfig.xml配置文件处理成InputStream格式的数据哈哈哈
//        Resources
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //1.2加载 inputStream中的数据 返回SqlSessionFactory工厂对象
         SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.根据sf工厂对象 获取SqlSession对象(与数据库的一次连接会话 和web没有关系的 Connection的封装)
        SqlSession sqlSession=sessionFactory.openSession();
        //將session转换成原始的Connection
//        Connection connection=sqlSession.getConnection();
    //ResultType值=selectOne(sql语句的id值，parameterType的值)
        //3.操作数据
        Dept dept=sqlSession.selectOne("mybatis.day01.selectDeptById",20);
        System.out.print(dept.getDname()+":"+ dept.getLoc());
        //资源释放
    }
    @Test
    public void testSelectAll() throws IOException {
//1.加载SqlMapConfig.xml 返回SqlSessionFactory对象
        SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));

// 2.根据工厂对象 获取SqlSession对象
 SqlSession session=       sf.openSession();
//3.操作数据
     List<Dept> list=  session.selectList("mybatis.day01.selectAll");
for (Dept dept:list){
    System.out.print(dept.getDname());


}
//4.资源释放
        session.close();
    }
    @Test
    public  void testAdd(){
        //获取Sqlsession
     SqlSession sqlSession=   GetSession.getSqlSession();
        //操作数据
        Dept d=new Dept(1212,"22","23");
        sqlSession.insert("mybatis.day01.insertOne",d);
        //在mybatis中 增删改 需要事务
        sqlSession.commit();
        //4.资源释放
        sqlSession.close();
    }
    @Test
    public  void testDelete(){
        //获取SqlSession
     SqlSession sqlSession=   GetSession.getSqlSession();
        //操作数据
        sqlSession.delete("mybatis.day01.deleteOne",1212);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public  void testUpdate(){
        //获取SqlSession
        SqlSession sqlSession=GetSession.getSqlSession();
      Dept d=  sqlSession.selectOne("mybatis.day01.selectDeptById",1);
       d.setDname("21212");
       d.setLoc("qwqwq");
       sqlSession.update("mybatis.day01.updateOne",d);
       sqlSession.commit();
       sqlSession.close();


    }

}
