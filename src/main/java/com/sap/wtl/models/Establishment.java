package com.sap.wtl.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


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

    @OneToMany(
            mappedBy = "establishment",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Vote> vote;

    public Establishment(int id,String name, String address, double averagePrice, boolean aleloAccepted, String image, List<Vote> vote) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.averagePrice = averagePrice;
        this.aleloAccepted = aleloAccepted;
        this.image = image;
        this.vote = vote;
    }

    public Establishment() {
    }

    public List<Vote> getVote() {
        return vote;
    }

    public void setVote(List<Vote> vote) {
        this.vote = vote;
    }

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
