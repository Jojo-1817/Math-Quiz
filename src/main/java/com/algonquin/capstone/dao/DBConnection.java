package com.algonquin.capstone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String dbUser     = "root";       
    private static final String dbPassword = "Jonathanzgy-2026"; 
    private static final String conn_string =
        "jdbc:mysql://localhost/MathQuiz";

    public static Connection getConnectionToDatabase()
            throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                conn_string, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}