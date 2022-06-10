package com.example.postolache_predescu_sandur_sasu.data;

import java.io.Serializable;

public class SellerDetails implements Serializable {
    private String email;
    private String description;
    private String phoneNumber;

    public SellerDetails() { }

    public SellerDetails(String email, String description, String phoneNumber) {
        this.email = email;
        this.description = description;
        this.phoneNumber = phoneNumber; }

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
