/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clri.dao;

import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
import com.clri.dto.MajorCustomers;
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
public class MajorCustomersDAO {

    public int insertMajorCustomers(Connection connection, MajorCustomers majorcustomers) {
        int count = 0;
        try {
            QueryRunner run = new QueryRunner();
            String sql = Queries.getQuery("INSERT_CUST");
            count = run.update(connection, sql, majorcustomers.getArticleCode(),majorcustomers.getItems(),
                    majorcustomers.getCountry(),majorcustomers.getQuantity(), majorcustomers.getValue(), majorcustomers.getYear(),majorcustomers.getType(),majorcustomers.getCategory());
        } catch (SQLException e) {
        }
        return count;
    }
     public List<MajorCustomers> getList(int type) {
        List<MajorCustomers> majorList = new ArrayList<>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CUST_LIST_ALL");

            ResultSetHandler<List<MajorCustomers>> resultSetHandler = new BeanListHandler<>(MajorCustomers.class);
            QueryRunner run = new QueryRunner();
            majorList = run.query(connecton, sql, resultSetHandler,type);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorList;
    }
     
    public List<MajorCustomers> getList(int type,int category) {
        List<MajorCustomers> majorList = new ArrayList<>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CUST_LIST");

            ResultSetHandler<List<MajorCustomers>> resultSetHandler = new BeanListHandler<>(MajorCustomers.class);
            QueryRunner run = new QueryRunner();
            majorList = run.query(connecton, sql, resultSetHandler,type,category);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorList;
    }

    public int addUpdateCustomers(MajorCustomers majorCustomers ) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            QueryRunner run = new QueryRunner();
            String sql = "";
            if (majorCustomers.getId() == 0) {
                sql = Queries.getQuery("INSERT_CUSTOMERS");
                count = run.update(connecton, sql, majorCustomers.getArticleCode());
            } else {
                sql = Queries.getQuery("UPDATE_CUSTOMERS");
                count = run.update(connecton, sql, majorCustomers.getValue(), majorCustomers.getQuantity(), majorCustomers.getId());
            }

        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }

    public int delete(int id) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("DELETE_CUST");
            QueryRunner run = new QueryRunner();
            count = run.update(connecton, sql, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }

    public MajorCustomers getById(int id) {
        MajorCustomers majorCustomers = new MajorCustomers();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CATEGORY_BY_ID");

            ResultSetHandler<MajorCustomers> resultSetHandler = new BeanHandler<>(MajorCustomers.class);
            QueryRunner run = new QueryRunner();
            majorCustomers= run.query(connecton, sql, resultSetHandler, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorCustomers;
    }

   

}

