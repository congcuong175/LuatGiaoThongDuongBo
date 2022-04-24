package com.example.luatgiaothong.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CauHoiEntity {
    @SerializedName("MaCH")
    private int maCH;
    @SerializedName("NoiDung")
    private String noiDung;
    @SerializedName("HinhAnh")
    private String hinhAnh;
    @SerializedName("DapAnEntities")
    private List<DapAnEntity> dapAnEntities;


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
