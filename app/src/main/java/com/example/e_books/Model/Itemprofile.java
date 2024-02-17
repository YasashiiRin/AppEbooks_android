package com.example.e_books.Model;

public class Itemprofile {
    private String nameitem;
    private int hinhanhitem;


    public Itemprofile(String nameitem) {
        this.nameitem = nameitem;
    }

    public String getNameitem() {
        return nameitem;
    }

    public void setNameitem(String nameitem) {
        this.nameitem = nameitem;
    }

    public int getHinhanhitem() {
        return hinhanhitem;
    }

    public void setHinhanhitem(int hinhanhitem) {
        this.hinhanhitem = hinhanhitem;
    }
}
