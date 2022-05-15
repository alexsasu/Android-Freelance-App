package com.example.postolache_predescu_sandur_sasu.data;

import java.util.Date;

public class CartModel {

    private String service;
    private String person;

    public CartModel(String service, String person) {
        this.service = service;
        this.person = person;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
