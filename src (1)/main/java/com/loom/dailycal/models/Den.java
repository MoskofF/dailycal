package com.loom.dailycal.models;


import javax.persistence.*;

@Entity
@Table(name = "denovi")
public class Den {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "den_id")
    private int den_id;

    @Column(name = "den")
    private String den;

    public int getDen_id() {
        return den_id;
    }

    public void setDen_id(int den_id) {
        this.den_id = den_id;
    }

    public String getDen() {
        return den;
    }

    public void setDen(String den) {
        this.den = den;
    }
}
