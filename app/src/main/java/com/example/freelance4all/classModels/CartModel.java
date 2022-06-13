package com.example.freelance4all.classModels;

public class CartModel {

    private Integer idCart;
    private String person;
    private String job;
    private String price;

    public CartModel(Integer idCart, String person, String job, String price) {
        this.idCart = idCart;
        this.job = job;
        this.person = person;
        this.price = price;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
