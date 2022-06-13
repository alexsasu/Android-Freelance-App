package com.example.freelance4all.model;

import static org.junit.jupiter.api.Assertions.*;

import com.example.freelance4all.model.User;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void setType() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        user.setType("2");
        assertEquals("2", user.getType());
    }

    @Test
    void setEmail() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        user.setEmail("maria@yahoo.com");
        assertEquals("maria@yahoo.com", user.getEmail());
    }

    @Test
    void getType() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        assertEquals("1",user.getType());
    }


    @Test
    void getEmail() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        assertEquals("ana@yahoo.com",user.getEmail());
    }

    @Test
    void getPassword() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        assertEquals("1234568Mn*",user.getPassword());
    }

    @Test
    void setPassword() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        user.setPassword("Test1234!@");
        assertEquals("Test1234!@", user.getPassword());
    }

    @Test
    void getFirstName() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        assertEquals("Sarageaua",user.getFirstName());
    }

    @Test
    void setFirstName() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        user.setFirstName("Popescu");
        assertEquals("Popescu!@", user.getFirstName());
    }

    @Test
    void getLastName() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        assertEquals("Sarageaua",user.getLastName());
    }

    @Test
    void setLastName() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        user.setLastName("Maria");
        assertEquals("Maria", user.getLastName());
    }

    @Test
    void getDescription() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        assertEquals("Sarageaua",user.getDescription());
    }

    @Test
    void setDescription() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        user.setDescription("lala");
        assertEquals("lala", user.getDescription());
    }

    @Test
    void getPhoneNumber() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        assertEquals("Sarageaua",user.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        User user = new User("1","ana@yahoo.com","1234568Mn*","Sarageaua","Ana","descriere","0723935825");
        user.setPhoneNumber("0745640192");
        assertEquals("0745640192", user.getPhoneNumber());
    }
}