package com.loom.dailycal.services;

import com.loom.dailycal.models.Cel;
import com.loom.dailycal.repository.CelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelService {

    @Autowired
    private CelRepo celRepo;

    public List<Cel> getAllCel() {
        return celRepo.findAll();
    }
}
