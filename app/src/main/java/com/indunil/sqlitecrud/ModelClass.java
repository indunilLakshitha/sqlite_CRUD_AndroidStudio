package com.indunil.sqlitecrud;

public class ModelClass {

    int ID;
    String Name,Mobile,Email,Address;

    public ModelClass(int ID, String name, String mobile, String email, String address) {
        this.ID = ID;
        this.Name = name;
        this.Mobile = mobile;
        this.Email = email;
        this.Address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
