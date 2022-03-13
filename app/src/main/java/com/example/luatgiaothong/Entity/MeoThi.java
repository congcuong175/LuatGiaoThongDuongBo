package com.example.luatgiaothong.Entity;

public class MeoThi {
    private String title;
    private String content;

    public MeoThi() {
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
}
