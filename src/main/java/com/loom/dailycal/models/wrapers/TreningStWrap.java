package com.loom.dailycal.models.wrapers;

import com.loom.dailycal.models.Vezhba;

import java.util.ArrayList;
import java.util.List;

public class TreningStWrap {

    private String opis_trening;
    private int sport;
    private List<trening_vezhba> vezhbas;

    public TreningStWrap() {
        vezhbas = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            vezhbas.add(new trening_vezhba());
        }
    }

    public String getOpis_trening() {
        return opis_trening;
    }

    public void setOpis_trening(String opis_trening) {
        this.opis_trening = opis_trening;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }

    public List<trening_vezhba> getVezhbas() {
        return vezhbas;
    }

    public void setVezhbas(List<trening_vezhba> vezhbas) {
        this.vezhbas = vezhbas;
    }
}
