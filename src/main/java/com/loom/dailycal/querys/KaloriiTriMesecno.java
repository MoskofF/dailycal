package com.loom.dailycal.querys;

import org.springframework.data.annotation.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "tri_mesecen_kal3")
public class KaloriiTriMesecno {

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
