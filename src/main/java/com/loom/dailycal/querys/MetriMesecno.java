package com.loom.dailycal.querys;

import org.springframework.data.annotation.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "metri_mesecno3")
public class MetriMesecno {

    @Id
    private int korisnik;

    private float metri;

    private float vreme;

    public int getKorisnik() {
        return korisnik;
    }

    public float getMetri() {
        return metri;
    }

    public float getVreme() {
        return vreme;
    }
}
