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
import model.KetQua;



/**
 *
 * @author PC
 */
public class KetQuaController {
    public static List<KetQua> listKetQua() throws ClassNotFoundException, SQLException {
        ArrayList<KetQua> listKetQua = new ArrayList<>();
        String sql = "select ID_LOPHP, ID_SV, BaiTap, GiuaKy, CuoiKy, TrungBinh, XepLoai from KetQua";
        Connection connection = controller.connectDB.connectSQLServer();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            KetQua ketQua = new KetQua();
            ketQua.setID_SV(rs.getString("ID_SV"));
            ketQua.setBaiTap(rs.getFloat("BaiTap"));
            ketQua.setGiuaKy(rs.getFloat("GiuaKy"));
            ketQua.setCuoiKy(rs.getFloat("CuoiKy"));
            ketQua.setTrungBinh(rs.getFloat("TrungBinh"));
            ketQua.setXepLoai(rs.getString("XepLoai"));
            listKetQua.add(ketQua);
        }
        rs.close();
        statement.close();
        connection.close();
        if (listKetQua.isEmpty()) {
            return null;
        } else {
            return listKetQua;
        }
    }
    
     public static int deleteKetQua(KetQua ketQua) throws ClassNotFoundException, SQLException {
        String sql = "delete from KetQua where ID_SV=? and ID_LopHP=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1,ketQua.getID_SV());
        prepareStatement.setString(2, ketQua.getID_LOPHP());
        return prepareStatement.executeUpdate();
    }
    
     public static int addKetQua(KetQua ketQua) throws ClassNotFoundException, SQLException {
        String sql = "insert into KetQua values(?,?,null,null,null,null,null,null,0)";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, ketQua.getID_LOPHP());
        prepareStatement.setString(2, ketQua.getID_SV());
    
        return prepareStatement.executeUpdate();
    }
     
     public static int editKetQua(KetQua ketQua) throws ClassNotFoundException, SQLException {
        String sql = "update KetQua set BaiTap=?, GiuaKy=?, CuoiKy=?, TrungBinh=?, XepLoai=? where ID_SV=? and ID_LopHP=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql); 
        if(ketQua.getBaiTap()==-1) prepareStatement.setString(1, null);  else  prepareStatement.setFloat(1, ketQua.getBaiTap());
        if(ketQua.getGiuaKy()==-1) prepareStatement.setString(2, null);  else  prepareStatement.setFloat(2, ketQua.getGiuaKy());
        if(ketQua.getCuoiKy()==-1) prepareStatement.setString(3, null);  else  prepareStatement.setFloat(3, ketQua.getCuoiKy());
        if(ketQua.getTrungBinh()==-1) prepareStatement.setString(4, null);  else  prepareStatement.setFloat(4, ketQua.getTrungBinh());
        prepareStatement.setString(5, ketQua.getXepLoai());
        
        prepareStatement.setString(6, ketQua.getID_SV());
         prepareStatement.setString(7, ketQua.getID_LOPHP());
        return prepareStatement.executeUpdate();
    }
     
   public static ArrayList<KetQua> getKetQuaByClassName(String className) throws ClassNotFoundException, SQLException {
        ArrayList<KetQua> result = new ArrayList<KetQua>();
        String sql = "select * from KetQua where ID_LopHP = ?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, className);
        ResultSet rs = prepareStatement.executeQuery();
        while(rs.next()) {
 //           if(rs.getString("BaiTap")!=null)System.out.println("cc");
            KetQua objKetQua = new KetQua();
            objKetQua.setID_LOPHP(rs.getString("ID_LOPHP"));
            objKetQua.setID_SV(rs.getString("ID_SV"));
            if(rs.getString("BaiTap")==null) objKetQua.setBaiTap((float) -1.0); else objKetQua.setBaiTap(rs.getFloat("BaiTap"));
            if(rs.getString("GiuaKy")==null) objKetQua.setGiuaKy((float) -1.0); else objKetQua.setGiuaKy(rs.getFloat("GiuaKy"));
            if(rs.getString("CuoiKy")==null) objKetQua.setCuoiKy((float) -1.0); else objKetQua.setCuoiKy(rs.getFloat("CuoiKy"));
            if(rs.getString("TrungBinh")==null) objKetQua.setTrungBinh((float) -1.0); else objKetQua.setTrungBinh(rs.getFloat("TrungBinh"));
            if(rs.getString("Xeploai")!=null) objKetQua.setXepLoai(rs.getString("Xeploai"));
            
             result.add(objKetQua);
             
            
//            KetQua objKetQua = new KetQua(rs.getString("ID_LOPHP"),rs.getString("ID_SV"), rs.getFloat("BaiTap"), rs.getFloat("GiuaKy"), rs.getFloat("CuoiKy"),rs.getFloat("TrungBinh"), rs.getString("XepLoai"));
//           
        }
        return result;
}
   public static List<KetQua> listDaXepLopHP(String ID_LopHP) throws ClassNotFoundException, SQLException {
        ArrayList<KetQua> listIDSV = new ArrayList<>();
        String sql = "select ID_SV from KetQua where ID_LOPHP=?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, ID_LopHP);
        ResultSet rs = prepareStatement.executeQuery();
        while(rs.next()) {
            KetQua objKetQua = new KetQua();
            objKetQua.setID_SV(rs.getString("ID_SV"));
            listIDSV.add(objKetQua);
    }
    return listIDSV;
   }
   
   public static List<KetQua> listChuaXepLopHP(String ID_LopHP) throws ClassNotFoundException, SQLException {
        ArrayList<KetQua> listIDSV = new ArrayList<>();
        String sql = "select ID_SV from SinhVien except select SinhVien.ID_SV from SinhVien join KetQua on SinhVien.ID_SV = KetQua.ID_SV and KetQua.ID_LopHP = ?";
        Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, ID_LopHP);
        ResultSet rs = prepareStatement.executeQuery();
        while(rs.next()) {
            KetQua objKetQua = new KetQua();
            objKetQua.setID_SV(rs.getString("ID_SV"));
            listIDSV.add(objKetQua);
    }
    return listIDSV;
   }
   public static String IDLopSH(String ID_SV)throws ClassNotFoundException, SQLException{
       Connection connection = controller.connectDB.connectSQLServer();
        PreparedStatement prepareStatement = connection.prepareStatement("select ID_LopSH from SINHVIEN where ID_SV=?");
        prepareStatement.setString(1, ID_SV);
        ResultSet rs = prepareStatement.executeQuery();
        String tam = " ";
        while(rs.next()) {
            tam = rs.getString("ID_LopSH");
        }
        return tam;
   }
}



/*;
  select ID_SV from SinhVien except select SinhVien.ID_SV from SinhVien join KetQua on SinhVien.ID_SV = KetQua.ID_SV and KetQua.ID_LopHP = 'LHPID01';
*/
 