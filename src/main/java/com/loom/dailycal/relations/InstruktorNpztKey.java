package com.loom.dailycal.relations;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class InstruktorNpztKey implements Serializable {

    @Column(name = "programa_trening_id")
    private int programa_trening;

    @Column(name = "instruktor_id")
    private int instruktor;

    public int getPrograma_trening() {
        return programa_trening;
    }

    public void setPrograma_trening(int programa_trening) {
        this.programa_trening = programa_trening;
    }

    public int getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(int instruktor) {
        this.instruktor = instruktor;
    }
}
