/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clri.dao;

import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
import com.clri.dto.MajorCustomerelp;
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
public class MajorCustomerelpDAO {

    public int insertMajorCustomerelp(Connection connection, MajorCustomerelp majorcustomerelp) {
        int count = 0;
        try {
            QueryRunner run = new QueryRunner();
            String sql = Queries.getQuery("INSERT_MAJOR_CUSTOMERELP");
            count = run.update(connection, sql, majorcustomerelp.getItems(),majorcustomerelp.getUnits(),
                    majorcustomerelp.getCountry(),majorcustomerelp.getQuantity(), majorcustomerelp.getValue(), majorcustomerelp.getYear());
        } catch (SQLException e) {
        }
        return count;
    }

    public List<MajorCustomerelp> getList() {
        List<MajorCustomerelp> majorList = new ArrayList<>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("MAJOR_CUSTOMERELP_LIST");

            ResultSetHandler<List<MajorCustomerelp>> resultSetHandler = new BeanListHandler<>(MajorCustomerelp.class);
            QueryRunner run = new QueryRunner();
            majorList = run.query(connecton, sql, resultSetHandler);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorList;
    }

    public int addUpdateCustomers(MajorCustomerelp majorCustomerelp ) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            QueryRunner run = new QueryRunner();
            String sql = "";
            if (majorCustomerelp.getId() == 0) {
                sql = Queries.getQuery("INSERT_MAJOR_CUSTOMERELP");
                count = run.update(connecton, sql, majorCustomerelp.getItems());
            } else {
                sql = Queries.getQuery("UPDATE_MAJOR_CUSTOMERELP");
                count = run.update(connecton, sql, majorCustomerelp.getValue(), majorCustomerelp.getQuantity(), majorCustomerelp.getId());
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
            String sql = Queries.getQuery("DELETE_MAJOR_CUSTOMERELP");
            QueryRunner run = new QueryRunner();
            count = run.update(connecton, sql, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }

    public MajorCustomerelp getById(int id) {
        MajorCustomerelp majorCustomerelp = new MajorCustomerelp();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CATEGORY_BY_ID");

            ResultSetHandler<MajorCustomerelp> resultSetHandler = new BeanHandler<>(MajorCustomerelp.class);
            QueryRunner run = new QueryRunner();
            majorCustomerelp= run.query(connecton, sql, resultSetHandler, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorCustomerelp;
    }

}

