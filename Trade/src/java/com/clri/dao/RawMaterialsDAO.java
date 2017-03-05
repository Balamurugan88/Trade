/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.dao;

import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
import com.clri.dto.RawMaterials;
import com.clri.utils.Queries;
import java.sql.Connection;
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
public class RawMaterialsDAO {

    public int insertRawMaterials(Connection connection, RawMaterials rawMaterials) {
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            QueryRunner run = new QueryRunner();
            String sql = Queries.getQuery("INSERT_RAW_MATERIALS");
            count = run.update(connection, sql, rawMaterials.getArticleCode(), rawMaterials.getQuantity(), rawMaterials.getValue(), rawMaterials.getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<RawMaterials> getList() {
        List<RawMaterials> rawList = new ArrayList<RawMaterials>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("RAW_LIST");

            ResultSetHandler<List<RawMaterials>> resultSetHandler = new BeanListHandler<RawMaterials>(RawMaterials.class);
            QueryRunner run = new QueryRunner();
            rawList = run.query(connecton, sql, resultSetHandler);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return rawList;
    }

    public int addUpdateRaw(RawMaterials rawMaterials) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            QueryRunner run = new QueryRunner();
            String sql = "";
            if (rawMaterials.getId() == 0) {
                sql = Queries.getQuery("INSERT_CATEGORY");
                count = run.update(connecton, sql, rawMaterials.getArticleCode());
            } else {
                sql = Queries.getQuery("UPDATE_CATEGORY");
                count = run.update(connecton, sql, rawMaterials.getValue(), rawMaterials.getQuantity(), rawMaterials.getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
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
            String sql = Queries.getQuery("DELETE_CATEGORY");
            QueryRunner run = new QueryRunner();
            count = run.update(connecton, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }

    public RawMaterials getById(int id) {
        RawMaterials rawMaterials = new RawMaterials();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CATEGORY_BY_ID");

            ResultSetHandler<RawMaterials> resultSetHandler = new BeanHandler<RawMaterials>(RawMaterials.class);
            QueryRunner run = new QueryRunner();
            rawMaterials = run.query(connecton, sql, resultSetHandler, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return rawMaterials;
    }

}
