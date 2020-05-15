package com.loom.dailycal.services;

import com.loom.dailycal.querys.MetriMesecno;
import com.loom.dailycal.querys.MetriNedelno;
import com.loom.dailycal.querys.MetriTriMesecno;
import com.loom.dailycal.repository.MetriMesecnoRepo;
import com.loom.dailycal.repository.MetriNedelnoRepo;
import com.loom.dailycal.repository.MetriTriMesecnoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetriService {

    @Autowired
    private MetriNedelnoRepo metriNedelnoRepo;

    @Autowired
    private MetriMesecnoRepo metriMesecnoRepo;

    @Autowired
    private MetriTriMesecnoRepo metriTriMesecnoRepo;

    public MetriNedelno getMetriNedelnoKorisnik(int id) {
        return metriNedelnoRepo.getOne(id);
    }

    public MetriMesecno getMetriMesecnoKorisnik(int id) {
        return metriMesecnoRepo.getOne(id);
    }

    public MetriTriMesecno getMetriTriMesecnoKorisnik(int id) {
        return metriTriMesecnoRepo.getOne(id);
    }
}
