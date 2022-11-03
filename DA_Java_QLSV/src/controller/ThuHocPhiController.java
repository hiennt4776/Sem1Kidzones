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
import model.ThuHocPhi;

/**
 *
 * @author Dell
 */
public class ThuHocPhiController {
    
     public static List<ThuHocPhi> listThuHocPhi() throws ClassNotFoundException, SQLException {
        ArrayList<ThuHocPhi> listThuHocPhi = new ArrayList<>();
        String sql = "SELECT ID_LOPHP, ID_SV, ID_NV, ThanhToan FROM KETQUA";
        
      
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            ThuHocPhi thuhocphi = new ThuHocPhi();
            thuhocphi.setID_LOPHP(rs.getString("ID_LOPHP"));
            thuhocphi.setID_SV(rs.getString("ID_SV"));
            thuhocphi.setID_NV(rs.getString("ID_NV"));
            
            thuhocphi.setThanhToan(rs.getBoolean("ThanhToan"));

       
            listThuHocPhi.add(thuhocphi);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listThuHocPhi.isEmpty()) {
            return null;
        } else {
            return listThuHocPhi;
        }
    }

    public static List<ThuHocPhi> TimKiemSVID(String IDSV) throws ClassNotFoundException, SQLException {
        ArrayList<ThuHocPhi> listThuHocPhi = new ArrayList<>();
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement command = connection.prepareStatement("SELECT ID_LOPHP, ID_SV, ID_NV, ThanhToan FROM KETQUA where ID_SV = ?");
         Statement statement = connection.createStatement();
         command.setString(1, IDSV); 
         ResultSet rs = command.executeQuery();
        while (rs.next()) {
             ThuHocPhi thuhocphi = new ThuHocPhi();
            thuhocphi.setID_LOPHP(rs.getString("ID_LOPHP"));
            thuhocphi.setID_SV(rs.getString("ID_SV"));
            thuhocphi.setID_NV(rs.getString("ID_NV"));
            thuhocphi.setThanhToan(rs.getBoolean("ThanhToan"));
            listThuHocPhi.add(thuhocphi);
        }
        rs.close();
        statement.close();
        connection.close();
         if (listThuHocPhi.isEmpty()) {
            return null;
        } else {
            return listThuHocPhi;
        }
    }     
     
     public static List<ThuHocPhi> TKChuaThanhToanSVID(String IDSV) throws ClassNotFoundException, SQLException {
        ArrayList<ThuHocPhi> listThuHocPhi = new ArrayList<>();
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement command = connection.prepareStatement("SELECT ID_LOPHP, ID_SV, ThanhToan FROM KETQUA where ID_SV = ? and ThanhToan = 0");
         Statement statement = connection.createStatement();
         command.setString(1, IDSV); 
         ResultSet rs = command.executeQuery();
        while (rs.next()) {
             ThuHocPhi thuhocphi = new ThuHocPhi();
            thuhocphi.setID_LOPHP(rs.getString("ID_LOPHP"));
            thuhocphi.setID_SV(rs.getString("ID_SV"));
            thuhocphi.setThanhToan(rs.getBoolean("ThanhToan"));
            listThuHocPhi.add(thuhocphi);
        }
        rs.close();
        statement.close();
        connection.close();
         if (listThuHocPhi.isEmpty()) {
            return null;
        } else {
            return listThuHocPhi;
        }
    }  
      public static List<ThuHocPhi> TKDaThanhToanSVID(String IDSV) throws ClassNotFoundException, SQLException {
        ArrayList<ThuHocPhi> listThuHocPhi = new ArrayList<>();
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement command = connection.prepareStatement("SELECT ID_LOPHP, ID_SV, ID_NV, ThanhToan FROM KETQUA where ID_SV = ? and ThanhToan = 1");
         Statement statement = connection.createStatement();
         command.setString(1, IDSV); 
         ResultSet rs = command.executeQuery();
        while (rs.next()) {
             ThuHocPhi thuhocphi = new ThuHocPhi();
            thuhocphi.setID_LOPHP(rs.getString("ID_LOPHP"));
            thuhocphi.setID_SV(rs.getString("ID_SV"));
             thuhocphi.setID_NV(rs.getString("ID_NV"));
            thuhocphi.setThanhToan(rs.getBoolean("ThanhToan"));
            listThuHocPhi.add(thuhocphi);
        }
        rs.close();
        statement.close();
        connection.close();
         if (listThuHocPhi.isEmpty()) {
            return null;
        } else {
            return listThuHocPhi;
        }
    }  
     
     
    
     public static List<ThuHocPhi> listChuaThanhToan() throws ClassNotFoundException, SQLException {
        ArrayList<ThuHocPhi> listThuHocPhi = new ArrayList<>();
        String sql = "SELECT ID_LOPHP, ID_SV, ThanhToan FROM KETQUA where ThanhToan = 0";
        
      
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            ThuHocPhi thuhocphi = new ThuHocPhi();
            thuhocphi.setID_LOPHP(rs.getString("ID_LOPHP"));
            thuhocphi.setID_SV(rs.getString("ID_SV"));
            thuhocphi.setThanhToan(rs.getBoolean("ThanhToan"));       
            listThuHocPhi.add(thuhocphi);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listThuHocPhi.isEmpty()) {
            return null;
        } else {
            return listThuHocPhi;
        }
    }

 public static List<ThuHocPhi> listDaThanhToan() throws ClassNotFoundException, SQLException {
        ArrayList<ThuHocPhi> listThuHocPhi = new ArrayList<>();
        String sql = "SELECT ID_LOPHP, ID_SV,ID_NV, ThanhToan FROM KETQUA where ThanhToan = 1";
        
      
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            ThuHocPhi thuhocphi = new ThuHocPhi();
            thuhocphi.setID_LOPHP(rs.getString("ID_LOPHP"));
            thuhocphi.setID_SV(rs.getString("ID_SV"));
            thuhocphi.setID_NV(rs.getString("ID_NV"));
            thuhocphi.setThanhToan(rs.getBoolean("ThanhToan"));

       
            listThuHocPhi.add(thuhocphi);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listThuHocPhi.isEmpty()) {
            return null;
        } else {
            return listThuHocPhi;
        }
    }
     
     
     
     
     public static int editThanhToan(ThuHocPhi thuhocphi) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE KETQUA SET ID_NV = ?, ThanhToan = 1 WHERE ID_LOPHP = ? and ID_SV = ?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
       
        prepareStatement.setString(1, thuhocphi.getID_NV());
        prepareStatement.setString(2, thuhocphi.getID_LOPHP());
        prepareStatement.setString(3, thuhocphi.getID_SV());
       
        return prepareStatement.executeUpdate();
    }
     public static int editHuyThanhToan(ThuHocPhi thuhocphi) throws ClassNotFoundException, SQLException {
        String sql ="UPDATE KETQUA SET ID_NV = NULL, ThanhToan = 0 WHERE ID_LOPHP = ? and ID_SV = ?";


        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, thuhocphi.getID_LOPHP());
        prepareStatement.setString(2, thuhocphi.getID_SV());
       
        return prepareStatement.executeUpdate();
    }
}
