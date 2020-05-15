package com.loom.dailycal.querys;

import org.springframework.data.annotation.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "nedelen_kal3")
public class KaloriiNedelno {

    @Id
    private int korisnik;

    private float kalorii;

    public int getKorisnik() {
        return korisnik;
    }

    public float getKalorii() {
        return kalorii;
    }
}
