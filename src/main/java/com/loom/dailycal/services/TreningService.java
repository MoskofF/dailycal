package com.loom.dailycal.services;

import com.loom.dailycal.models.Trening;
import com.loom.dailycal.repository.TreningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningService {

    @Autowired
    private TreningRepo treningRepo;

    public List<Trening> getAllTrening() {
        return treningRepo.findAll();
    }

    public void addTrening(Trening trening) {
        treningRepo.save(trening);
    }

    public Trening getById(int id) {
        return treningRepo.getOne(id);
    }
}
