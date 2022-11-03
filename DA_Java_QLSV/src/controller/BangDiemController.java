/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.BangDiemController.listBangDiem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.BangDiem;

/**
 *
 * @author My PC
 */
public class BangDiemController {
      public static List<BangDiem> listBangDiem(String sinhVienID) throws ClassNotFoundException, SQLException {
        ArrayList<BangDiem> listBangDiem = new ArrayList<>();
        Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement prepareStatement = connection.prepareStatement("select KQ.ID_LOPHP, LHP.ID_MH, BaiTap, GiuaKy, CuoiKy, TrungBinh, XepLoai from KETQUA KQ join SINHVIEN SV on KQ.ID_SV = SV.ID_SV join LOPHP LHP on KQ.ID_LOPHP = LHP.ID_LOPHP join MONHOC MH on MH.ID_MH = LHP.ID_MH where KQ.ID_SV = ?;");
        prepareStatement.setString(1, sinhVienID);
        ResultSet rs = prepareStatement.executeQuery();
        String tam = " ";
        while (rs.next()) {
            BangDiem bangDiem = new BangDiem();
            bangDiem.setID_LOPHP(rs.getString("ID_LOPHP"));
            bangDiem.setID_MH(rs.getString("ID_MH"));
            if(rs.getString("BaiTap")==null) bangDiem.setBaiTap((float) -1.0); else bangDiem.setBaiTap(rs.getFloat("BaiTap"));
            if(rs.getString("GiuaKy")==null) bangDiem.setGiuaKy((float) -1.0); else bangDiem.setGiuaKy(rs.getFloat("GiuaKy"));
            if(rs.getString("CuoiKy")==null) bangDiem.setCuoiKy((float) -1.0); else bangDiem.setCuoiKy(rs.getFloat("CuoiKy"));
            if(rs.getString("TrungBinh")==null) bangDiem.setTrungBinh((float) -1.0); else bangDiem.setTrungBinh(rs.getFloat("TrungBinh"));
            if(rs.getString("Xeploai")!=null) bangDiem.setXepLoai(rs.getString("Xeploai"));
            listBangDiem.add(bangDiem);
        }
        rs.close();
        connection.close();
        if (listBangDiem.isEmpty()) {
            return null;
        } else {
            return listBangDiem;
        }
    }
    public static float DiemTrungBinhID(String sinhVienID) throws ClassNotFoundException, SQLException {
        Connection connection = controller.connectDB.connectSQLServer();
         PreparedStatement command = connection.prepareStatement("SELECT ROUND(AVG(TrungBinh),3) AS \"DTB\" FROM KETQUA WHERE ID_SV=? and Xeploai != 'F'");
         command.setString(1, sinhVienID); 
         ResultSet rs = command.executeQuery();
         float Tam = 0;
        while (rs.next()) {
             Tam = rs.getFloat("DTB");
                
          }
        return Tam;
    }
    
}
