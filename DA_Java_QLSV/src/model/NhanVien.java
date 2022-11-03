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
public class NhanVien {
    private String ID_NV;
    private String TenNV;
    private Date NgaysinhNV;
    private boolean GioitinhNV;
    private String CMND;
    private String DiachiNV;
    private String ChucVu;
    private int Luong;
    private String Password;

    public NhanVien() {
    }

    public NhanVien(String ID_NV, String TenNV, Date NgaysinhNV, boolean GioitinhNV, String CMND, String DiachiNV, String ChucVu, int Luong, String Password) {
        this.ID_NV = ID_NV;
        this.TenNV = TenNV;
        this.NgaysinhNV = NgaysinhNV;
        this.GioitinhNV = GioitinhNV;
        this.CMND = CMND;
        this.DiachiNV = DiachiNV;
        this.ChucVu = ChucVu;
        this.Luong = Luong;
        this.Password = Password;
    }

    public String getID_NV() {
        return ID_NV;
    }

    public void setID_NV(String ID_NV) {
        this.ID_NV = ID_NV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public Date getNgaysinhNV() {
        return NgaysinhNV;
    }

    public void setNgaysinhNV(Date NgaysinhNV) {
        this.NgaysinhNV = NgaysinhNV;
    }

    public boolean isGioitinhNV() {
        return GioitinhNV;
    }

    public void setGioitinhNV(boolean GioitinhNV) {
        this.GioitinhNV = GioitinhNV;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDiachiNV() {
        return DiachiNV;
    }

    public void setDiachiNV(String DiachiNV) {
        this.DiachiNV = DiachiNV;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
   
    
    

}
