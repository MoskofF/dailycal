package com.loom.dailycal.services;

import com.loom.dailycal.models.Obrok;
import com.loom.dailycal.repository.ObrokRepo;
import com.loom.dailycal.repository.ObrokShRepo;
import com.loom.dailycal.repository.ObrokSpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObrokService {

    @Autowired
    private ObrokRepo obrokRepo;

    @Autowired
    private ObrokShRepo obrokShRepo;

    @Autowired
    private ObrokSpRepo obrokSpRepo;

    public List<Obrok> getAllObrok() {
        return obrokRepo.findAll();
    }

    public void addObrok(Obrok obrok) {
        obrokRepo.save(obrok);
    }

    public Obrok getById(int id) {
        return obrokRepo.getOne(id);
    }

}
