package com.example.luatgiaothong.Entity;

public class DeThi {
    int maDe;
    String thoiGian;

    public DeThi() {
    }

    public DeThi(int maDe, String thoiGian) {
        this.maDe = maDe;
        this.thoiGian = thoiGian;
    }

    public int getMaDe() {
        return maDe;
    }

    public void setMaDe(int maDe) {
        this.maDe = maDe;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }


}
