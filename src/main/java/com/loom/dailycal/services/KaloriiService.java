package com.loom.dailycal.services;

import com.loom.dailycal.querys.KaloriiMesecno;
import com.loom.dailycal.querys.KaloriiNedelno;
import com.loom.dailycal.querys.KaloriiTriMesecno;
import com.loom.dailycal.repository.KaloriiMesecnoRepo;
import com.loom.dailycal.repository.KaloriiNedelnoRepo;
import com.loom.dailycal.repository.KaloriiTriMesecnoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KaloriiService {

    @Autowired
    private KaloriiNedelnoRepo kaloriiNedelnoRepo;

    @Autowired
    private KaloriiMesecnoRepo kaloriiMesecnoRepo;

    @Autowired
    private KaloriiTriMesecnoRepo kaloriiTriMesecnoRepo;

    public KaloriiNedelno getNedelniKaloriiKorisnik(int id) {
        return kaloriiNedelnoRepo.getOne(id);
    }

    public KaloriiMesecno getMesecniKaloriiKorisnik(int id) {
        return  kaloriiMesecnoRepo.getOne(id);
    }

    public KaloriiTriMesecno getTriMesecniKaloriiKorisnik(int id) {
        return kaloriiTriMesecnoRepo.getOne(id);
    }
}
