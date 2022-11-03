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
public class LopHP {
    private String ID_LopHP;
    private String TenLopHP;
    private String MonHoc;
    private String NhanVien;
    private int HocPhi;

    public LopHP() {
    }

    public LopHP(String ID_LopHP, String TenLopHP, String MonHoc, String NhanVien, int HocPhi) {
        this.ID_LopHP = ID_LopHP;
        this.TenLopHP = TenLopHP;
        this.MonHoc = MonHoc;
        this.NhanVien = NhanVien;
        this.HocPhi = HocPhi;
    }

    public String getID_LopHP() {
        return ID_LopHP;
    }

    public void setID_LopHP(String ID_LopHP) {
        this.ID_LopHP = ID_LopHP;
    }

    public String getTenLopHP() {
        return TenLopHP;
    }

    public void setTenLopHP(String TenLopHP) {
        this.TenLopHP = TenLopHP;
    }

    public String getMonHoc() {
        return MonHoc;
    }

    public void setMonHoc(String MonHoc) {
        this.MonHoc = MonHoc;
    }

    public String getNhanVien() {
        return NhanVien;
    }

    public void setNhanVien(String NhanVien) {
        this.NhanVien = NhanVien;
    }

    public int getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(int HocPhi) {
        this.HocPhi = HocPhi;
    }
    
    
    
}
