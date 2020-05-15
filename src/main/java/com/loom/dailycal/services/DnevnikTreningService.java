package com.loom.dailycal.services;

import com.loom.dailycal.models.DnevnikTrening;
import com.loom.dailycal.repository.DnevnikTreningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DnevnikTreningService {

    @Autowired
    private DnevnikTreningRepo dnevnikTreningRepo;

    public void addDnevnik(DnevnikTrening dnevnikTrening) {
        dnevnikTreningRepo.save(dnevnikTrening);
    }
}
