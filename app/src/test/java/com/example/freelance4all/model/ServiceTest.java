package com.example.freelance4all.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ServiceTest {

    @Test
    void getExperienceYears() {
        Service service = new Service(1,2,3,200.5,"descriere",10,"10-12");
        assertEquals(10,service.getExperienceYears());
    }

    @Test
    void setExperienceYears() {
        Service service = new Service(1,2,3,200.5,"descriere",10,"10-12");
        service.setExperienceYears(11);
        assertEquals(11,service.getExperienceYears());
    }

    @Test
    void getWorkSchedule() {
        Service service = new Service(1,2,3,200.5,"descriere",10,"10-12");
        assertEquals("10-12",service.getWorkSchedule());
    }

    @Test
    void setWorkSchedule() {
        Service service = new Service(1,2,3,200.5,"descriere",10,"10-12");
        service.setWorkSchedule("10-13");
        assertEquals("10-13",service.getWorkSchedule());
    }

    @Test
    void getPrice() {
        Service service = new Service(1,2,3,200.5,"descriere",10,"10-12");
        assertEquals(200.5, service.getPrice());
    }

    @Test
    void setPrice() {
        Service service = new Service(1,2,3,200.5,"descriere",10,"10-12");
        service.setPrice(300.5);
        assertEquals("300.5",service.getPrice());
    }

    @Test
    void getDescription() {
        Service service = new Service(1,2,3,200.5,"descriere",10,"10-12");
        assertEquals("descriere", service.getDescription());
    }

    @Test
    void setDescription() {
        Service service = new Service(1,2,3,200.5,"descriere",10,"10-12");
        service.setDescription("descriere1");
        assertEquals("descriere1",service.getDescription());
    }

}