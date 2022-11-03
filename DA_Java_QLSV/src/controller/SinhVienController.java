/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import model.SinhVien;

/**
 *
 * @author My PC
 */
public class SinhVienController {
    public static List<SinhVien> listSinhVienID() throws ClassNotFoundException, SQLException {
        ArrayList<SinhVien> listSinhVien = new ArrayList<>();
        String sql = "select ID_SV, TenSV, NgaysinhSV, GioitinhSV, CMND, DiachiSV,ID_LopSH from SinhVien";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setID_SV(rs.getString("ID_SV"));
            sinhVien.setTenSV(rs.getString("TenSV"));
            sinhVien.setNgaysinhSV(rs.getDate("NgaysinhSV"));
            sinhVien.setGioitinhSV(rs.getBoolean("GioitinhSV"));
            sinhVien.setCMND(rs.getString("CMND"));
            sinhVien.setDiachiSV(rs.getString("DiachiSV"));
            sinhVien.setLopSH(rs.getString("ID_LopSH"));
            listSinhVien.add(sinhVien);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listSinhVien.isEmpty()) {
            return null;
        } else {
            return listSinhVien;
        }
    }
    
     public static List<SinhVien> TimKiemSVTen(String Ten) throws ClassNotFoundException, SQLException {
        ArrayList<SinhVien> listSinhVien = new ArrayList<>();
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement command = connection.prepareStatement("select * from SINHVIEN where TenSV like ?");
         Statement statement = connection.createStatement();
         command.setString(1, "%" +Ten+ "%"); 
         ResultSet rs = command.executeQuery();
        while (rs.next()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setID_SV(rs.getString("ID_SV"));
            sinhVien.setTenSV(rs.getString("TenSV"));
            sinhVien.setNgaysinhSV(rs.getDate("NgaysinhSV"));
            sinhVien.setGioitinhSV(rs.getBoolean("GioitinhSV"));
            sinhVien.setCMND(rs.getString("CMND"));
            sinhVien.setDiachiSV(rs.getString("DiachiSV"));
            sinhVien.setLopSH(rs.getString("ID_LopSH"));
            listSinhVien.add(sinhVien);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listSinhVien.isEmpty()) {
            return null;
        } else {
            return listSinhVien;
        }
    }
    
  
    
        public static List<SinhVien> listSVLopSH(String ID_LopSH) throws ClassNotFoundException, SQLException {
          
         Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement command = connection.prepareStatement("select * from SINHVIEN where ID_LopSH= ?");
         Statement statement = connection.createStatement();
         command.setString(1, ID_LopSH); 
         ResultSet rs = command.executeQuery();
          ArrayList<SinhVien> listSVLopSH = new ArrayList<>();
        while (rs.next()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setID_SV(rs.getString("ID_SV"));
            sinhVien.setTenSV(rs.getString("TenSV"));
            sinhVien.setNgaysinhSV(rs.getDate("NgaysinhSV"));
            sinhVien.setGioitinhSV(rs.getBoolean("GioitinhSV"));
            sinhVien.setCMND(rs.getString("CMND"));
            sinhVien.setLopSH(rs.getString("ID_LopSH"));
            sinhVien.setDiachiSV(rs.getString("DiachiSV"));
            listSVLopSH.add(sinhVien);  
          }
       rs.close();
        statement.close();
        connection.close();
        if (listSVLopSH.isEmpty()) {
            return null;
        } else {
            return listSVLopSH;
        }
    }
        public static List<SinhVien> listSVLopHP(String ID_LopHP) throws ClassNotFoundException, SQLException {
          
         Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement command = connection.prepareStatement("select SINHVIEN.ID_SV, TenSV, NgaysinhSV, GioitinhSV, CMND, DiachiSV,ID_LopSH from SINHVIEN join KETQUA on SINHVIEN.ID_SV = KETQUA.ID_SV and KETQUA.ID_LOPHP=?;");
         Statement statement = connection.createStatement();
         command.setString(1, ID_LopHP); 
         ResultSet rs = command.executeQuery();
          ArrayList<SinhVien> listSVLopHP = new ArrayList<>();
        while (rs.next()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setID_SV(rs.getString("ID_SV"));
            sinhVien.setTenSV(rs.getString("TenSV"));
            sinhVien.setNgaysinhSV(rs.getDate("NgaysinhSV"));
            sinhVien.setGioitinhSV(rs.getBoolean("GioitinhSV"));
            sinhVien.setCMND(rs.getString("CMND"));
            sinhVien.setDiachiSV(rs.getString("DiachiSV"));
            sinhVien.setLopSH(rs.getString("ID_LopSH"));
            //System.out.println("ID_LopSH:"+rs.getString("ID_LopSH"));
            listSVLopHP.add(sinhVien);
          }
       rs.close();
        statement.close();
        connection.close();
        if (listSVLopHP.isEmpty()) {
            return null;
        } else {
            return listSVLopHP;
        }
    }
        

    public static int deleteSinhVienID(String sinhVienID) throws ClassNotFoundException, SQLException {
        String sql = "delete from SinhVien where ID_SV=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1,sinhVienID);
        return prepareStatement.executeUpdate();
    }

    public static String createSinhVienID() throws ClassNotFoundException, SQLException {
        String sql = "select ID_SV from SinhVien order by ID_SV desc";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        String studentTam = "";
        if (rs.next()) {
            studentTam = rs.getString("ID_SV");
        }
        rs.close();
        statement.close();
        connection.close();
        if (studentTam == "") {
            return "SVID000001";
        } else {
            if (Integer.valueOf(studentTam.substring(4,10)) < 9) {
                return "SVID00000" + (Integer.valueOf(studentTam.substring(4, 10)) + 1);
                } 
                    else {
                        if (Integer.valueOf(studentTam.substring(4,10)) < 99) {
                        return "SVID0000" + (Integer.valueOf(studentTam.substring(4, 10)) + 1);
                        }
                            else {
                                if (Integer.valueOf(studentTam.substring(4,10)) < 999) {
                                return "SVID000" + (Integer.valueOf(studentTam.substring(4, 10)) + 1);
                                }
                                else{
                                     if (Integer.valueOf(studentTam.substring(4,10)) < 9999) {
                                     return "SVID00" + (Integer.valueOf(studentTam.substring(4, 10)) + 1);
                                }
                                     else{
                                     if (Integer.valueOf(studentTam.substring(4,10)) < 99999) {
                                     return "SVID0" + (Integer.valueOf(studentTam.substring(4, 10)) + 1);
                                     }
                                     else
                                          return "SVID" + (Integer.valueOf(studentTam.substring(4, 10)) + 1);
                                     }
                                }
            }
        }
        }
    
    }

    public static int addSinhVienID(SinhVien sinhVien) throws ClassNotFoundException, SQLException {
        String sql = "insert into SinhVien values(?,?,?,?,?,?,?)";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, sinhVien.getID_SV());
        prepareStatement.setString(2, sinhVien.getTenSV());
        prepareStatement.setDate(3,new Date(sinhVien.getNgaysinhSV().getTime()));
        prepareStatement.setBoolean(4, sinhVien.isGioitinhSV());
         prepareStatement.setString(5, sinhVien.getCMND());
        prepareStatement.setString(6, sinhVien.getDiachiSV());
       
        prepareStatement.setString(7, sinhVien.getLopSH());

        return prepareStatement.executeUpdate();
    }
    
    public static int editSinhVienID(SinhVien sinhVien) throws ClassNotFoundException, SQLException {
        String sql = "update SinhVien set TenSV=?, NgaysinhSV=?, GioitinhSV=?, CMND=?, DiachiSV=?, ID_LopSH=? where ID_SV=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, sinhVien.getTenSV());
        prepareStatement.setDate(2,new Date(sinhVien.getNgaysinhSV().getTime()));
        prepareStatement.setBoolean(3, sinhVien.isGioitinhSV());
        prepareStatement.setString(4, sinhVien.getCMND());
        prepareStatement.setString(5, sinhVien.getDiachiSV());
        prepareStatement.setString(6, sinhVien.getLopSH());
        
        prepareStatement.setString(7, sinhVien.getID_SV());
        return prepareStatement.executeUpdate();
    }
}
