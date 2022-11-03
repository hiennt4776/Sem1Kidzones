/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author My PC
 */
public class LopSH {
    private String ID_LopSH;
    private String TenLopSH;

    public LopSH() {
    }

    public LopSH(String ID_LopSH, String TenLopSH) {
        this.ID_LopSH = ID_LopSH;
        this.TenLopSH = TenLopSH;
    }

    public String getID_LopSH() {
        return ID_LopSH;
    }

    public void setID_LopSH(String ID_LopSH) {
        this.ID_LopSH = ID_LopSH;
    }

    public String getTenLopSH() {
        return TenLopSH;
    }

    public void setTenLopSH(String TenLopSH) {
        this.TenLopSH = TenLopSH;
    }
  
}
