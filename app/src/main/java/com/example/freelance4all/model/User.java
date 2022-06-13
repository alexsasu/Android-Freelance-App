package com.example.freelance4all.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "userTable",
        indices = {@Index(value ="idUser", unique = true)})

public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idUser")
    private Integer idUser;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "firstName")
    private String firstName;

    @ColumnInfo(name = "lastName")
    private String lastName;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "phoneNumber")
    private String phoneNumber;

    @ColumnInfo(name = "deleted")
    private Boolean deleted;

    @Ignore
    public User() {}

    public User(@NonNull String type, @NonNull String email, @NonNull String password, @NonNull String firstName,
                @NonNull String lastName, String description, String phoneNumber) {

        this.type = type;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = null;
        this.phoneNumber = null;
        this.deleted = false;

        if (type.equalsIgnoreCase("seller")) {
            this.description = description;
            this.phoneNumber = phoneNumber;
        }
    }

    @Ignore
    public User(@NonNull Integer idUser,@NonNull String type, @NonNull String email, @NonNull String password, @NonNull String firstName,
                @NonNull String lastName, String description, String phoneNumber) {
        this.idUser = idUser;
        this.type = type;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }

    @Ignore
    public User(String phoneNumber) {
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getType() {
        return type;
    }

    public void setIdUser(@NonNull Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", type='" + type + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}