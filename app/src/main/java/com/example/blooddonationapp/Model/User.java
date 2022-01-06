package com.example.blooddonationapp.Model;

public class User {

    String NIK, bloodgroup, email, id, name, phonenumber, profilepictureurl, search, type;

    public User() {
    }

    public User(String NIK, String bloodgroup, String email, String id, String name, String phonenumber, String profilepictureurl, String search, String type) {
        this.NIK = NIK;
        this.bloodgroup = bloodgroup;
        this.email = email;
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.profilepictureurl = profilepictureurl;
        this.search = search;
        this.type = type;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getProfilepictureurl() {
        return profilepictureurl;
    }

    public void setProfilepictureurl(String profilepictureurl) {
        this.profilepictureurl = profilepictureurl;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
