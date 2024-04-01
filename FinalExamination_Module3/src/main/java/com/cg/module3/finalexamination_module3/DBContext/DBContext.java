package com.cg.module3.finalexamination_module3.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBContext {
    private static final String URL = "jdbc:mysql://localhost:3306/Module3";
    private static final String username = "root";
    private static final String password = "0848101999";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Failed to establish connection to database:" + e.getMessage());
        }
    }
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
