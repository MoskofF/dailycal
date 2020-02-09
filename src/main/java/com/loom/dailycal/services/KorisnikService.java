package com.loom.dailycal.services;

import com.loom.dailycal.models.Korisnik;
import com.loom.dailycal.models.Role;
import com.loom.dailycal.repository.KorisnikRepo;
import com.loom.dailycal.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class KorisnikService implements KorisnikServiceInf{

    @Autowired
    private KorisnikRepo korisnikRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Korisnik getKorisnik(int user_id) {
        return korisnikRepo.getOne(user_id);
    }

    public List<Korisnik> getAllKorisnik() {
        return korisnikRepo.findAll();
    }

    public boolean updateKorisnik(int id, Korisnik korisnik) {
        if (korisnikRepo.getOne(id) == null) {
            return false;
        }

        return korisnikRepo.getOne(id).updateKorisnik(korisnik);
    }

    public boolean deleteKorisnik(int user_id) {
        try {
            korisnikRepo.deleteById(user_id);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public void save(Korisnik korisnik) {
        korisnik.setPassword(bCryptPasswordEncoder.encode(korisnik.getPassword()));
        korisnik.setPassword_conf(bCryptPasswordEncoder.encode(korisnik.getPassword_conf()));
        HashSet<Role> set = new HashSet<>();
        set.add(roleRepo.getOne(1));
        korisnik.setRoles(set);
        korisnikRepo.save(korisnik);
    }

    @Override
    public Korisnik findByUsername(String username) {
        return korisnikRepo.findByUsername(username);
    }
}
