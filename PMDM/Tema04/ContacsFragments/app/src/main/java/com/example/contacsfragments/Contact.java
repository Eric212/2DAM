package com.example.contacsfragments;

import android.media.Image;

public class Contact {
    private int id;
    private String firstName;
    private String surName;
    private Image photo;
    private String birthday;
    private String company;
    private String email;
    private String mainPhone;
    private String secondaryPhone;
    private String address;

    public Contact(int id, String firstName, String surName, Image photo, String birthday, String company, String email, String mainPhone, String secondaryPhone, String address) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.photo = photo;
        this.birthday = birthday;
        this.company = company;
        this.email = email;
        this.mainPhone = mainPhone;
        this.secondaryPhone = secondaryPhone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
