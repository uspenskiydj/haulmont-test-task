package com.haulmont.testtask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    @NotNull
    private Bank bank;

    public Customer() {
    }

    public Customer(String FIO, String phoneNumber, String email, String passportNumber, Bank bank) {
        this.FIO = FIO;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
        this.bank = bank;
    }

    public Customer(UUID id, String FIO, String phoneNumber, String email, String passportNumber, Bank bank) {
        super(id);
        this.FIO = FIO;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
        this.bank = bank;
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", FIO='" + FIO + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
