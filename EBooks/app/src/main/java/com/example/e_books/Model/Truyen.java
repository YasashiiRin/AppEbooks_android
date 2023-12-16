package com.example.e_books.Model;

import java.io.Serializable;

public class Truyen implements Serializable {
  private int tid;
  private String ttentruyen;
  private String tnoidung;
  private String timg;
  private int id_tk;

  public Truyen(int tid, String ttentruyen, String tnoidung, String timg, int id_tk) {
    this.tid = tid;
    this.ttentruyen = ttentruyen;
    this.tnoidung = tnoidung;
    this.timg = timg;
    this.id_tk = id_tk;
  }

  public Truyen(String ttentruyen, String tnoidung, String timg, int id_tk) {
    this.ttentruyen = ttentruyen;
    this.tnoidung = tnoidung;
    this.timg = timg;
    this.id_tk = id_tk;
  }

  public Truyen() {
  }
  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
  }

  public String getTtentruyen() {
    return ttentruyen;
  }

  public void setTtentruyen(String ttentruyen) {
    this.ttentruyen = ttentruyen;
  }

  public String getTnoidung() {
    return tnoidung;
  }

  public void setTnoidung(String tnoidung) {
    this.tnoidung = tnoidung;
  }

  public String getTimg() {
    return timg;
  }

  public void setTimg(String timg) {
    this.timg = timg;
  }

  public int getId_tk() {
    return id_tk;
  }

  public void setId_tk(int id_tk) {
    this.id_tk = id_tk;
  }
}
