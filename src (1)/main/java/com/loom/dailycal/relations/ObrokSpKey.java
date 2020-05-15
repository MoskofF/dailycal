package com.loom.dailycal.relations;

import com.loom.dailycal.models.Pialok;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ObrokSpKey implements Serializable {

    @Column(name = "obrok_id")
    private int obrok;

    @Column(name = "pialok_id")
    private int pialok;

    public int getObrok() {
        return obrok;
    }

    public void setObrok(int obrok) {
        this.obrok = obrok;
    }

    public int getPialok() {
        return pialok;
    }

    public void setPialok(Pialok pialok) {
        this.pialok = pialok.getPialok_id();
    }

    public ObrokSpKey(int obrok, int pialok) {
        this.obrok = obrok;
        this.pialok = pialok;
    }

    public ObrokSpKey() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObrokSpKey)) return false;
        ObrokSpKey that = (ObrokSpKey) o;
        return getObrok() == that.getObrok() &&
                getPialok() == that.getPialok();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getObrok(), getPialok());
    }
}
