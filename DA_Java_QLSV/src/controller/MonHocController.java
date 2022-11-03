/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.MonHoc;

/**
 *
 * @author My PC
 */
public class MonHocController {
    public static List<MonHoc> listMonHocID() throws ClassNotFoundException, SQLException {
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        String sql = "select ID_MH, TenMH from MONHOC order by ID_MH";
        Connection connection = controller.connectDB.connectSQLServer(); 
        Statement statement = connection.createStatement(); 
        ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                MonHoc monhoc = new MonHoc(rs.getString("ID_MH"), rs.getString("TenMH"));
                listMonHoc.add(monhoc);
            }
        
        if (listMonHoc.isEmpty()) {
            return null;
        } else {
            return listMonHoc;
        }
    }
    
    public static List<MonHoc> TKMonHoc(String TenMH) throws ClassNotFoundException, SQLException {
         ArrayList<MonHoc> listMonHoc = new ArrayList<>();
         Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement command = connection.prepareStatement("select * from MONHOC where TenMH like ?");
         Statement statement = connection.createStatement();
         command.setString(1, "%" +TenMH+ "%"); 
         ResultSet rs = command.executeQuery();
          
         while (rs.next()) {
                MonHoc monhoc = new MonHoc(rs.getString("ID_MH"), rs.getString("TenMH"));
                listMonHoc.add(monhoc);
            }
        if (listMonHoc.isEmpty()) {
            return null;
        } else {
            return listMonHoc;
        }
    }

    
     public static String createMonHocID() throws ClassNotFoundException, SQLException {
        String sql = "select ID_MH from MONHOC order by ID_MH desc";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        String MHTam = "";
        if (rs.next()) {
            MHTam = rs.getString("ID_MH");
        }
        rs.close();
        statement.close();
        connection.close();
        if (MHTam == "") {
            return "MHID01";
        } else {
            if (Integer.valueOf(MHTam.substring(4, 6)) < 9) {
                return "MHID0" + (Integer.valueOf(MHTam.substring(4, 6)) + 1);
            } else {
                return "MHID" + (Integer.valueOf(MHTam.substring(4, 6)) + 1);
            }
        }
    }

    public static int addMonHoc(MonHoc monHoc) throws ClassNotFoundException, SQLException {
        String sql = "insert into MONHOC values(?,?)";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, monHoc.getID_MH());
        prepareStatement.setString(2, monHoc.getTenMH());
        return prepareStatement.executeUpdate();
    }
    
    public static int editMonHoc(MonHoc monhoc) throws ClassNotFoundException, SQLException {
        String sql = "update MONHOC set TenMH=? where ID_MH=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, monhoc.getTenMH());
        prepareStatement.setString(2, monhoc.getID_MH());
        return prepareStatement.executeUpdate();
    }
    
    public static int deleteMonHocID(String MHID) throws ClassNotFoundException, SQLException {
        String sql = "delete from MONHOC where ID_MH=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, MHID);
        return prepareStatement.executeUpdate();
    }
    
}

    
