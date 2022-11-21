package com.services;

import javax.jws.WebService;

import java.sql.*;

@WebService(endpointInterface = "com.services.SubscriptService")
public class SubscriptServiceImpl implements SubscriptService{
    @Override
    public String createSubscriptDatabase(){
        try {
            DBHandler handler = new DBHandler();
            Connection conn = handler.getConnection();
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS subscription (creator_id INT NOT NULL, subscriber_id INT NOT NULL, status ENUM('PENDING','ACCEPTED','REJECTED') NOT NULL DEFAULT 'PENDING );";
            int count = statement.executeUpdate(sql);

            return "Create table success with return value : " + count ; 
        } catch (Exception e) {
            e.printStackTrace();
            return "Something went wrong while defining table " + e.getMessage();
            // TODO: handle exception
        }
    }

    @Override
    public String addSubscript(int creator_id,int subscriber_id){
        try {
            DBHandler handler = new DBHandler();
            Connection conn = handler.getConnection();
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO subscription(creator_id,subscriber_id) VALUES('%d','%d');";
            String formattedSQL = String.format(sql,creator_id,subscriber_id);
            int count = statement.executeUpdate(formattedSQL);
            return "Added new subscription request with return value : " + count ; 
        } catch (Exception e) {
            e.printStackTrace();
            return "Something went wrong while adding subscription " + e.getMessage();
            // TODO: handle exception
        }
    }
}
