package com.loom.dailycal.services;

import com.loom.dailycal.models.ObrokSp;
import com.loom.dailycal.repository.ObrokSpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObrokSpService {

    @Autowired
    private ObrokSpRepo obrokSpRepo;

    public void addPialokToObrok(ObrokSp obrokSp) {
        obrokSpRepo.save(obrokSp);
    }
}
