package com.example.freelance4all.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CityTest {

    @Test
    void getName() {
        City city = new City("Bucuresti");
        assertEquals("Bucuresti",city.getName());
    }

    @Test
    void setName() {
        City city = new City("Bucuresti");
        city.setName("Galati");
        assertEquals("Galati",city.getName());
    }
}