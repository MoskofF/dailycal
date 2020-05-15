package com.loom.dailycal.models;

import com.loom.dailycal.relations.ProgramaIshrSoKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "programi_za_ishrana_sodrzhat_obroci")
public class ProgramaIshrSo {

    @EmbeddedId
    private ProgramaIshrSoKey id;

    @ManyToOne
    @MapsId("programa_ishr")
    @JoinColumn(name = "programa_ishr", nullable = false, referencedColumnName = "programa_ishr_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private ProgramaIshrana programaIshrana;

    @ManyToOne
    @MapsId("den")
    @JoinColumn(name = "den", nullable = false, referencedColumnName = "den_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Den den;

    @ManyToOne
    @MapsId("obrok")
    @JoinColumn(name = "obrok", nullable = false, referencedColumnName = "obrok_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Obrok obrok;

    public ProgramaIshrSoKey getId() {
        return id;
    }

    public void setId(ProgramaIshrSoKey id) {
        this.id = id;
    }

    public ProgramaIshrana getProgramaIshrana() {
        return programaIshrana;
    }

    public void setProgramaIshrana(ProgramaIshrana programaIshrana) {
        this.programaIshrana = programaIshrana;
    }

    public Obrok getObrok() {
        return obrok;
    }

    public void setObrok(Obrok obrok) {
        this.obrok = obrok;
    }

    public Den getDen() {
        return den;
    }

    public void setDen(Den den) {
        this.den = den;
    }
}
