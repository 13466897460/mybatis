package com.zrkc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


/**
 * Created by YaoZiHao on 2017/6/12.
 */
public class GetSession {
    public static SqlSessionFactory sf;
    public static SqlSession sqlSession;
    static {
        try {
            sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession= sf.openSession();

    }
    public static SqlSession getSqlSession(){
       return GetSession.sqlSession;

    }
}
