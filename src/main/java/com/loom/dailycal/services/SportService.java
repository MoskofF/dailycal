package com.loom.dailycal.services;

import com.loom.dailycal.models.Sport;
import com.loom.dailycal.repository.SportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {

    @Autowired
    private SportRepo sportRepo;

    public void addSport(Sport sport) {
        sportRepo.save(sport);
    }

    public List<Sport> getAllSport() {
        return sportRepo.findAll();
    }

    public Sport getSportId(int id) {
        return sportRepo.getOne(id);
    }
}
