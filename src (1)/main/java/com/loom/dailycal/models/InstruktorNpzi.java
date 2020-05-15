package com.loom.dailycal.models;

import com.loom.dailycal.relations.InstruktorNpziKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "instruktori_nudat_programa_ishr")
public class InstruktorNpzi {

    @EmbeddedId
    private InstruktorNpziKey id;

    @ManyToOne
    @MapsId("programa_ishr_id")
    @JoinColumn(name = "programa_ishr", nullable = false, referencedColumnName = "programa_ishr_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private ProgramaIshrana programaIshrana;

    @ManyToOne
    @MapsId("instruktor_id")
    @JoinColumn(name = "instruktor", nullable = false, referencedColumnName = "instruktor_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private FitnesInstruktor instruktor;

    public InstruktorNpziKey getId() {
        return id;
    }

    public void setId(InstruktorNpziKey id) {
        this.id = id;
    }

    public ProgramaIshrana getProgramaIshrana() {
        return programaIshrana;
    }

    public void setProgramaIshrana(ProgramaIshrana programaIshrana) {
        this.programaIshrana = programaIshrana;
    }

    public FitnesInstruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(FitnesInstruktor instruktor) {
        this.instruktor = instruktor;
    }
}
