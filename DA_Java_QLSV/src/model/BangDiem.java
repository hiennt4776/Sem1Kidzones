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
public class BangDiem {
    private String ID_LOPHP;
    private String ID_MH;
    private float BaiTap;
    private float GiuaKy;
    private float CuoiKy;
    private float TrungBinh;
    private String XepLoai;

    public BangDiem() {
    }

    public BangDiem(String ID_LOPHP, String ID_MH, float BaiTap, float GiuaKy, float CuoiKy, float TrungBinh, String XepLoai) {
        this.ID_LOPHP = ID_LOPHP;
        this.ID_MH = ID_MH;
        this.BaiTap = BaiTap;
        this.GiuaKy = GiuaKy;
        this.CuoiKy = CuoiKy;
        this.TrungBinh = TrungBinh;
        this.XepLoai = XepLoai;
    }

    public String getID_LOPHP() {
        return ID_LOPHP;
    }

    public void setID_LOPHP(String ID_LOPHP) {
        this.ID_LOPHP = ID_LOPHP;
    }

    public String getID_MH() {
        return ID_MH;
    }

    public void setID_MH(String ID_MH) {
        this.ID_MH = ID_MH;
    }

    public float getBaiTap() {
        return BaiTap;
    }

    public void setBaiTap(float BaiTap) {
        this.BaiTap = BaiTap;
    }

    public float getGiuaKy() {
        return GiuaKy;
    }

    public void setGiuaKy(float GiuaKy) {
        this.GiuaKy = GiuaKy;
    }

    public float getCuoiKy() {
        return CuoiKy;
    }

    public void setCuoiKy(float CuoiKy) {
        this.CuoiKy = CuoiKy;
    }

    public float getTrungBinh() {
        return TrungBinh;
    }

    public void setTrungBinh(float TrungBinh) {
        this.TrungBinh = TrungBinh;
    }

    public String getXepLoai() {
        return XepLoai;
    }

    public void setXepLoai(String XepLoai) {
        this.XepLoai = XepLoai;
    }
    

    
}
