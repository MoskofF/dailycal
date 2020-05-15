package com.loom.dailycal.models.wrapers;

import com.loom.dailycal.models.ObrokSh;

import java.util.ArrayList;
import java.util.List;

public class ObrokShWrap {

    private String opis_obrok;

    private List<obrok_pialok> pialoks;

    private List<obrok_hrana> hranas;

    public ObrokShWrap() {
        hranas = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            hranas.add(new obrok_hrana());
        pialoks = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            pialoks.add(new obrok_pialok());
    }

    public String getOpis_obrok() {
        return opis_obrok;
    }

    public void setOpis_obrok(String opis_obrok) {
        this.opis_obrok = opis_obrok;
    }

    public List<obrok_pialok> getPialoks() {
        return pialoks;
    }

    public void setPialoks(List<obrok_pialok> pialoks) {
        this.pialoks = pialoks;
    }

    public List<obrok_hrana> getHranas() {
        return hranas;
    }

    public void setHranas(List<obrok_hrana> hranas) {
        this.hranas = hranas;
    }
}
