package com.loom.dailycal.repository;

import com.loom.dailycal.models.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepo extends JpaRepository<Korisnik, Integer> {
    public Korisnik findByUsername(String username);
}
