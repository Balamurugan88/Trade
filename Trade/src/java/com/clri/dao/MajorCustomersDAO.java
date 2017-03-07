/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clri.dao;

import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
import com.clri.dto.MajorCustomers;
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
public class MajorCustomersDAO {

    public int insertMajorCustomers(Connection connection, MajorCustomers majorcustomers) {
        int count = 0;
        try {
            QueryRunner run = new QueryRunner();
            String sql = Queries.getQuery("INSERT_MAJOR_PRODUCTIONS");
            count = run.update(connection, sql, majorcustomers.getItems(),majorcustomers.getArticleCode(),
                    majorcustomers.getCountry(),majorcustomers.getQuantity(), majorcustomers.getValue(), majorcustomers.getYear());
        } catch (SQLException e) {
        }
        return count;
    }

    public List<MajorCustomers> getList() {
        List<MajorCustomers> majorList = new ArrayList<>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("MAJOR_LIST");

            ResultSetHandler<List<MajorCustomers>> resultSetHandler = new BeanListHandler<>(MajorCustomers.class);
            QueryRunner run = new QueryRunner();
            majorList = run.query(connecton, sql, resultSetHandler);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorList;
    }

    public int addUpdateRaw(majorCustomers MajorCustomers) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            QueryRunner run = new QueryRunner();
            String sql = "";
            if (MajorCustomers.getId() == 0) {
                sql = Queries.getQuery("INSERT_CATEGORY");
                count = run.update(connecton, sql, MajorCustomers.getArticleCode());
            } else {
                sql = Queries.getQuery("UPDATE_CATEGORY");
                count = run.update(connecton, sql, MajorCustomers.getValue(), MajorCustomers.getQuantity(), MajorCustomers.getId());
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
            String sql = Queries.getQuery("DELETE_RM");
            QueryRunner run = new QueryRunner();
            count = run.update(connecton, sql, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }

    public MajorCustomers getById(int id) {
        MajorCustomers majorCustomers;
        majorCustomers = new MajorCustomers();
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

    public int addUpdateRaw(com.clri.servlet.MajorProductions majorProductions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int addUpdateMajor(com.clri.servlet.MajorCustomers majorCustomers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

}

