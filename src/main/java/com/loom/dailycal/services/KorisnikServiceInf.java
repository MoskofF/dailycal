package com.loom.dailycal.services;

import com.loom.dailycal.models.Korisnik;

public interface KorisnikServiceInf {
    void save(Korisnik korisnik);

    Korisnik findByUsername(String username);
}
