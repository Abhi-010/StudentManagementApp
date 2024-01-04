package com.abhi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
    static Connection con;
    public static Connection createConnection(){// throws ClassNotFoundException {
        //Connection con;
        // load the driver
        try{
            Class.forName("java.sql.Driver");
            String user = "abhi_jdbc";
            String password = "pass1";
            String url = "jdbc:mysql://localhost:3306/jdbc_dc";
            con = DriverManager.getConnection(url,user,password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
