package com.loom.dailycal.services;

import com.loom.dailycal.models.DnevnikIshrana;
import com.loom.dailycal.repository.DnevnikIshrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DnevnikIshranaService {

    @Autowired
    private DnevnikIshrRepo dnevnikIshrRepo;

    public void addDnevnik(DnevnikIshrana dnevnikIshrana){
        dnevnikIshrRepo.save(dnevnikIshrana);
    }
}
