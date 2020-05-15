package com.loom.dailycal.relations;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProgramaTreningStKey implements Serializable {

    @Column(name = "programa_trening_id")
    private int programa_trening;

    @Column(name = "den_id")
    private int den;

    @Column(name = "trening_id")
    private int trening;

    public int getPrograma_trening() {
        return programa_trening;
    }

    public void setPrograma_trening(int programa_trening) {
        this.programa_trening = programa_trening;
    }

    public int getTrening() {
        return trening;
    }

    public void setTrening(int trening) {
        this.trening = trening;
    }
}
