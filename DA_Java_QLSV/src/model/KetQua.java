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
public class KetQua {
    private String ID_LOPHP;
    private String ID_SV;
    private float BaiTap;
    private float GiuaKy;
    private float CuoiKy;
    private String XepLoai;
    private float TrungBinh;

    public KetQua(){
        super();
    }
    public KetQua(String ID_LOPHP, String ID_SV, float BaiTap, float GiuaKy, float CuoiKy, float TrungBinh, String XepLoai) {
        this.ID_LOPHP = ID_LOPHP;
        this.ID_SV = ID_SV;
        this.BaiTap = BaiTap;
        this.GiuaKy = GiuaKy;
        this.CuoiKy = CuoiKy;
        this.XepLoai = XepLoai;
        this.TrungBinh= TrungBinh;
    }


    public float getTrungBinh() {
        return TrungBinh;
    }

    public void setTrungBinh(float TrungBinh) {
        this.TrungBinh = TrungBinh;
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

    public String getXepLoai() {
        return XepLoai;
//        if(TrungBinh>=8){
//            return "Giỏi";
//        }else if(TrungBinh>=6){
//            return "Khá";
//        }else if(TrungBinh>=4){
//            return "Trung Bình";
//        }else return "Yếu";       
    }

    public void setXepLoai(String XepLoai) {
        this.XepLoai = XepLoai;
    }

 
    
}
