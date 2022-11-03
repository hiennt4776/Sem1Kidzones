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
import model.LopSH;

/**
 *
 * @author My PC
 */
public class LopSHController {
    public static List<LopSH> listLopSHID() throws ClassNotFoundException, SQLException {
        ArrayList<LopSH> listLopSHID = new ArrayList<>();
        String sql = "select ID_LopSH,TenLopSH from LopSH";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            LopSH lopSH = new LopSH();
            lopSH.setID_LopSH(rs.getString("ID_LopSH"));
            lopSH.setTenLopSH(rs.getString("TenLopSH"));
            listLopSHID.add(lopSH);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listLopSHID.isEmpty()) {
            return null;
        } else {
            return listLopSHID;
        }
    }

     public static List<LopSH> TKLopSH(String TenLopSH) throws ClassNotFoundException, SQLException {
         ArrayList<LopSH> listLopSH = new ArrayList<>();
         Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement command = connection.prepareStatement("select * from LOPSH where TenLopSH like ?");
         Statement statement = connection.createStatement();
         command.setString(1, "%" +TenLopSH+ "%"); 
         ResultSet rs = command.executeQuery();
          
         while (rs.next()) {
                LopSH lopSH = new LopSH(rs.getString("ID_LopSH"), rs.getString("TenLopSH"));
                listLopSH.add(lopSH);
            }
        if (listLopSH.isEmpty()) {
            return null;
        } else {
            return listLopSH;
        }
    }
    
    public static int deleteLopSHID(String lopSHID) throws ClassNotFoundException, SQLException {
        String sql = "delete from LopSH where ID_lopSH=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, lopSHID);
        return prepareStatement.executeUpdate();
    }

    public static String createLopSHID() throws ClassNotFoundException, SQLException {
        String sql = "select ID_LopSH from LopSH order by ID_LopSH desc";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        String lopSHTam = "";
        if (rs.next()) {
            lopSHTam = rs.getString("ID_LopSH");
        }
        rs.close();
        statement.close();
        connection.close();
        if (lopSHTam == "") {
            return "LSHID00001";
        } else {
            if (Integer.valueOf(lopSHTam.substring(5,10)) < 9) {
            return "LSHID0000" + (Integer.valueOf(lopSHTam.substring(5, 10)) + 1);
            } else {
                if (Integer.valueOf(lopSHTam.substring(5,10)) < 99) {
                return "LSHID000" + (Integer.valueOf(lopSHTam.substring(5, 10)) + 1);
                } else {
                if (Integer.valueOf(lopSHTam.substring(5,10)) < 999) {
                return "LSHID00" + (Integer.valueOf(lopSHTam.substring(5, 10)) + 1);
                }else{
                if (Integer.valueOf(lopSHTam.substring(5,10)) < 9999) {
                return "LSHID0" + (Integer.valueOf(lopSHTam.substring(5, 10)) + 1);
                }else{
                    return "LSHID" + (Integer.valueOf(lopSHTam.substring(5, 10)) + 1);
                }
            }
        }
    }
        }
    }

    public static int addLopSHID(LopSH lopSH) throws ClassNotFoundException, SQLException {
        String sql = "insert into lopSH values(?,?)";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, lopSH.getID_LopSH());
        prepareStatement.setString(2, lopSH.getTenLopSH());
        return prepareStatement.executeUpdate();
    }
    
    public static int editLopSHID(LopSH lopSH) throws ClassNotFoundException, SQLException {
        String sql = "update lopSH set TenLopSH=? where ID_LopSH=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, lopSH.getTenLopSH());
        prepareStatement.setString(2, lopSH.getID_LopSH());
        return prepareStatement.executeUpdate();
    }
    
      
}
