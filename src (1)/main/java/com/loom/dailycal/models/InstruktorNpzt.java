package com.loom.dailycal.models;

import com.loom.dailycal.relations.InstruktorNpztKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "instruktori_nudat_programa_trening")
public class InstruktorNpzt {

    @EmbeddedId
    private InstruktorNpztKey id;

    @ManyToOne
    @MapsId("programa_trening_id")
    @JoinColumn(name = "programa_trening", nullable = false, referencedColumnName = "programa_trening_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private ProgramaTrening programaTrening;

    @ManyToOne
    @MapsId("instruktor_id")
    @JoinColumn(name = "instruktor", nullable = false, referencedColumnName = "instruktor_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private FitnesInstruktor instruktor;

    public InstruktorNpztKey getId() {
        return id;
    }

    public void setId(InstruktorNpztKey id) {
        this.id = id;
    }

    public ProgramaTrening getProgramaTrening() {
        return programaTrening;
    }

    public void setProgramaTrening(ProgramaTrening programaTrening) {
        this.programaTrening = programaTrening;
    }

    public FitnesInstruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(FitnesInstruktor instruktor) {
        this.instruktor = instruktor;
    }
}
