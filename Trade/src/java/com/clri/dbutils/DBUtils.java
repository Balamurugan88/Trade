/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CDURAI
 */
public class DBUtils {

    public int deleteData(Connection con, String tableName, String id) throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "delete from " + tableName + " where id=" + id;
        return stmt.executeUpdate(sql);

    }

    public ResultSet listData(Connection con, String tableName) throws SQLException {
        String sql = "select * from " + tableName;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;

    }

    public ResultSet editData(Connection con, String tableName, String id) throws SQLException {
        String sql = "select * from " + tableName + " where id=" + id;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;

    }

    public ResultSet findData(Connection con, String tableName, String id, String WhereColumn) throws SQLException {
        String sql = "select * from " + tableName + " where " + WhereColumn + "=" + id;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;

    }

    public int updateData(Connection con, Map mp, String tablename, String[] columnName) throws SQLException {
        Statement stmt = con.createStatement();
        String whereClause = " set ";
        String idStr = null;
        String[] vals;
        for (int count = 0; count < columnName.length; count++) {
            if (count == 0) {
                vals = (String[]) mp.get(columnName[count]);
                idStr = " where " + columnName[count] + "=" + vals[0];
            } else {
                vals = (String[]) mp.get(columnName[count]);
                whereClause += columnName[count] + "='" + vals[0] + "',";
            }
        }
        whereClause = removeLastToken(whereClause, ",");
        String sql = "update " + tablename + whereClause + idStr;
//                    System.out.println("============ The update query is ======== "+sql);
        return stmt.executeUpdate(sql);

    }

    public int insertData(Connection con, Map mp, String tablename, String[] columnName) throws SQLException {
        Statement stmt = con.createStatement();
        String columnNames = "";
        String values = "";
        String[] vals;
        String sql = null;
        for (int count = 0; count < columnName.length; count++) {
            columnNames += columnName[count] + ",";
            vals = (String[]) mp.get(columnName[count]);
            values += "'" + vals[0] + "',";
        }
        columnNames = removeLastToken(columnNames, ",");
        values = removeLastToken(values, ",");
        sql = "insert into " + tablename + " (" + columnNames + ") values (" + values + ")";
        System.out.println("============== The sql is ============== " + sql);
        return stmt.executeUpdate(sql);
    }

    public static String removeLastToken(String word, String token) {
        if (word == null || token == null || "".equals(token)) {
            return word;
        }

        String newWord = word;
        int pos = word.lastIndexOf(token);
        if (pos != -1) {
            newWord = word.substring(0, pos);
        }
        return newWord;
    }

    public static boolean isStringInArray(String item, String[] array, boolean ignoreCase) {
        if (array == null) {
            return false;
        }

        boolean result = false;

        int size = array.length;
        for (int i = 0; i < size; i++) {
            String tmp = array[i];
            if (tmp != null) {
                if (ignoreCase) {
                    if (tmp.equalsIgnoreCase(item)) {
                        result = true;
                        break;
                    }
                } else {
                    if (tmp.equals(item)) {
                        result = true;
                        break;
                    }
                }
            } else {
                if (item == null) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }
    
    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String mailPath(HttpServletRequest request, HttpServletResponse response, String[] values, String[] names) {
        String mailPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/activateAccount";
        String urlParams = "?";
        for (int i = 0; i < values.length; i++) {
            urlParams += names[i] + "=" + values[i] + "&";

        }
        System.out.println("=============== mailpath is =========== " + mailPath + urlParams);
        return mailPath + urlParams;
    }
}
