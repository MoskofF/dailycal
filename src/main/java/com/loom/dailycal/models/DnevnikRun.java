package com.loom.dailycal.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "dnevnici_za_trchanje")
public class DnevnikRun {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dnevnik_run_id")
    private int dnevnik_run_id;

    @Column(name = "datum")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datum;

    @Column(name = "metri")
    @NotNull
    private float metri;

    @Column(name = "vreme_min")
    private float vreme_min;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "korisnik", nullable = false, referencedColumnName = "user_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Korisnik korisnik;

    public int getDnevnik_run_id() {
        return dnevnik_run_id;
    }

    public void setDnevnik_run_id(int dnevnik_run_id) {
        this.dnevnik_run_id = dnevnik_run_id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public float getMetri() {
        return metri;
    }

    public void setMetri(float metri) {
        this.metri = metri;
    }

    public float getVreme_min() {
        return vreme_min;
    }

    public void setVreme_min(float vreme_min) {
        this.vreme_min = vreme_min;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
