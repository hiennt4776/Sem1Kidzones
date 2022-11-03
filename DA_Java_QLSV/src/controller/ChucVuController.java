/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ChucVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author My PC
 */
public class ChucVuController {
    public static List<ChucVu> listChucVuID() throws ClassNotFoundException, SQLException {
        ArrayList<ChucVu> listChucVu = new ArrayList<>();
        String sql = "select ID_CV, TenCV from CHUCVU order by ID_CV";
        
                Connection connection = controller.connectDB.connectSQLServer(); 
                Statement statement = connection.createStatement(); 
                ResultSet rs = statement.executeQuery(sql) ;
            while (rs.next()) {
                ChucVu chucVu = new ChucVu(rs.getString("ID_CV"), rs.getString("TenCV"));
                listChucVu.add(chucVu);
            }
       
        if (listChucVu.isEmpty()) {
            return null;
        } else {
            return listChucVu;
        }
    }
    
    
    public static String createChucVuID() throws ClassNotFoundException, SQLException {
        String sql = "select ID_CV from CHUCVU order by ID_CV desc";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        String chucVuTam = "";
        if (rs.next()) {
            chucVuTam = rs.getString("ID_CV");
        }
        rs.close();
        statement.close();
        connection.close();
        if (chucVuTam == "") {
            return "CVID01";
        } else {
            if (Integer.valueOf(chucVuTam.substring(4, 6)) < 9) {
                return "CVID0" + (Integer.valueOf(chucVuTam.substring(4, 6)) + 1);
            } else {
                return "CVID" + (Integer.valueOf(chucVuTam.substring(4, 6)) + 1);
            }
        }
    }
    
     public static int addChucVu(ChucVu chucVu) throws ClassNotFoundException, SQLException {
        String sql = "insert into CHUCVU values(?,?)";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, chucVu.getID_CV());
        prepareStatement.setString(2, chucVu.getTenCV());
        return prepareStatement.executeUpdate();
    }
    
    public static int deleteChucVuID(String chucVuID) throws ClassNotFoundException, SQLException {
        String sql = "delete from CHUCVU where ID_CV=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, chucVuID);
        return prepareStatement.executeUpdate();
    }
    
    public static int editChucVu(ChucVu chucVu) throws ClassNotFoundException, SQLException {
        String sql = "update CHUCVU set TenCV=? where ID_CV=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, chucVu.getTenCV());
        prepareStatement.setString(2, chucVu.getID_CV());
        return prepareStatement.executeUpdate();
    }
}


