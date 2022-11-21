package com.services;

import java.sql.*;

public class DBHandler {
    private Connection connection;
    private static String DB_URL = "jdbc:mysql://localhost/BinotifySubscription";
    private static String DB_Username = "Binotify";
    private static String DB_Password = "binotify-menyabun";

    public DBHandler(){
        try {
            System.out.println("Connecting to MYSQL DB....");
            Class.forName("com.mysql.jdbc.driver");
            this.connection = DriverManager.getConnection(DB_URL,DB_Username,DB_Password);
            System.out.println("Database connected");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on connecting to database");
            // TODO: handle exception
        }
    }

    public Connection getConnection(){ return this.connection;}
}
