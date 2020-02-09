package com.loom.dailycal.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "dnevnici_za_trening")
public class DnevnikTrening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dnevnik_trening_id")
    private int dnevnik_trening_id;

    @Column(name = "datum")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "korisnik", nullable = false, referencedColumnName = "user_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Korisnik korisnik;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trening", nullable = false, referencedColumnName = "trening_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Trening trening;

    public int getDnevnik_trening_id() {
        return dnevnik_trening_id;
    }

    public void setDnevnik_trening_id(int dnevnik_trening_id) {
        this.dnevnik_trening_id = dnevnik_trening_id;
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

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }
}
