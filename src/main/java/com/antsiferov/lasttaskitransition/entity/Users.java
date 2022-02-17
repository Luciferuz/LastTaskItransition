package com.antsiferov.lasttaskitransition.entity;

import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "users_table")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String lastLogin;

    @Column
    private String firstLogin;

    @Column
    private String password;

    @Column
    private String role;

    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        this.firstLogin = df.format(new Date());
        this.lastLogin = "Never";
        this.role = "ROLE_USER";
    }

    public Users() {
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public String getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(String firstLogin) {
        this.firstLogin = firstLogin;
    }

}