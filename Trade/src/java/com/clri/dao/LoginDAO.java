/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.dao;

import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
import com.clri.dto.Users;
import com.clri.utils.Queries;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 *
 * @author Balamurugan
 */
public class LoginDAO {

    public Users loginAuthentication(HttpServletRequest request, String userName, String password) {
        Users user = null;
        Connection con = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            con = dbcon.openConnection();
            String sql = Queries.getQuery("SELECT_USER");

            ResultSetHandler<Users> resultSetHandler = new BeanHandler<Users>(Users.class);
            QueryRunner run = new QueryRunner();
            user = run.query(con, sql, resultSetHandler, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(con);
        }
        return user;
    }

}
