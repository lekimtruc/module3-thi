package com.codegym.thi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static final String DRIVER = "JDBC_DRIVER= com.mysql.cj.jdbc.Driver";
    private static final String CONNECTION_URL = "JDBC_CONNECTION_URL= jdbc:mysql://localhost:3306/tcomplex";
    private static final String USERNAME = "JDBC_USERNAME= root";
    private static final String PASSWORD = "JDBC_PASSWORD= root";

    public static Connection getConnection(){
        Connection connection;
        try{
            Class.forName(DRIVER);
            assert CONNECTION_URL != null;
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            return connection;
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
