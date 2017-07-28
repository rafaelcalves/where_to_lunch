package com.sap.wtl.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "establishment")
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "address")
    @NotBlank
    private String address;

    @Column(name = "average_price")
    private double averagePrice;

    @Column(name = "alelo_accepted")
    private boolean aleloAccepted;

    @Column(name = "image")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public boolean isAleloAccepted() {
        return aleloAccepted;
    }

    public void setAleloAccepted(boolean aleloAccepted) {
        this.aleloAccepted = aleloAccepted;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
