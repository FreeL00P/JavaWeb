package com.fj.dao;

import com.fj.utils.druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/1 11:23    since 1.0.0
 */
public class BasicDAO<T> {
    private QueryRunner qr= new QueryRunner();
    //开发通用的DML方法 针对任意的表

    /**
     *
     * @param sql 执行的DML sql语句
     * @param parameters 具体值
     * @return 返回被修改的行数
     */
    public  int update(String sql,Object...parameters){
        Connection connection=null;
        try {
            connection= druid.getConnection();
            return qr.update(sql,parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            druid.close(null,null,connection);//释放连接
        }
    }
    //返回多个对象（即查询的结果） 针对任意表
    /**
     *
     * @param sql sql语句可以有？
     * @param clazz 传入一个class对象 比如 actor.class
     * @param parameters ?具体的值 可以有多个
     * @return 返回Actor.class对应的ArrayList集合
     */
    public List<T> queryMulti(String sql, Class clazz, Object...parameters){
        Connection connection=null;
        try {
            connection= druid.getConnection();
            return qr.query(sql,new BeanListHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            druid.close(null,null,connection);//释放连接
        }
    }

    //查询单行结果的通用方法
    /**
     *
     * @param sql sql语句可以有？
     * @param clazz 传入一个class对象 比如 actor.class
     * @param parameters ?具体的值 可以有多个
     * @return 返回Actor.class对应的ArrayList集合
     */
    public T querySinge(String sql, Class clazz, Object...parameters){
        Connection connection=null;
        try {
            connection= druid.getConnection();
            return qr.query(sql, new BeanHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            druid.close(null,null,connection);//释放连接
        }
    }
    //返回单行单列
    public Object queryScalar(String sql, Object...parameters){
        Connection connection=null;
        try {
            connection= druid.getConnection();
            return qr.query(sql,new ScalarHandler<T>(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            druid.close(null,null,connection);//释放连接
        }
    }
}
