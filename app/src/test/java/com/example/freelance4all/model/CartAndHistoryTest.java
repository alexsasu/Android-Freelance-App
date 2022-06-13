package com.example.freelance4all.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CartAndHistoryTest {

    @Test
    void getType() {
        CartAndHistory cartAndHistory = new CartAndHistory(1,2,2,"2022/11/11","bun");
        assertEquals(2,cartAndHistory.getType());
    }

    @Test
    void setType() {
        CartAndHistory cartAndHistory = new CartAndHistory(1,2,2,"2022/11/11","bun");
        cartAndHistory.setType(1);
        assertEquals(1,cartAndHistory.getType());
    }

    @Test
    void getFeedback() {
        CartAndHistory cartAndHistory = new CartAndHistory(1,2,2,"2022/11/11","bun");
        assertEquals("bun",cartAndHistory.getFeedback());
    }

    @Test
    void setFeedback() {
        CartAndHistory cartAndHistory = new CartAndHistory(1,2,2,"2022/11/11","bun");
        cartAndHistory.setFeedback("tare bun");
        assertEquals("tare bun",cartAndHistory.getFeedback());
    }

    @Test
    void getDate() {
        CartAndHistory cartAndHistory = new CartAndHistory(1,2,2,"2022/11/11","bun");
        assertEquals("2022/11/11",cartAndHistory.getDate());
    }

    @Test
    void setDate() {
        CartAndHistory cartAndHistory = new CartAndHistory(1,2,2,"2022/11/11","bun");
        cartAndHistory.setDate("2022/11/10");
        assertEquals("2022/11/10",cartAndHistory.getDate());
    }
}