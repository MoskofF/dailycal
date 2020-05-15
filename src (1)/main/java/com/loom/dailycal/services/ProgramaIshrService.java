package com.loom.dailycal.services;

import com.loom.dailycal.models.ProgramaIshrana;
import com.loom.dailycal.repository.ProgramaIshrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramaIshrService {

    @Autowired
    private ProgramaIshrRepo programaIshrRepo;

    public List<ProgramaIshrana> getAllProgramaIshr() {
        return programaIshrRepo.findAll();
    }
}
