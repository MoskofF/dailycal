package com.loom.dailycal.services;

import com.loom.dailycal.models.Hrana;
import com.loom.dailycal.repository.HranaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HranaService {

    @Autowired
    private HranaRepo hranaRepo;

    public List<Hrana> getAllHrana() {
        return hranaRepo.findAll();
    }
}
