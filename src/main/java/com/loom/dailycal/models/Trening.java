package com.loom.dailycal.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "treninzi")
public class Trening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trening_id")
    private int trening_id;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "sport", nullable = true, referencedColumnName = "sport_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Sport sport;

    public int getTrening_id() {
        return trening_id;
    }

    public void setTrening_id(int trening_id) {
        this.trening_id = trening_id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
