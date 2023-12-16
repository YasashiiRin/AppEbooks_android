package com.example.e_books.Model;

public class TruyenYT {
    private int yid;
    private String ytentruyen;
    private String ynoidung;
    private String yimg;
    private int yid_tk;

    public TruyenYT(int yid, String ytentruyen, String ynoidung, String yimg, int yid_tk) {
        this.yid = yid;
        this.ytentruyen = ytentruyen;
        this.ynoidung = ynoidung;
        this.yimg = yimg;
        this.yid_tk = yid_tk;

    }

    public TruyenYT(String ytentruyen, String ynoidung, String yimg, int yid_tk) {
        this.ytentruyen = ytentruyen;
        this.ynoidung = ynoidung;
        this.yimg = yimg;
        this.yid_tk = yid_tk;
    }

    public int getYid() {
        return yid;
    }

    public void setYid(int yid) {
        this.yid = yid;
    }

    public String getYtentruyen() {
        return ytentruyen;
    }

    public void setYtentruyen(String ytentruyen) {
        this.ytentruyen = ytentruyen;
    }

    public String getYnoidung() {
        return ynoidung;
    }

    public void setYnoidung(String ynoidung) {
        this.ynoidung = ynoidung;
    }

    public String getYimg() {
        return yimg;
    }

    public void setYimg(String yimg) {
        this.yimg = yimg;
    }

    public int getYid_tk() {
        return yid_tk;
    }

    public void setYid_tk(int yid_tk) {
        this.yid_tk = yid_tk;
    }
}
