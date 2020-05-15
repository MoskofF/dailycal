package com.loom.dailycal.models;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hrana")
public class Hrana {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hrana_id")
    private int hrana_id;

    @Column(name = "naziv_hrana")
    @NotNull
    //@UniqueElements
    private String naziv_hrana;

    @Column(name = "kalorii")
    @NotNull
    private int kalorii;

    public int getHrana_id() {
        return hrana_id;
    }

    public void setHrana_id(int hrana_id) {
        this.hrana_id = hrana_id;
    }

    public String getNaziv_hrana() {
        return naziv_hrana;
    }

    public void setNaziv_hrana(String naziv_hrana) {
        this.naziv_hrana = naziv_hrana;
    }

    public int getKalorii() {
        return kalorii;
    }

    public void setKalorii(int kalorii) {
        this.kalorii = kalorii;
    }

}
