/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dell
 */
public class ThuHocPhi {

//    public static ThuHocPhi thuhocphi;
   private String ID_LOPHP;
   private String ID_SV;
   private String ID_NV;
   private Boolean ThanhToan;

    public ThuHocPhi() {
    }

    public ThuHocPhi(String ID_LOPHP, String ID_SV, String ID_NV, Boolean ThanhToan) {
        this.ID_LOPHP = ID_LOPHP;
        this.ID_SV = ID_SV;
        this.ID_NV = ID_NV;
        this.ThanhToan = ThanhToan;
   
    }

    public String getID_LOPHP() {
        return ID_LOPHP;
    }

    public void setID_LOPHP(String ID_LOPHP) {
        this.ID_LOPHP = ID_LOPHP;
    }

    public String getID_SV() {
        return ID_SV;
    }

    public void setID_SV(String ID_SV) {
        this.ID_SV = ID_SV;
    }

    public String getID_NV() {
        return ID_NV;
    }

    public void setID_NV(String ID_NV) {
        this.ID_NV = ID_NV;
    }

    public Boolean getThanhToan() {
        return ThanhToan;
    }

    public void setThanhToan(Boolean ThanhToan) {
        this.ThanhToan = ThanhToan;
    }

//    public void setVisible(boolean b) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   

   

   
          
   
}
