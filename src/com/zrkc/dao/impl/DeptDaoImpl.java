package com.zrkc.dao.impl;

import com.zrkc.model.Dept;
import com.zrkc.utils.GetSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by YaoZiHao on 2017/6/12.
 */
public class DeptDaoImpl implements com.zrkc.dao.DeptDao {
    /*
    添加
     */
    @Override
    public void testAdd(Dept d) {
        new Dept();
        //获取Sqlsession
        SqlSession sqlSession = GetSession.getSqlSession();
        //操作数据
        sqlSession.insert("mybatis.day01.insertOne", d);
        //在mybatis中 增删改 需要事务
        sqlSession.commit();
        //4.资源释放
        sqlSession.close();
    }

    /**
     * 删除
     */
    @Override
    public void testDelete(Integer id) {
        //获取SqlSession
        SqlSession sqlSession = GetSession.getSqlSession();
        //操作数据
        sqlSession.delete("mybatis.day01.deleteOne", id);
        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 修改
     */
    @Override
    public void testUpdate(Integer id, String dname, String loc) {
        //获取SqlSession
        SqlSession sqlSession = GetSession.getSqlSession();
        Dept d = sqlSession.selectOne("mybatis.day01.selectDeptById", id);
        d.setDname(dname);
        d.setLoc(loc);
        sqlSession.update("mybatis.day01.updateOne", d);
        sqlSession.commit();
        sqlSession.close();



    }

    /**
     * 查询所有
     */
    @Override
    public List<Dept> testSelectAll() {
//1.加载SqlMapConfig.xml 返回SqlSessionFactory对象
        SqlSessionFactory sf = null;
        SqlSession session = null;
        List<Dept> list = null;
        try {
            sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
            // 2.根据工厂对象 获取SqlSession对象
            session = sf.openSession();
//3.操作数据
            list = session.selectList("mybatis.day01.selectAll");
            for (Dept dept : list) {
                System.out.print(dept.getDname());


            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源释放
            session.close();
        }
        return list;

    }

    @Override
    public Dept testSelectOne(Integer id) {
        SqlSession sqlSession = null;
        Dept dept=null;
        //3.操作数据
        try {
            sqlSession = GetSession.getSqlSession();
            dept= sqlSession.selectOne("mybatis.day01.selectDeptById", id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.资源释放
            sqlSession.close();
        }
return dept;

    }

}
