package com.example.luatgiaothong.Entity;

import com.google.gson.annotations.SerializedName;

public class MeoThi {
    @SerializedName("MAMEO")
     String maMeo;
    @SerializedName("TENMEO")
     String title;
    @SerializedName("NOIDUNG")
     String content;

    public MeoThi() {
    }

    public MeoThi(String maMeo, String title, String content) {
        this.maMeo = maMeo;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MeoThi(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getMaMeo() {
        return maMeo;
    }

    public void setMaMeo(String maMeo) {
        this.maMeo = maMeo;
    }
}
