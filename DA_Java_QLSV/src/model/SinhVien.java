/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author My PC
 */
public class SinhVien {
    private String ID_SV;
    private String TenSV;
    private Date NgaysinhSV;
    private boolean GioitinhSV;
    private String CMND;
    private String DiachiSV;
    private String LopSH;

    public SinhVien() {
    }

    public SinhVien(String ID_SV, String TenSV, Date NgaysinhSV, boolean GioitinhSV, String CMND, String DiachiSV, String LopSH) {
        this.ID_SV = ID_SV;
        this.TenSV = TenSV;
        this.NgaysinhSV = NgaysinhSV;
        this.GioitinhSV = GioitinhSV;
        this.CMND = CMND;
        this.DiachiSV = DiachiSV;
        this.LopSH = LopSH;
    }

    public String getID_SV() {
        return ID_SV;
    }

    public void setID_SV(String ID_SV) {
        this.ID_SV = ID_SV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }

    public Date getNgaysinhSV() {
        return NgaysinhSV;
    }

    public void setNgaysinhSV(Date NgaysinhSV) {
        this.NgaysinhSV = NgaysinhSV;
    }

    public boolean isGioitinhSV() {
        return GioitinhSV;
    }

    public void setGioitinhSV(boolean GioitinhSV) {
        this.GioitinhSV = GioitinhSV;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDiachiSV() {
        return DiachiSV;
    }

    public void setDiachiSV(String DiachiSV) {
        this.DiachiSV = DiachiSV;
    }

    public String getLopSH() {
        return LopSH;
    }

    public void setLopSH(String LopSH) {
        this.LopSH = LopSH;
    }

   
    
}
