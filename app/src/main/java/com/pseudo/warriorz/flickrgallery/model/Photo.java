package com.pseudo.warriorz.flickrgallery.model;

public class Photo {
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String owner;

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    private String secret;

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    private String server;

    public String getServer() {
        return this.server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    private int farm;

    public int getFarm() {
        return this.farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int ispublic;

    public int getIspublic() {
        return this.ispublic;
    }

    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }

    private int isfriend;

    public int getIsfriend() {
        return this.isfriend;
    }

    public void setIsfriend(int isfriend) {
        this.isfriend = isfriend;
    }

    private int isfamily;

    public int getIsfamily() {
        return this.isfamily;
    }

    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }

    private String url;

    public String getUrl() {
        return "http://farm"+this.getFarm()+".staticflickr.com/"+this.server+"/"+this.getId()+"_"+this.getSecret()+".jpg";
    }

}