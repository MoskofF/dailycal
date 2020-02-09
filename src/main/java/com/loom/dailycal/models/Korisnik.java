package com.loom.dailycal.models;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "korisnici")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "username")
    @NotNull
    //@UniqueElements
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "password_conf")
    @NotNull
    private String password_conf;

    @ManyToMany
    private Set<Role> roles;

    @Column(name = "email")
    @NotNull
    @Email
    //@UniqueElements
    private String email;

    @Column(name = "data_na_ragjanje")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_na_ragjanje;

    @Column(name = "visina")
    private float visina;

    @Column(name = "tezina")
    private float tezina;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "cel", nullable = true, referencedColumnName = "cel_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Cel cel;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "instruktor", nullable = true, referencedColumnName = "instruktor_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private FitnesInstruktor instruktor;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "programa_za_ishrana", nullable = true, referencedColumnName = "programa_ishr_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private ProgramaIshrana programa_za_ishrana;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "programa_za_trening", nullable = true, referencedColumnName = "programa_trening_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private ProgramaTrening programa_za_trening;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData_na_ragjanje() {
        return data_na_ragjanje;
    }

    public void setData_na_ragjanje(Date data_na_ragjanje) {
        this.data_na_ragjanje = data_na_ragjanje;
    }

    public float getVisina() {
        return visina;
    }

    public void setVisina(float visina) {
        this.visina = visina;
    }

    public float getTezina() {
        return tezina;
    }

    public void setTezina(float tezina) {
        this.tezina = tezina;
    }

    public Cel getCel() {
        return cel;
    }

    public void setCel(Cel cel) {
        this.cel = cel;
    }

    public FitnesInstruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(FitnesInstruktor instruktor) {
        this.instruktor = instruktor;
    }

    public ProgramaIshrana getPrograma_za_ishrana() {
        return programa_za_ishrana;
    }

    public void setPrograma_za_ishrana(ProgramaIshrana programa_za_ishrana) {
        this.programa_za_ishrana = programa_za_ishrana;
    }

    public ProgramaTrening getPrograma_za_trening() {
        return programa_za_trening;
    }

    public void setPrograma_za_trening(ProgramaTrening programa_za_trening) {
        this.programa_za_trening = programa_za_trening;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean updateKorisnik(Korisnik k) {
        try {
            this.username = k.username;
            this.password = k.password;
            this.email = k.email;
            this.data_na_ragjanje = k.data_na_ragjanje;
            this.visina = k.visina;
            this.tezina = k.tezina;
            this.cel = k.cel;
            this.instruktor = k.instruktor;
            this.programa_za_ishrana = k.programa_za_ishrana;
            this.programa_za_trening = k.programa_za_trening;

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public String getPassword_conf() {
        return password_conf;
    }

    public void setPassword_conf(String password_conf) {
        this.password_conf = password_conf;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
