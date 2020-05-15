package com.loom.dailycal.models;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "programi_za_ishrana")
public class ProgramaIshrana {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "programa_ishr_id")
    private int programa_ishr_id;

    @Column(name = "ime_programa_ishr")
    @NotNull
    @UniqueElements
    private String ime_programa_ishr;

    public int getPrograma_ishr_id() {
        return programa_ishr_id;
    }

    public void setPrograma_ishr_id(int programa_ishr_id) {
        this.programa_ishr_id = programa_ishr_id;
    }

    public String getIme_programa_ishr() {
        return ime_programa_ishr;
    }

    public void setIme_programa_ishr(String ime_programa_ishr) {
        this.ime_programa_ishr = ime_programa_ishr;
    }

    @Override
    public String toString() {
        return ime_programa_ishr;
    }
}
