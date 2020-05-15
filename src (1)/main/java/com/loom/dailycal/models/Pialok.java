package com.loom.dailycal.models;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pialoci")
public class Pialok {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pialok_id")
    private int pialok_id;

    @Column(name = "naziv_pialok")
    @NotNull
    //@UniqueElements
    private String naziv_pialok;

    @Column(name = "kalorii")
    @NotNull
    private int kalorii;

    public int getPialok_id() {
        return pialok_id;
    }

    public void setPialok_id(int pialok_id) {
        this.pialok_id = pialok_id;
    }

    public String getNaziv_pialok() {
        return naziv_pialok;
    }

    public void setNaziv_pialok(String naziv_pialok) {
        this.naziv_pialok = naziv_pialok;
    }

    public int getKalorii() {
        return kalorii;
    }

    public void setKalorii(int kalorii) {
        this.kalorii = kalorii;
    }
}
