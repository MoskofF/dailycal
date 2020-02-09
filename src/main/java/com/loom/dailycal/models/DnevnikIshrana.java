package com.loom.dailycal.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "dnevnici_za_ishrana")
public class DnevnikIshrana {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dnevnik_ishr_id")
    private int dnevnik_ishr_id;

    @Column(name = "datum")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datum;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "korisnik", nullable = false, referencedColumnName = "user_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Korisnik korisnik;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "obrok", nullable = false, referencedColumnName = "obrok_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Obrok obrok;

    public int getDnevnik_ishr_id() {
        return dnevnik_ishr_id;
    }

    public void setDnevnik_ishr_id(int dnevnik_ishr_id) {
        this.dnevnik_ishr_id = dnevnik_ishr_id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Obrok getObrok() {
        return obrok;
    }

    public void setObrok(Obrok obrok) {
        this.obrok = obrok;
    }
}
