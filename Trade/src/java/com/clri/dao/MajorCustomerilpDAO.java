/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clri.dao;

import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
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
public class MajorCustomerilpDAO {

    public int insertMajorCustomerilp(Connection connection, MajorCustomerilp majorcustomerilp) {
        int count = 0;
        try {
            QueryRunner run = new QueryRunner();
            String sql = Queries.getQuery("INSERT_MAJOR_CUSTOMERILP");
            count = run.update(connection, sql, majorcustomerilp.getItems(),
                    majorcustomerilp.getCountry(),majorcustomerilp.getUnits(),majorcustomerilp.getQuantity(), majorcustomerilp.getValue(), majorcustomerilp.getYear());
        } catch (SQLException e) {
        }
        return count;
    }

    public List<MajorCustomerilp> getList() {
        List<MajorCustomerilp> majorList = new ArrayList<>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("MAJOR_CUSTOMERILP_LIST");

            ResultSetHandler<List<MajorCustomerilp>> resultSetHandler = new BeanListHandler<>(MajorCustomerilp.class);
            QueryRunner run = new QueryRunner();
            majorList = run.query(connecton, sql, resultSetHandler);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorList;
    }

    public int addUpdateCustomers(MajorCustomerilp majorCustomerilp ) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            QueryRunner run = new QueryRunner();
            String sql = "";
            if (majorCustomerilp.getId() == 0) {
                sql = Queries.getQuery("INSERT_MAJOR_CUSTOMERILP");
                count = run.update(connecton, sql, majorCustomerilp.getId());
            } else {
                sql = Queries.getQuery("UPDATE_MAJOR_CUSTOMERILP");
                count = run.update(connecton, sql, majorCustomerilp.getValue(), majorCustomerilp.getQuantity(), majorCustomerilp.getId());
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
            String sql = Queries.getQuery("DELETE_MAJOR_CUSTOMERILP");
            QueryRunner run = new QueryRunner();
            count = run.update(connecton, sql, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }

    public MajorCustomerilp getById(int id) {
        MajorCustomerilp majorCustomerilp = new MajorCustomerilp();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CATEGORY_BY_ID");

            ResultSetHandler<MajorCustomerilp> resultSetHandler = new BeanHandler<>(MajorCustomerilp.class);
            QueryRunner run = new QueryRunner();
            majorCustomerilp= run.query(connecton, sql, resultSetHandler, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorCustomerilp;
    }

    private static class MajorCustomerilp {

        public MajorCustomerilp() {
        }

        private int getId() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Object getItems() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}

