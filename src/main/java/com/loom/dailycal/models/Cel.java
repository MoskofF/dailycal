package com.loom.dailycal.models;

import javax.persistence.*;

@Entity
@Table(name = "celi")
public class Cel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cel_id")
    private int cel_id;

    @Column(name = "cel")
    private String cel;

    public int getCel_id() {
        return cel_id;
    }

    public void setCel_id(int cel_id) {
        this.cel_id = cel_id;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    @Override
    public String toString() {
        return cel;
    }
}
