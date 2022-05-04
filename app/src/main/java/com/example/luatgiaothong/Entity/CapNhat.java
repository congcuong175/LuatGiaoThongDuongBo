package com.example.luatgiaothong.Entity;

public class CapNhat {
    int MACN;
    String TenCN;

    public CapNhat() {
    }

    public CapNhat(int MACN, String tenCN) {
        this.MACN = MACN;
        TenCN = tenCN;
    }

    public int getMACN() {
        return MACN;
    }

    public void setMACN(int MACN) {
        this.MACN = MACN;
    }

    public String getTenCN() {
        return TenCN;
    }

    public void setTenCN(String tenCN) {
        TenCN = tenCN;
    }
}
