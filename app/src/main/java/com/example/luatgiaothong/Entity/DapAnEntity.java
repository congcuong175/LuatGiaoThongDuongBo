package com.example.luatgiaothong.Entity;

import com.google.gson.annotations.SerializedName;

public class DapAnEntity {
    @SerializedName("MADAPAN")
    private int maDA;
    @SerializedName("MACH")
    private int maCH;
    @SerializedName("DAPAN1")
    private String dapAN;
    @SerializedName("KIEMTRA")
    private boolean kiemTra;

    private int dapAnChoose;

    public DapAnEntity(int maDA, String dapAN, boolean kiemTra, int maCH) {
        this.maDA = maDA;
        this.dapAN = dapAN;
        this.kiemTra = kiemTra;
        this.maCH = maCH;
    }

    public int getMaCH() {
        return maCH;
    }

    public DapAnEntity() {
    }

    public void setMaCH(int maCH) {
        this.maCH = maCH;
    }

    public int getDapAnChoose() {
        return dapAnChoose;
    }

    public void setDapAnChoose(int dapAnChoose) {
        this.dapAnChoose = dapAnChoose;
    }

    public int getMaDA() {
        return maDA;
    }

    public void setMaDA(int maDA) {
        this.maDA = maDA;
    }

    public String getDapAN() {
        return dapAN;
    }

    public void setDapAN(String dapAN) {
        this.dapAN = dapAN;
    }

    public boolean getKiemTra() {
        return kiemTra;
    }

    public void setKiemTra(boolean kiemTra) {
        this.kiemTra = kiemTra;
    }

    public DapAnEntity(int maDA, String dapAN, boolean kiemTra) {
        this.maDA = maDA;
        this.dapAN = dapAN;
        this.kiemTra = kiemTra;
        this.dapAnChoose=0;
    }
}
