package com.loom.dailycal.relations;

import com.loom.dailycal.models.Hrana;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ObrokShKey implements Serializable {

    @Column(name = "obrok_id")
    private int obrok;

    @Column(name = "hrana_id")
    private int hrana;

    public ObrokShKey(int obrok, int hrana) {
        this.obrok = obrok;
        this.hrana = hrana;
    }

    public ObrokShKey(){}

    public int getObrok() {
        return obrok;
    }

    public void setObrok(int obrok) {
        this.obrok = obrok;
    }

    public int getHrana() {
        return hrana;
    }

    public void setHrana(int hrana) {
        this.hrana = hrana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObrokShKey)) return false;
        ObrokShKey that = (ObrokShKey) o;
        return getObrok() == that.getObrok() &&
                getHrana() == that.getHrana();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getObrok(), getHrana());
    }
}
