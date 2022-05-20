package com.example.postolache_predescu_sandur_sasu;

import java.io.Serializable;

public class ServiceCard implements Serializable {
    private String description;
    private String price;
    private String seller;
    private Integer idSeller;

    public ServiceCard() {

    }

    public ServiceCard(String description, String price, String seller, Integer idSeller) {
        this.description = description;
        this.price = price;
        this.seller = seller;
        this.idSeller = idSeller;
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

    public Integer getSellerId() {
        return idSeller;
    }

    public void setSellerId(Integer idSeller) {
        this.idSeller = idSeller;
    }

    @Override
    public String toString() {
        return "ServiceCard{" +
                "description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", seller='" + seller + '\'' +
                ", idSeller=" + idSeller +
                '}';
    }
}
