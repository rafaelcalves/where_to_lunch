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

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Establishment chosenEstablishment;

    @Column(name = "ending_date")
    @DateTimeFormat
    private LocalDateTime endingDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Establishment getChosenEstablishment() {
        return chosenEstablishment;
    }

    public void setChosenEstablishment(Establishment chosenEstablishment) {
        this.chosenEstablishment = chosenEstablishment;
    }

    public LocalDateTime getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDateTime endingDate) {
        this.endingDate = endingDate;
    }
}
