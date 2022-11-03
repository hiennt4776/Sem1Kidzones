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
public class ChucVu {
    private String ID_CV;
    private String TenCV;

    public ChucVu() {
    }

    public ChucVu(String ID_CV, String TenCV) {
        this.ID_CV = ID_CV;
        this.TenCV = TenCV;
    }

    public String getID_CV() {
        return ID_CV;
    }

    public void setID_CV(String ID_CV) {
        this.ID_CV = ID_CV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
    }
    
    
    
}
