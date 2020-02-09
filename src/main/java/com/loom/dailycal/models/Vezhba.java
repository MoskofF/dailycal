package com.loom.dailycal.models;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vezhbi")
public class Vezhba {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vezhba_id")
    private int vezhba_id;

    @Column(name = "naziv_vezhba")
    @NotNull
    @UniqueElements
    private String naziv_vezhba;

    @Column(name = "tezhina_vezhba")
    @NotNull
    private int tezhina_vezhba;

    public int getVezhba_id() {
        return vezhba_id;
    }

    public void setVezhba_id(int vezhba_id) {
        this.vezhba_id = vezhba_id;
    }

    public String getNaziv_vezhba() {
        return naziv_vezhba;
    }

    public void setNaziv_vezhba(String naziv_vezhba) {
        this.naziv_vezhba = naziv_vezhba;
    }

    public int getTezhina_vezhba() {
        return tezhina_vezhba;
    }

    public void setTezhina_vezhba(int tezhina_vezhba) {
        this.tezhina_vezhba = tezhina_vezhba;
    }
}
