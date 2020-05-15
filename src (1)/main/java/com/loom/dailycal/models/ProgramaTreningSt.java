package com.loom.dailycal.models;

import com.loom.dailycal.relations.ProgramaTreningStKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "programi_za_trening_sodrzhat_treninzi")
public class ProgramaTreningSt {

    @EmbeddedId
    private ProgramaTreningStKey id;

    @ManyToOne
    @MapsId("programa_trening")
    @JoinColumn(name = "programa_trening", nullable = false, referencedColumnName = "programa_trening_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private ProgramaTrening programaTrening;

    @ManyToOne
    @MapsId("den")
    @JoinColumn(name = "den", nullable = false, referencedColumnName = "den_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Den den;

    @ManyToOne
    @MapsId("trening")
    @JoinColumn(name = "trening", nullable = false, referencedColumnName = "trening_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Trening trening;

    public ProgramaTreningStKey getId() {
        return id;
    }

    public void setId(ProgramaTreningStKey id) {
        this.id = id;
    }

    public ProgramaTrening getProgramaTrening() {
        return programaTrening;
    }

    public void setProgramaTrening(ProgramaTrening programaTrening) {
        this.programaTrening = programaTrening;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Den getDen() {
        return den;
    }

    public void setDen(Den den) {
        this.den = den;
    }
}
