package com.lucid;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private Connection con;
    private String url = "jdbc:mysql://localhost:3306/vms";
    private String user = "root";
    private String password = "Icui4cu2x";

    public DBConnection() {
        try{
            con = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static DBConnection getInstance(){
        return new DBConnection();
    }

    public Connection getConnection() {
        return con;
    }
}

