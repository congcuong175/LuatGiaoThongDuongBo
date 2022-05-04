package com.example.luatgiaothong.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LoaiCH {
    @SerializedName("MALCH")
    int maLCH;
    @SerializedName("TENLOAI")
    String tenLCH;
    @SerializedName("GHICHU")
    String ghiChu;
    List<CauHoiEntity> cauHoiEntityList;

    public List<CauHoiEntity> getCauHoiEntityList() {
        return cauHoiEntityList;
    }

    public void setCauHoiEntityList(List<CauHoiEntity> cauHoiEntityList) {
        this.cauHoiEntityList = cauHoiEntityList;
    }

    public LoaiCH(int maLCH, String tenLCH, String ghiChu, List<CauHoiEntity> cauHoiEntityList) {
        this.maLCH = maLCH;
        this.tenLCH = tenLCH;
        this.ghiChu = ghiChu;
        this.cauHoiEntityList = cauHoiEntityList;
    }

    public LoaiCH(int maLCH, String tenLCH, String ghiChu) {
        this.maLCH = maLCH;
        this.tenLCH = tenLCH;
        this.ghiChu = ghiChu;
        this.cauHoiEntityList=new ArrayList<>();
    }

    public int getMaLCH() {
        return maLCH;
    }

    public void setMaLCH(int maLCH) {
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
