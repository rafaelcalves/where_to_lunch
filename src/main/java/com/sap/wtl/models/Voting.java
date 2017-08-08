package com.sap.wtl.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voting")
public class Voting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    private Establishment chosenEstablishment;

    @Column(name = "date")
    @DateTimeFormat
    private LocalDateTime date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Establishment getChosenEstablishment() {
        return chosenEstablishment;
    }

    public void setChosenEstablishment(Establishment chosenEstablishment) {
        this.chosenEstablishment = chosenEstablishment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
