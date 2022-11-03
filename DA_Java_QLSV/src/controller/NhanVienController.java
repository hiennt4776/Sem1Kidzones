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
import Encrypt.Encrypt_MD5;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import view.frmMain;
import view.frmNhanVien;

/**
 *
 * @author My PC
 */
public class NhanVienController {
     public static List<NhanVien> listNhanVienID() throws ClassNotFoundException, SQLException {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        String sql = "select ID_NV, TenNV, NgaysinhNV, GioitinhNV,CMND,DiachiNV,ID_CV, Luong from NhanVien";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setID_NV(rs.getString("ID_NV"));
            nhanVien.setTenNV(rs.getString("TenNV"));
            nhanVien.setNgaysinhNV(rs.getDate("NgaysinhNV"));
            nhanVien.setGioitinhNV(rs.getBoolean("GioitinhNV"));
            nhanVien.setCMND(rs.getString("CMND"));
            nhanVien.setDiachiNV(rs.getString("DiachiNV"));
            nhanVien.setChucVu(rs.getString("ID_CV"));
            nhanVien.setLuong(rs.getInt("Luong"));
            listNhanVien.add(nhanVien);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listNhanVien.isEmpty()) {
            return null;
        } else {
            return listNhanVien;
        }
        
        
    }

     public static List<NhanVien> TimKiemNVTen(String Ten) throws ClassNotFoundException, SQLException {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement command = connection.prepareStatement("select * from NHANVIEN where TenNV like ?");
   
         command.setString(1, "%" +Ten+ "%"); 
         ResultSet rs = command.executeQuery();
        while (rs.next()) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setID_NV(rs.getString("ID_NV"));
            nhanVien.setTenNV(rs.getString("TenNV"));
            nhanVien.setNgaysinhNV(rs.getDate("NgaysinhNV"));
            nhanVien.setGioitinhNV(rs.getBoolean("GioitinhNV"));
            nhanVien.setCMND(rs.getString("CMND"));
            nhanVien.setDiachiNV(rs.getString("DiachiNV"));
            nhanVien.setChucVu(rs.getString("ID_CV"));
            nhanVien.setLuong(rs.getInt("Luong"));
            listNhanVien.add(nhanVien);
        }
        rs.close();
  
        connection.close();
        if (listNhanVien.isEmpty()) {
            return null;
        } else {
            return listNhanVien;
        }
    } 
     
    public static List<NhanVien> listGiangVienID() throws ClassNotFoundException, SQLException {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        String sql = "select ID_NV, TenNV, NgaysinhNV, GioitinhNV, CMND, DiachiNV,ID_CV, Luong from NhanVien where ID_CV='CVID03'";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setID_NV(rs.getString("ID_NV"));
            nhanVien.setTenNV(rs.getString("TenNV"));
            nhanVien.setNgaysinhNV(rs.getDate("NgaysinhNV"));
            nhanVien.setGioitinhNV(rs.getBoolean("GioitinhNV"));
             nhanVien.setCMND(rs.getString("CMND"));
            nhanVien.setDiachiNV(rs.getString("DiachiNV"));
            nhanVien.setChucVu(rs.getString("ID_CV"));
            nhanVien.setLuong(rs.getInt("Luong"));
            listNhanVien.add(nhanVien);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listNhanVien.isEmpty()) {
            return null;
        } else {
            return listNhanVien;
        }
    } 
     
     public static List<NhanVien> listThuNganID() throws ClassNotFoundException, SQLException {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        String sql = "select ID_NV, TenNV, NgaysinhNV, GioitinhNV,CMND, DiachiNV,ID_CV, Luong from NhanVien where ID_CV='CVID04'";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setID_NV(rs.getString("ID_NV"));
            nhanVien.setTenNV(rs.getString("TenNV"));
            nhanVien.setNgaysinhNV(rs.getDate("NgaysinhNV"));
            nhanVien.setGioitinhNV(rs.getBoolean("GioitinhNV"));
            nhanVien.setCMND(rs.getString("CMND"));
            nhanVien.setDiachiNV(rs.getString("DiachiNV"));
            nhanVien.setChucVu(rs.getString("ID_CV"));
            nhanVien.setLuong(rs.getInt("Luong"));
            listNhanVien.add(nhanVien);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listNhanVien.isEmpty()) {
            return null;
        } else {
            return listNhanVien;
        }
    } 
    
     
    public static int deleteNhanVienID(String nhanVienID) throws ClassNotFoundException, SQLException {
        String sql = "delete from NhanVien where ID_NV=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1,nhanVienID);
        return prepareStatement.executeUpdate();
    }

    public static String createNhanVienID() throws ClassNotFoundException, SQLException {
        String sql = "select ID_NV from NhanVien order by ID_NV desc";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        String nhanVienTam = "";
        if (rs.next()) {
            nhanVienTam = rs.getString("ID_NV");
        }
        rs.close();
        statement.close();
        connection.close();
        
         if (nhanVienTam == "") {
            return "NVID000001";
        } else {
            if (Integer.valueOf(nhanVienTam.substring(4,10)) < 9) {
                return "NVID00000" + (Integer.valueOf(nhanVienTam.substring(4, 10)) + 1);
                } 
                    else {
                        if (Integer.valueOf(nhanVienTam.substring(4,10)) < 99) {
                        return "NVID0000" + (Integer.valueOf(nhanVienTam.substring(4, 10)) + 1);
                        }
                            else {
                                if (Integer.valueOf(nhanVienTam.substring(4,10)) < 999) {
                                return "NVID000" + (Integer.valueOf(nhanVienTam.substring(4, 10)) + 1);
                                }
                                else{
                                     if (Integer.valueOf(nhanVienTam.substring(4,10)) < 9999) {
                                     return "NVID00" + (Integer.valueOf(nhanVienTam.substring(4, 10)) + 1);
                                }
                                     else{
                                     if (Integer.valueOf(nhanVienTam.substring(4,10)) < 99999) {
                                     return "NVID0" + (Integer.valueOf(nhanVienTam.substring(4, 10)) + 1);
                                     }
                                     else
                                          return "NVID" + (Integer.valueOf(nhanVienTam.substring(4, 10)) + 1);
                                     }
                                }
            }
        }
        }
        
    }

    public static int addNhanVienID(NhanVien nhanVien) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?,?)";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, nhanVien.getID_NV());
        prepareStatement.setString(2, nhanVien.getTenNV());
        prepareStatement.setDate(3, new Date(nhanVien.getNgaysinhNV().getTime()));
        prepareStatement.setBoolean(4, nhanVien.isGioitinhNV());
          prepareStatement.setString(5, nhanVien.getCMND());
        prepareStatement.setString(6, nhanVien.getDiachiNV());
        prepareStatement.setInt(7, nhanVien.getLuong());
        prepareStatement.setString(8, nhanVien.getChucVu());
        prepareStatement.setString(9, Encrypt_MD5.encrypt(nhanVien.getPassword()));
  //      System.out.println("Chuoi ma hoa:"+ Encrypt_MD5.encrypt(nhanVien.getPassword()));
        
        return prepareStatement.executeUpdate();
    }
    
    public static int editNhanVienID(NhanVien nhanVien) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String sql = "update NHANVIEN set TenNV=?, NgaysinhNV=?, GioitinhNV=?,CMND=?, DiachiNV=?, ID_CV=?, Luong=? where ID_NV=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
       
        prepareStatement.setString(1, nhanVien.getTenNV());
        prepareStatement.setDate(2, new Date(nhanVien.getNgaysinhNV().getTime()));
        prepareStatement.setBoolean(3, nhanVien.isGioitinhNV());
        prepareStatement.setString(4, nhanVien.getCMND());
        prepareStatement.setString(5, nhanVien.getDiachiNV());
        prepareStatement.setString(6, nhanVien.getChucVu());
        prepareStatement.setInt(7, nhanVien.getLuong());
        prepareStatement.setString(8, nhanVien.getID_NV());
        return prepareStatement.executeUpdate();
    }
    
    public static int resetPassWordNhanVienID(NhanVien nhanVien) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String sql = "update NHANVIEN set Password=? where ID_NV=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        System.out.println("Chuoi ban dau: "+ nhanVien.getPassword());
        
        prepareStatement.setString(1, Encrypt_MD5.encrypt(nhanVien.getPassword()));
        
        prepareStatement.setString(2, nhanVien.getID_NV());
        return prepareStatement.executeUpdate();
    }
    
    public static String IDCV(String nhanvienID) throws ClassNotFoundException, SQLException {
         Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement command = connection.prepareStatement("select ID_CV from NhanVien where ID_NV= ?");
         command.setString(1, nhanvienID); 
         ResultSet rs = command.executeQuery();
         String Tam="";
        while (rs.next()) {
             Tam = rs.getString("ID_CV");
                
          }
        return Tam;
                }  
  public static List<NhanVien> listNVChucVu(String IDCV) throws ClassNotFoundException, SQLException {
          
         Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement command = connection.prepareStatement("select * from NHANVIEN where ID_CV= ?");
         Statement statement = connection.createStatement();
         command.setString(1, IDCV); 
         ResultSet rs = command.executeQuery();
          ArrayList<NhanVien> listNVChucVu = new ArrayList<>();
        while (rs.next()) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setID_NV(rs.getString("ID_NV"));
            nhanVien.setTenNV(rs.getString("TenNV"));
            nhanVien.setNgaysinhNV(rs.getDate("NgaysinhNV"));
            nhanVien.setGioitinhNV(rs.getBoolean("GioitinhNV"));
            nhanVien.setCMND(rs.getString("CMND"));
            nhanVien.setDiachiNV(rs.getString("DiachiNV"));
            nhanVien.setChucVu(rs.getString("ID_CV"));
            nhanVien.setLuong(rs.getInt("Luong"));
            listNVChucVu.add(nhanVien);  
          }
       rs.close();
        statement.close();
        connection.close();
        if (listNVChucVu.isEmpty()) {
            return null;
        } else {
            return listNVChucVu;
        }
    }

}
