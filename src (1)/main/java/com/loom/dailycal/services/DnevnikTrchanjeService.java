package com.loom.dailycal.services;

import com.loom.dailycal.models.DnevnikRun;
import com.loom.dailycal.repository.DnevnikTrchanjeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DnevnikTrchanjeService {

    @Autowired
    private DnevnikTrchanjeRepo dnevnikTrchanjeRepo;

    public void addDnevnik(DnevnikRun dnevnikRun) {
        dnevnikTrchanjeRepo.save(dnevnikRun);
    }
}
