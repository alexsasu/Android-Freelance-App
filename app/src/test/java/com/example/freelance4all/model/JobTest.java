package com.example.freelance4all.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JobTest {

    @Test
    void getDomainOfWork() {
        Job job = new Job("domeniu1");
        assertEquals("domeniu1",job.getDomainOfWork());
    }

    @Test
    void setDomainOfWork() {
        Job job = new Job("domeniu1");
        job.setDomainOfWork("domeniu2");
        assertEquals("domeniu2",job.getDomainOfWork());
    }
}