package com.loom.dailycal.models;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "programi_za_trening")
public class ProgramaTrening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "programa_trening_id")
    private int programa_trening_id;

    @Column(name = "ime_programa_trening")
    @NotNull
    @UniqueElements
    private String ime_programa_trening;

    public int getPrograma_trening_id() {
        return programa_trening_id;
    }

    public void setPrograma_trening_id(int programa_trening_id) {
        this.programa_trening_id = programa_trening_id;
    }

    public String getIme_programa_trening() {
        return ime_programa_trening;
    }

    public void setIme_programa_trening(String ime_programa_trening) {
        this.ime_programa_trening = ime_programa_trening;
    }

    @Override
    public String toString() {
        return ime_programa_trening;
    }
}
