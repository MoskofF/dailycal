package com.loom.dailycal.models;

import com.loom.dailycal.relations.ObrokShKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "obrok_sodrzhi_hrana")
public class ObrokSh implements Serializable {

    @EmbeddedId
    private ObrokShKey id;

    @ManyToOne
    @MapsId("obrok")
    @JoinColumn(name = "obrok", nullable = false, referencedColumnName = "obrok_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Obrok obrok;

    @ManyToOne
    @MapsId("hrana")
    @JoinColumn(name = "hrana", nullable = false, referencedColumnName = "hrana_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Hrana hrana;

    @Column(name = "kolichina")
    @NotNull
    private float kolichina;

    public ObrokShKey getId() {
        return id;
    }

    public void setId(ObrokShKey id) {
        this.id = id;
    }

    public Obrok getObrok() {
        return obrok;
    }

    public void setObrok(Obrok obrok) {
        this.obrok = obrok;
    }

    public Hrana getHrana() {
        return hrana;
    }

    public void setHrana(Hrana hrana) {
        this.hrana = hrana;
    }

    public float getKolichina() {
        return kolichina;
    }

    public void setKolichina(float kolichina) {
        this.kolichina = kolichina;
    }

    @Override
    public String toString(){
        return String.format("Obrok: %d, HRana: %d, Kolichina: %d", obrok, hrana, kolichina);
    }
}
