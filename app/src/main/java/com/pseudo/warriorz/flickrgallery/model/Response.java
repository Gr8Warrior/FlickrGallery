package com.pseudo.warriorz.flickrgallery.model;

public class Response {
    private Photos photos;

    public Photos getPhotos() {
        return this.photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    private String stat;

    public String getStat() {
        return this.stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}