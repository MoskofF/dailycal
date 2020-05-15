package com.loom.dailycal.models;

import com.loom.dailycal.relations.ObrokSpKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "obrok_sodrzhi_pialok")
public class ObrokSp {

    @EmbeddedId
    private ObrokSpKey id;

    @ManyToOne
    @MapsId("obrok")
    @JoinColumn(name = "obrok", nullable = false, referencedColumnName = "obrok_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Obrok obrok;

    @ManyToOne
    @MapsId("pialok")
    @JoinColumn(name = "pialok", nullable = false, referencedColumnName = "pialok_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Pialok pialok;

    @Column(name = "kolichina_l")
    @NotNull
    private float kolichina;

    public ObrokSpKey getId() {
        return id;
    }

    public void setId(ObrokSpKey id) {
        this.id = id;
    }

    public Obrok getObrok() {
        return obrok;
    }

    public void setObrok(Obrok obrok) {
        this.obrok = obrok;
    }

    public Pialok getPialok() {
        return pialok;
    }

    public void setPialok(Pialok pialok) {
        this.pialok = pialok;
    }

    public float getKolichina() {
        return kolichina;
    }

    public void setKolichina(float kolichina) {
        this.kolichina = kolichina;
    }
}
