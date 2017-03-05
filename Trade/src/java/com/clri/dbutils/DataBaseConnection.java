/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clri.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author CDURAI
 */
public class DataBaseConnection {
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "trade";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "admin";

    public Connection openConnection() {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
}
