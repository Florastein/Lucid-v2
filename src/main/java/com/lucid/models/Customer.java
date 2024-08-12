package com.lucid.models;

public class Customer {
    private String Firstname;
    private String Lastname;
    private String Email;
    private String Phone;
    private String DoB;
    private String Gender;
    private String Address;
    private String License_Number;
    private String License_Type;
    private String License_DoE;
    private String NationalID;


    public Customer() {}

    public String getFirstname() {
        return Firstname;
    }
    public void setFirstname(String firstname) {
        Firstname = firstname;
    }
    public String getLastname() {
        return Lastname;
    }
    public void setLastname(String lastname) {
        Lastname = lastname;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getDoB() {
        return DoB;
    }
    public void setDoB(String doB) {
        DoB = doB;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getLicense_Number() {
        return License_Number;
    }
    public void setLicense_Number(String license_Number) {
        License_Number = license_Number;
    }
    public String getLicense_Type() {
        return License_Type;
    }
    public void setLicense_Type(String license_Type) {
        License_Type = license_Type;
    }
    public String getLicense_DoE() {
        return License_DoE;
    }
    public void setLicense_DoE(String license_DoE) {
        License_DoE = license_DoE;
    }
    public String getNationalID() {
        return NationalID;
    }
    public void setNationalID(String nationalID) {
        NationalID = nationalID;
    }

    public Customer(String firstname, String lastname, String email, String phone, String doB, String gender, String address, String license_Number, String license_Type, String license_DoE, String nationalID) {
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
        Phone = phone;
        DoB = doB;
        Gender = gender;
        Address = address;
        License_Number = license_Number;
        License_Type = license_Type;
        License_DoE = license_DoE;
        NationalID = nationalID;
    }
}
