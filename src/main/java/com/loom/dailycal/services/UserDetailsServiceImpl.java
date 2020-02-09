package com.loom.dailycal.services;

import com.loom.dailycal.models.FitnesInstruktor;
import com.loom.dailycal.models.Korisnik;
import com.loom.dailycal.models.Role;
import com.loom.dailycal.repository.InstruktorRepo;
import com.loom.dailycal.repository.KorisnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private KorisnikRepo korisnikRepo;

    @Autowired
    private InstruktorRepo instruktorRepo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Korisnik korisnik = korisnikRepo.findByUsername(username);
        FitnesInstruktor instruktor = instruktorRepo.findByUsername(username);

        if (korisnik == null && instruktor == null) {
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if (instruktor == null) {
            for (Role r : korisnik.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getRole_name()));
                return new org.springframework.security.core.userdetails.User(korisnik.getUsername(), korisnik.getPassword(), grantedAuthorities);
            }
        } else {
            for (Role r : instruktor.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getRole_name()));
                return new org.springframework.security.core.userdetails.User(instruktor.getUsername(), instruktor.getPassword(), grantedAuthorities);
            }
        }

        return null;

    }
}
