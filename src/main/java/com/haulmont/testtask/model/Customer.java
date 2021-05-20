package com.haulmont.testtask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer extends AbstractBaseEntity {

    @Column(name = "fio", nullable = false)
    @NotBlank
    @Size(min = 3, max = 255)
    private String FIO;

    @Column(name = "phone_number", nullable = false)
    @NotBlank
    @Size(min = 3, max = 30)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "passport_number", nullable = false, unique = true)
    @NotBlank
    @Size(min = 3, max = 30)
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
