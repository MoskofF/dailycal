package com.loom.dailycal.services;

import com.loom.dailycal.models.FitnesInstruktor;
import com.loom.dailycal.models.Role;
import com.loom.dailycal.repository.InstruktorRepo;
import com.loom.dailycal.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class InstruktorService {

    @Autowired
    private InstruktorRepo instruktorRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public FitnesInstruktor getInstruktor(int instruktor_id) {
        return instruktorRepo.getOne(instruktor_id);
    }

    public List<FitnesInstruktor> getAllInstruktor() {
        return instruktorRepo.findAll();
    }

    public void addInstruktor(FitnesInstruktor instruktor) {
        instruktor.setPassword(bCryptPasswordEncoder.encode(instruktor.getPassword()));
        instruktor.setPassword_conf(bCryptPasswordEncoder.encode(instruktor.getPassword_conf()));
        HashSet<Role> set = new HashSet<>();
        set.add(roleRepo.getOne(2));
        instruktor.setRoles(set);
        instruktorRepo.save(instruktor);
    }

    public boolean updateInstruktor(int id, FitnesInstruktor instruktor) {
        if (instruktorRepo.getOne(id) == null) {
            return false;
        }

        return instruktorRepo.getOne(id).update(instruktor);
    }

    public boolean deleteInstruktor(int instruktor_id) {
        try {
            instruktorRepo.deleteById(instruktor_id);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public FitnesInstruktor findByUsername(String username) {
        return instruktorRepo.findByUsername(username);
    }
}
