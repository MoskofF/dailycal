package com.loom.dailycal.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trening_sodrzhi_vezhba")
public class TreningSv {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tsv_id")
    private int tsv_id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "trening", nullable = false, referencedColumnName = "trening_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Trening trening;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "vezhba", nullable = false, referencedColumnName = "vezhba_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Vezhba vezhba;

    @Column(name = "povtoruvanja")
    @NotNull
    private int povtoruvanja;

    public int getTsv_id() {
        return tsv_id;
    }

    public void setTsv_id(int tsv_id) {
        this.tsv_id = tsv_id;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Vezhba getVezhba() {
        return vezhba;
    }

    public void setVezhba(Vezhba vezhba) {
        this.vezhba = vezhba;
    }

    public int getPovtoruvanja() {
        return povtoruvanja;
    }

    public void setPovtoruvanja(int povtoruvanja) {
        this.povtoruvanja = povtoruvanja;
    }
}
