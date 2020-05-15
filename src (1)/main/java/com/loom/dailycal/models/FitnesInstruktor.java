package com.loom.dailycal.models;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "fitnes_instruktori")
public class FitnesInstruktor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instruktor_id")
    private int instruktor_id;

    @Column(name = "data_na_ragjanje")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_na_ragjanje;

    @Column(name = "username")
    @NotNull
   // @UniqueElements
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "password_conf")
    @NotNull
    private String password_conf;

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @ManyToMany
    private Set<Role> roles;

    public int getInstruktor_id() {
        return instruktor_id;
    }

    public void setInstruktor_id(int instruktor_id) {
        this.instruktor_id = instruktor_id;
    }

    public Date getData_na_ragjanje() {
        return data_na_ragjanje;
    }

    public void setData_na_ragjanje(Date data_na_ragjanje) {
        this.data_na_ragjanje = data_na_ragjanje;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean update(FitnesInstruktor i) {
        try {
            this.username = i.username;
            this.email = i.email;
            this.data_na_ragjanje = i.data_na_ragjanje;
            this.password = i.password;
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public String toString() {
        return username;
    }
}
