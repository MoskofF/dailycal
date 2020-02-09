package com.loom.dailycal.relations;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class InstruktorNpziKey implements Serializable {

    @Column(name = "programa_ishr_id")
    private int programa_ishr;

    @Column(name = "instruktor_id")
    private int instruktor;

    public int getPrograma_ishr() {
        return programa_ishr;
    }

    public void setPrograma_ishr(int programa_ishr) {
        this.programa_ishr = programa_ishr;
    }

    public int getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(int instruktor) {
        this.instruktor = instruktor;
    }
}
