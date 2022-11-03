/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thaond
 */
public class connectDB {

    public static Connection connectSQLServer() throws ClassNotFoundException, SQLException {
        String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DB_URL = "jdbc:sqlserver://localhost;";
        String DATABASENAME = "databaseName=QLSV_Java_4;";
        String USER = "user=sa;";
        String PASS = "password=12345678";
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
        return connection;
    }
    
      public static String testConnect(){
            Connection conn = null;
            try
            {
                conn = connectDB.connectSQLServer();
                return "Kết nối CSDL thành công";
            }
            catch(ClassNotFoundException | SQLException e)
            {
                return "Kết nối CSDL thất bại";
            }
        }
}
