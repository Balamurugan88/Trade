/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.dao;
import com.clri.dbutils.DBUtils;
import com.clri.dbutils.DataBaseConnection;
import com.clri.dto.Customer;
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
public class CustomerDAO {

   

    public List<Customer> getList() {
        List<Customer> customerList = new ArrayList<Customer>();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CUSTOMER_LIST");

            ResultSetHandler<List<Customer>> resultSetHandler = new BeanListHandler<Customer>(Customer.class);
            QueryRunner run = new QueryRunner();
            customerList = run.query(connecton, sql, resultSetHandler);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return customerList;
    }

    public int addUpdateCustomer(Customer customer) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
             QueryRunner run = new QueryRunner();
            String sql = "";
            if(customer.getId() == 0){
                sql = Queries.getQuery("INSERT_CUSTOMER");
                count = run.update(connecton, sql, customer.getName(), customer.getDob(),customer.getEmail());
            }else{
                sql = Queries.getQuery("UPDATE_CUSTOMER");
                count = run.update(connecton, sql,customer.getName(), customer.getDob(),customer.getId(),customer.getEmail());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }

     public int deleteCustomer(int id) {
        Connection connecton = null;
        int count = 0;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("DELETE_CUSTOMER");
            QueryRunner run = new QueryRunner();
            count = run.update(connecton, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return count;
    }


    public Customer getById(int id) {
        Customer customer = new Customer();
        Connection connecton = null;
        try {
            DataBaseConnection dbcon = new DataBaseConnection();
            connecton = dbcon.openConnection();
            String sql = Queries.getQuery("CUSTOMER_BY_ID");

            ResultSetHandler<Customer> resultSetHandler = new BeanHandler<Customer>(Customer.class);
            QueryRunner run = new QueryRunner();
            customer = run.query(connecton, sql, resultSetHandler,id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connecton);
        }
        return customer;
    }

}

