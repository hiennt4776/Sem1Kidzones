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
import model.LopHP;

/**
 *
 * @author My PC
 */
public class LopHPController {
     public static List<LopHP> listLopHPID() throws ClassNotFoundException, SQLException {
        ArrayList<LopHP> listLopHP = new ArrayList<>();
        String sql = "select ID_LOPHP, TenLopHP, ID_MH, ID_NV, HocPhi from LOPHP";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            LopHP lopHP = new LopHP();
            lopHP.setID_LopHP(rs.getString("ID_LOPHP"));
            lopHP.setTenLopHP(rs.getString("TenLopHP"));
            lopHP.setMonHoc(rs.getString("ID_MH"));
            lopHP.setNhanVien(rs.getString("ID_NV"));
            lopHP.setHocPhi(rs.getInt("HocPhi"));
            listLopHP.add(lopHP);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listLopHP.isEmpty()) {
            return null;
        } else {
            return listLopHP;
        }
    }
      public static List<LopHP> TKLopHP(String TenLHP) throws ClassNotFoundException, SQLException {
         ArrayList<LopHP> listLopHP = new ArrayList<>();
         Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement command = connection.prepareStatement("select * from LOPHP where TenLopHP like ?");
         Statement statement = connection.createStatement();
         command.setString(1, "%" +TenLHP+ "%"); 
         ResultSet rs = command.executeQuery();
          
         while (rs.next()) {
                 LopHP lopHP = new LopHP();
            lopHP.setID_LopHP(rs.getString("ID_LOPHP"));
            lopHP.setTenLopHP(rs.getString("TenLopHP"));
            lopHP.setMonHoc(rs.getString("ID_MH"));
            lopHP.setNhanVien(rs.getString("ID_NV"));
            lopHP.setHocPhi(rs.getInt("HocPhi"));
            listLopHP.add(lopHP);
         }
        if (listLopHP.isEmpty()) {
            return null;
        } else {
            return listLopHP;
        }
    
      }
    public static int deleteLopHPID(String lopHPID) throws ClassNotFoundException, SQLException {
        String sql = "delete from LOPHP where ID_LOPHP=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1,lopHPID);
        return prepareStatement.executeUpdate();
    }

    public static String createLopHPID() throws ClassNotFoundException, SQLException {
        String sql = "select ID_LOPHP from LOPHP order by ID_LOPHP desc";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        String lopHPTam = "";
        if (rs.next()) {
            lopHPTam = rs.getString("ID_LOPHP");
        }
        rs.close();
        statement.close();
        connection.close();
        if (lopHPTam == "") {
            return "LHPID00001";
        } else {
            if (Integer.valueOf(lopHPTam.substring(5,10)) < 9) {
            return "LHPID0000" + (Integer.valueOf(lopHPTam.substring(5, 10)) + 1);
            } else {
                if (Integer.valueOf(lopHPTam.substring(5,10)) < 99) {
                return "LHPID000" + (Integer.valueOf(lopHPTam.substring(5, 10)) + 1);
                } else {
                if (Integer.valueOf(lopHPTam.substring(5,10)) < 999) {
                return "LHPID00" + (Integer.valueOf(lopHPTam.substring(5, 10)) + 1);
                }else{
                if (Integer.valueOf(lopHPTam.substring(5,10)) < 9999) {
                return "LHPID0" + (Integer.valueOf(lopHPTam.substring(5, 10)) + 1);
                }else{
                    return "LHPID" + (Integer.valueOf(lopHPTam.substring(5, 10)) + 1);
                }
            }
        }
    }
    }
    }

    public static int addLopHPID(LopHP lopHP) throws ClassNotFoundException, SQLException {
        String sql = "insert into LOPHP values(?,?,?,?,?)";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, lopHP.getID_LopHP());
        prepareStatement.setString(2, lopHP.getTenLopHP());
        prepareStatement.setString(3, lopHP.getMonHoc());
        prepareStatement.setString(4, lopHP.getNhanVien());
        prepareStatement.setInt(5, lopHP.getHocPhi());

        return prepareStatement.executeUpdate();
    }
    
    public static int editLopHPID(LopHP lopHP) throws ClassNotFoundException, SQLException {
        String sql = "update LOPHP set TenLopHP=?, ID_MH=?, ID_NV=?, HocPhi=? where ID_LOPHP=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, lopHP.getTenLopHP());
        prepareStatement.setString(2, lopHP.getMonHoc());
        prepareStatement.setString(3, lopHP.getNhanVien());
        prepareStatement.setInt(4, lopHP.getHocPhi()); 
        prepareStatement.setString(5, lopHP.getID_LopHP());
        return prepareStatement.executeUpdate();
    }
    
     public static List<LopHP> listLHPMonHoc(String IDMH) throws ClassNotFoundException, SQLException {
          
         Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement command = connection.prepareStatement("select * from LOPHP where ID_MH= ?");
         Statement statement = connection.createStatement();
         command.setString(1, IDMH); 
         ResultSet rs = command.executeQuery();
          ArrayList<LopHP> listLopHPMH = new ArrayList<>();
        while (rs.next()) {
             LopHP lopHP = new LopHP();
            lopHP.setID_LopHP(rs.getString("ID_LOPHP"));
            lopHP.setTenLopHP(rs.getString("TenLopHP"));
            lopHP.setMonHoc(rs.getString("ID_MH"));
            lopHP.setNhanVien(rs.getString("ID_NV"));
            lopHP.setHocPhi(rs.getInt("HocPhi"));
            listLopHPMH.add(lopHP);
          }
       rs.close();
        statement.close();
        connection.close();
        if (listLopHPMH.isEmpty()) {
            return null;
        } else {
            return listLopHPMH;
        }
    }
     
    public static List<LopHP> listLHPGiangVien(String IDGV) throws ClassNotFoundException, SQLException {
          
         Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement command = connection.prepareStatement("select * from LOPHP where ID_NV= ?");
         Statement statement = connection.createStatement();
         command.setString(1, IDGV); 
         ResultSet rs = command.executeQuery();
          ArrayList<LopHP> listLopHPGV = new ArrayList<>();
        while (rs.next()) {
             LopHP lopHP = new LopHP();
            lopHP.setID_LopHP(rs.getString("ID_LOPHP"));
            lopHP.setTenLopHP(rs.getString("TenLopHP"));
            lopHP.setMonHoc(rs.getString("ID_MH"));
            lopHP.setNhanVien(rs.getString("ID_NV"));
            lopHP.setHocPhi(rs.getInt("HocPhi"));
            listLopHPGV.add(lopHP);
          }
       rs.close();
        statement.close();
        connection.close();
        if (listLopHPGV.isEmpty()) {
            return null;
        } else {
            return listLopHPGV;
        }
    } 
}
