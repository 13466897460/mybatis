package com.zrkc.dao;

import com.zrkc.model.Dept;

import java.util.List;

/**
 * Created by YaoZiHao on 2017/6/12.
 */
public interface DeptDao {
    /*
        添加
         */
    void testAdd(Dept d);

    void testDelete(Integer id);

    void testUpdate(Integer id, String dname, String loc);

    List<Dept> testSelectAll();

    Dept testSelectOne(Integer id);
}
