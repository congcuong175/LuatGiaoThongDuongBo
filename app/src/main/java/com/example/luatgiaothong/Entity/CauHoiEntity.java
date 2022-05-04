package com.example.luatgiaothong.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CauHoiEntity {
    @SerializedName("MACH")
    private int maCH;
    @SerializedName("NOIDUNG")
    private String noiDung;
    @SerializedName("HINHANH")
    private String hinhAnh;
    @SerializedName("MALCH")
    private int maLCH;
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

    public int getMaLCH() {
        return maLCH;
    }

    public void setMaLCH(int maLCH) {
        this.maLCH = maLCH;
    }

    public CauHoiEntity(int maCH, String noiDung, String hinhAnh, List<DapAnEntity> dapAnEntities) {
        this.maCH = maCH;
        this.noiDung = noiDung;
        this.hinhAnh = hinhAnh;
        this.dapAnEntities = dapAnEntities;
    }

    public CauHoiEntity(int maCH, String noiDung, String hinhAnh, int maLCH) {
        this.maCH = maCH;
        this.noiDung = noiDung;
        this.hinhAnh = hinhAnh;
        this.maLCH = maLCH;
    }

    public CauHoiEntity() {
        dapAnEntities=new ArrayList<>();
    }
}
