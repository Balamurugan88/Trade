/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Balamurugan
 */
public class Queries {

    private static final String PROP_FILE_NAME = "queries.properties";
    private static Properties props;

    public static Properties getQueries() throws SQLException {
        InputStream is = 
            Queries.class.getResourceAsStream(PROP_FILE_NAME);
        if (is == null){
            throw new SQLException("Unable to load property file: " + PROP_FILE_NAME);
        }
        //singleton
        if(props == null){
            props = new Properties();
            try {
                props.load(is);
            } catch (IOException e) {
                throw new SQLException("Unable to load property file: " + PROP_FILE_NAME + "\n" + e.getMessage());
            }           
        }
        return props;
    }

    public static String getQuery(String query) throws SQLException{
        return getQueries().getProperty(query);
    }

}