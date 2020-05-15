package com.loom.dailycal.services;

import com.loom.dailycal.models.Vezhba;
import com.loom.dailycal.repository.VezhbaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VezhbaService {

    @Autowired
    private VezhbaRepo vezhbaRepo;

    public List<Vezhba> getAllVezhba() {
        return vezhbaRepo.findAll();
    }

    public void addVezhba(Vezhba vezhba) {
        vezhbaRepo.save(vezhba);
    }

    public Vezhba getVezhbaId(int id) {
        return vezhbaRepo.getOne(id);
    }
}
