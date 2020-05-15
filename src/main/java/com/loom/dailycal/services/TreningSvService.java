package com.loom.dailycal.services;

import com.loom.dailycal.models.TreningSv;
import com.loom.dailycal.repository.TreningSvRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreningSvService {

    @Autowired
    private TreningSvRepo treningSvRepo;

    public void addVezhbaToTrening(TreningSv treningSv) {
        treningSvRepo.save(treningSv);
    }
}
