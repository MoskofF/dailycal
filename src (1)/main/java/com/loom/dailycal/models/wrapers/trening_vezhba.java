package com.loom.dailycal.models.wrapers;

public class trening_vezhba {

    private int vezhba;
    private int povtoruvanja;

    public trening_vezhba() {
        vezhba = 0;
        povtoruvanja = 0;
    }

    public int getVezhba() {
        return vezhba;
    }

    public void setVezhba(int vezhba) {
        this.vezhba = vezhba;
    }

    public int getPovtoruvanja() {
        return povtoruvanja;
    }

    public void setPovtoruvanja(int povtoruvanja) {
        this.povtoruvanja = povtoruvanja;
    }
}
