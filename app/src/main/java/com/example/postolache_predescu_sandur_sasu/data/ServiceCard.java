package com.example.postolache_predescu_sandur_sasu.data;

import java.io.Serializable;

public class ServiceCard implements Serializable {
    private String description;
    private String price;
    private String seller;
    private Integer idSeller;
    private Integer idService;

    public ServiceCard() {

    }

    public ServiceCard(String description, String price, String seller, Integer idSeller, Integer idService) {
        this.description = description;
        this.price = price;
        this.seller = seller;
        this.idSeller = idSeller;
        this.idService = idService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(Integer idSeller) {
        this.idSeller = idSeller;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "ServiceCard{" +
                "description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", seller='" + seller + '\'' +
                ", idSeller=" + idSeller +
                ", idService=" + idService +
                '}';
    }
}