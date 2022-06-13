package com.example.freelance4all.classModels;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

import java.io.Serializable;

public class SellerDetails implements Serializable {

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "phoneNumber")
    private String phoneNumber;

    @Ignore
    public SellerDetails() {

    }

    public SellerDetails(String email, String description, String phoneNumber) {
        this.email = email;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "SellerDetails{" +
                "email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
