package com.loom.dailycal.services;

import com.loom.dailycal.models.ObrokSh;
import com.loom.dailycal.repository.ObrokShRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObrokShService {

    @Autowired
    private ObrokShRepo obrokShRepo;

    public void addHranaToObrok(ObrokSh obrokSh) {
        obrokShRepo.save(obrokSh);
    }
}
