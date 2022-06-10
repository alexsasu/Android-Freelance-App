package com.example.postolache_predescu_sandur_sasu.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

//@Entity(tableName = "userTable", indices = {@Index(value ="idUser", unique = true)})

@Entity(tableName = "userTable",
        indices = {@Index(value ="idUser", unique = true)})

public class User {

    @PrimaryKey()
    private Integer idUser;

    @ColumnInfo(name = "type")
    private Integer type;

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

    private static Integer newIdUser = 1;

    public User() {}

    public User(@NonNull Integer type, @NonNull String email, @NonNull String password, @NonNull String firstName,
                @NonNull String lastName, String description, String phoneNumber) {
        this.idUser = newIdUser;
        this.type = type;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = null;
        this.phoneNumber = phoneNumber;

        if (type == 1) {
            this.description = description;
            this.phoneNumber = phoneNumber;
        }

        ++ newIdUser;
    }

    public User(String phoneNumber) {
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
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

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", type=" + type +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}