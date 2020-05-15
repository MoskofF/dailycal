package com.loom.dailycal.services;

import com.loom.dailycal.models.ProgramaTrening;
import com.loom.dailycal.repository.ProgramaTreningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramaTreningService {

    @Autowired
    private ProgramaTreningRepo programaTreningRepo;

    public List<ProgramaTrening> getAllProgramaTrening() {
        return programaTreningRepo.findAll();
    }
}
