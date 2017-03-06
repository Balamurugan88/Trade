/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.dao;

import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
import com.clri.dto.Category;
import com.clri.dto.Users;
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
public class CategoryDAO {

    public List<Category> getList() {
        List<Category> categoryList = new ArrayList<Category>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CATEGORY_LIST");

            ResultSetHandler<List<Category>> resultSetHandler = new BeanListHandler<Category>(Category.class);
            QueryRunner run = new QueryRunner();
            categoryList = run.query(connecton, sql, resultSetHandler);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return categoryList;
    }

    public int addUpdateCategory(Category category) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
             QueryRunner run = new QueryRunner();
            String sql = "";
            if(category.getArticleCode()== 0){
                sql = Queries.getQuery("INSERT_CATEGORY");
                count = run.update(connecton, sql, category.getName());
            }else{
                sql = Queries.getQuery("UPDATE_CATEGORY");
                count = run.update(connecton, sql,category.getName(),category.getArticleCode());
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
     
     
    public Category getById(int id) {
        Category category = new Category();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CATEGORY_BY_ID");

            ResultSetHandler<Category> resultSetHandler = new BeanHandler<Category>(Category.class);
            QueryRunner run = new QueryRunner();
            category = run.query(connecton, sql, resultSetHandler,id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return category;
    }

}
