package com.example.luatgiaothong.Entity;

public class ChiTietDe {
    int MABODE;
    int MACH;

    public ChiTietDe() {
    }

    public int getMABODE() {
        return MABODE;
    }

    public void setMABODE(int MABODE) {
        this.MABODE = MABODE;
    }

    public int getMACH() {
        return MACH;
    }

    public void setMACH(int MACH) {
        this.MACH = MACH;
    }

    public ChiTietDe(int MABODE, int MACH) {
        this.MABODE = MABODE;
        this.MACH = MACH;
    }
}
