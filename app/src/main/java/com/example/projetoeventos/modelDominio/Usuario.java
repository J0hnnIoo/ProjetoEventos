package com.example.projetoeventos.modelDominio;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String nomeUsuario;
    private String email;
    private String login;
    private String senha;

    public Usuario(int id, String nomeUsuario, String email, String login, String senha) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nomeUsuario, String email, String login, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
