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
public class MajorProductionilpDAO {

    public int insertMajorProductionilp(Connection connection, MajorProductionilp majorProductionilp) {
        int count = 0;
        try {
            QueryRunner run = new QueryRunner();
            String sql = Queries.getQuery("INSERT_MAJOR_PRODUCTIONILP");
            count = run.update(connection, sql, majorProductionilp.getArticleCode(),majorProductionilp.getItems(),
                    majorProductionilp.getUnits(),majorProductionilp.getQuantity(), majorProductionilp.getValue(), majorProductionilp.getYear());
        } catch (SQLException e) {
        }
        return count;
    }

    public List<MajorProductionilp> getList() {
        List<MajorProductionilp> majorList = new ArrayList<>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("MAJOR_PRODUCTIONILP_LIST");

            ResultSetHandler<List<MajorProductionilp>> resultSetHandler = new BeanListHandler<>(MajorProductionilp.class);
            QueryRunner run = new QueryRunner();
            majorList = run.query(connecton, sql, resultSetHandler);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorList;
    }

    public int addUpdateRaw(MajorProductionilp majorProductionilp) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            QueryRunner run = new QueryRunner();
            String sql = "";
            if (majorProductionilp.getId() == 0) {
                sql = Queries.getQuery("INSERT_CATEGORY");
                count = run.update(connecton, sql, majorProductionilp.getArticleCode());
            } else {
                sql = Queries.getQuery("UPDATE_CATEGORY");
                count = run.update(connecton, sql, majorProductionilp.getValue(), majorProductionilp.getQuantity(), majorProductionilp.getId());
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
            String sql = Queries.getQuery("DELETE_MAJOR_PRODUCTIONILP");
            QueryRunner run = new QueryRunner();
            count = run.update(connecton, sql, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }

    public MajorProductionilp getById(int id) {
        MajorProductionilp majorProductionilp;
        majorProductionilp = new MajorProductionilp();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CATEGORY_BY_ID");

            ResultSetHandler<MajorProductionilp> resultSetHandler = new BeanHandler<>(MajorProductionilp.class);
            QueryRunner run = new QueryRunner();
            majorProductionilp= run.query(connecton, sql, resultSetHandler, id);
        } catch (SQLException e) {
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return majorProductionilp;
    }

    public int addUpdateMAJOR_PRODUCTIONILP(com.clri.servlet.MajorProductionilpServlet majorProductionilp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int addUpdateRaw(com.clri.dto.MajorProductionilp majorProductionilp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

}
