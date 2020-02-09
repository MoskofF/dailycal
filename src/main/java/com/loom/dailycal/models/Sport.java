package com.loom.dailycal.models;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sportovi")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sport_id")
    private int sport_id;

    @Column(name = "naziv_sport")
    @NotNull
    @UniqueElements
    private String naziv_sport;

    public int getSport_id() {
        return sport_id;
    }

    public void setSport_id(int sport_id) {
        this.sport_id = sport_id;
    }

    public String getNaziv_sport() {
        return naziv_sport;
    }

    public void setNaziv_sport(String naziv_sport) {
        this.naziv_sport = naziv_sport;
    }

}
