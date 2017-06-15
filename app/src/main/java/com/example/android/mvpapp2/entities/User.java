package com.example.android.mvpapp2.entities;


public class User{

    private String name;
    private String address;
    private String email;
    private String image;

    public User(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

}
