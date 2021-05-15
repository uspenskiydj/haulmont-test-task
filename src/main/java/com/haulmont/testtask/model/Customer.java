package com.haulmont.testtask.model;

public class Customer extends AbstractBaseEntity {

    private String FIO;

    private String phoneNumber;

    private String email;

    private String passportNumber;

    public Customer() {
    }

    public Customer(String FIO, String phoneNumber, String email, String passportNumber) {
        this.FIO = FIO;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
