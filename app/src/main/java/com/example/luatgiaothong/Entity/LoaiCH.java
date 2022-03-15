package com.example.luatgiaothong.Entity;

public class LoaiCH {
    String maLCH;
    String tenLCH;
    String ghiChu;

    public LoaiCH(String maLCH, String tenLCH, String ghiChu) {
        this.maLCH = maLCH;
        this.tenLCH = tenLCH;
        this.ghiChu = ghiChu;
    }

    public String getMaLCH() {
        return maLCH;
    }

    public void setMaLCH(String maLCH) {
        this.maLCH = maLCH;
    }

    public String getTenLCH() {
        return tenLCH;
    }

    public void setTenLCH(String tenLCH) {
        this.tenLCH = tenLCH;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
