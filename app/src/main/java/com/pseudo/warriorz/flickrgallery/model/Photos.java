package com.pseudo.warriorz.flickrgallery.model;

import java.util.ArrayList;

public class Photos {
    private int page;

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private int pages;

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    private int perpage;

    public int getPerpage() {
        return this.perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    private int total;

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private ArrayList<Photo> photo;

    public ArrayList<Photo> getPhoto() {
        return this.photo;
    }

    public void setPhoto(ArrayList<Photo> photo) {
        this.photo = photo;
    }
}