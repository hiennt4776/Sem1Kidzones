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
public class MonHoc {
    private String ID_MH;
    private String TenMH;

    public MonHoc() {
    }

    public MonHoc(String ID_MH, String TenMH) {
        this.ID_MH = ID_MH;
        this.TenMH = TenMH;
    }

    public String getID_MH() {
        return ID_MH;
    }

    public void setID_MH(String ID_MH) {
        this.ID_MH = ID_MH;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String TenMH) {
        this.TenMH = TenMH;
    }
    
}
