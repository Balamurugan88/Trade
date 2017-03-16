/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.dao;

import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
import com.clri.dto.MajorProductions;
import com.clri.utils.Queries;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Balamurugan
 */
public class MajorProductionsDAO {

    public int insertMajorProductions(Connection connection, MajorProductions majorProductions) {
        int count = 0;
        try {
            QueryRunner run = new QueryRunner();
            String sql = Queries.getQuery("INSERT_PROD");
            count = run.update(connection, sql, majorProductions.getArticleCode(),majorProductions.getItems(),
                                                majorProductions.getQuantity(), majorProductions.getValue(),
                    majorProductions.getYear(),majorProductions.getType(),majorProductions.getCategory());
        } catch (SQLException e) {
        }
        return count;
    }

    public List<MajorProductions> getList(int type,int category) {
        List<MajorProductions> majorList = new ArrayList<>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("PROD_LIST");

            ResultSetHandler<List<MajorProductions>> resultSetHandler = new BeanListHandler<>(MajorProductions.class);
            QueryRunner run = new QueryRunner();
            majorList = run.query(connecton, sql, resultSetHandler,type,category);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorList;
    }
    
    public List<MajorProductions> getList(int type) {
        List<MajorProductions> majorList = new ArrayList<>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("PROD_LIST_ALL");

            ResultSetHandler<List<MajorProductions>> resultSetHandler = new BeanListHandler<>(MajorProductions.class);
            QueryRunner run = new QueryRunner();
            majorList = run.query(connecton, sql, resultSetHandler,type);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorList;
    }

    public int addUpdateRaw(MajorProductions majorProductions) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            QueryRunner run = new QueryRunner();
            String sql = "";
            if (majorProductions.getId() == 0) {
                sql = Queries.getQuery("INSERT_CATEGORY");
                count = run.update(connecton, sql, majorProductions.getArticleCode());
            } else {
                sql = Queries.getQuery("UPDATE_CATEGORY");
                count = run.update(connecton, sql, majorProductions.getValue(), majorProductions.getQuantity(), majorProductions.getId());
            }

        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }

    public int deleteCategory(int id) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("DELETE_PROD");
            QueryRunner run = new QueryRunner();
            count = run.update(connecton, sql, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }

    public MajorProductions getById(int id) {
        MajorProductions majorProductions;
        majorProductions = new MajorProductions();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CATEGORY_BY_ID");

            ResultSetHandler<MajorProductions> resultSetHandler = new BeanHandler<>(MajorProductions.class);
            QueryRunner run = new QueryRunner();
            majorProductions= run.query(connecton, sql, resultSetHandler, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorProductions;
    }

}
