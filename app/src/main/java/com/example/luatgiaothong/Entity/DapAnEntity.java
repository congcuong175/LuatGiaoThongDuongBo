package com.example.luatgiaothong.Entity;

import com.google.gson.annotations.SerializedName;

public class DapAnEntity {
    @SerializedName("MaDA")
    private int maDA;
    @SerializedName("DapAN")
    private String dapAN;
    @SerializedName("KiemTra")
    private Boolean kiemTra;

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

    public Boolean getKiemTra() {
        return kiemTra;
    }

    public void setKiemTra(Boolean kiemTra) {
        this.kiemTra = kiemTra;
    }

    public DapAnEntity(int maDA, String dapAN, Boolean kiemTra) {
        this.maDA = maDA;
        this.dapAN = dapAN;
        this.kiemTra = kiemTra;
    }
}
