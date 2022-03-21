package com.example.luatgiaothong.Entity;

import java.util.List;

public class CauHoiEntity {
    private int maCH;
    private String noiDung;
    private String hinhAnh;
    private List<DapAnEntity> dapAnEntities;
    private boolean ktdung;

    public boolean isKtdung() {
        return ktdung;
    }

    public void setKtdung(boolean ktdung) {
        this.ktdung = ktdung;
    }

    public int getMaCH() {
        return maCH;
    }

    public void setMaCH(int maCH) {
        this.maCH = maCH;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public List<DapAnEntity> getDapAnEntities() {
        return dapAnEntities;
    }

    public void setDapAnEntities(List<DapAnEntity> dapAnEntities) {
        this.dapAnEntities = dapAnEntities;
    }

    public CauHoiEntity(int maCH, String noiDung, String hinhAnh, List<DapAnEntity> dapAnEntities) {
        this.maCH = maCH;
        this.noiDung = noiDung;
        this.hinhAnh = hinhAnh;
        this.dapAnEntities = dapAnEntities;
    }
}
