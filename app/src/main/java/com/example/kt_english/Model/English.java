package com.example.kt_english.Model;
import java.io.Serializable;

public class English implements Serializable {
    private String id;
    private String ten;
    private String congThuc;

    public English(String id, String ten, String congThuc) {
        this.id = id;
        this.ten = ten;
        this.congThuc = congThuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCongThuc() {
        return congThuc;
    }

    public void setCongThuc(String congThuc) {
        this.congThuc = congThuc;
    }
}
