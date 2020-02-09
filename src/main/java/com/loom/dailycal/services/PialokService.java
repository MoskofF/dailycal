package com.loom.dailycal.services;

import com.loom.dailycal.models.Pialok;
import com.loom.dailycal.repository.PialokRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PialokService {

    @Autowired
    private PialokRepo pialokRepo;

    public List<Pialok> getAllPialok() {
        return pialokRepo.findAll();
    }
}
