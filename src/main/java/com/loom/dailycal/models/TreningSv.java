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
}
