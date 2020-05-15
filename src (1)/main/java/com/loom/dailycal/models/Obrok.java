package com.loom.dailycal.models;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "obroci")
public class Obrok {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "obrok_id")
    private int obrok_id;

    @Column(name = "opis_obrok")
    @NotNull
    //@UniqueElements
    private String opis_obrok;

    public int getObrok_id() {
        return obrok_id;
    }

    public void setObrok_id(int obrok_id) {
        this.obrok_id = obrok_id;
    }

    public String getOpis_obrok() {
        return opis_obrok;
    }

    public void setOpis_obrok(String opis_obrok) {
        this.opis_obrok = opis_obrok;
    }

    @Override
    public String toString() {
        return opis_obrok;
    }
}
