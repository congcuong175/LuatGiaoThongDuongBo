package com.example.luatgiaothong.Entity;

import com.google.gson.annotations.SerializedName;

public class DeThi {
    @SerializedName("MABODE")
    int maDe;
    @SerializedName("GHICHU")
    String ghiChu;

    public DeThi() {
    }

    public DeThi(int maDe, String ghiChu) {
        this.maDe = maDe;
        this.ghiChu = ghiChu;
    }

    public int getMaDe() {
        return maDe;
    }

    public void setMaDe(int maDe) {
        this.maDe = maDe;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String thoiGian) {
        this.ghiChu = thoiGian;
    }


}
