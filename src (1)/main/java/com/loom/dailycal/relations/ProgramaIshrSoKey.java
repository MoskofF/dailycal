package com.loom.dailycal.relations;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProgramaIshrSoKey implements Serializable {

    @Column(name = "programa_ishr_id")
    private int programa_ishr;

    @Column(name = "den_id")
    private int den;

    @Column(name = "obrok_id")
    private int obrok;

    public int getPrograma_ishr() {
        return programa_ishr;
    }

    public void setPrograma_ishr(int programa_ishr) {
        this.programa_ishr = programa_ishr;
    }

    public int getObrok() {
        return obrok;
    }

    public void setObrok(int obrok) {
        this.obrok = obrok;
    }
}
