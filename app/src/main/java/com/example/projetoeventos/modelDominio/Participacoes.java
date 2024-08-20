package com.example.projetoeventos.modelDominio;

import java.io.Serializable;

public class Participacoes implements Serializable {
    private int id;
    private Evento evento;
    private Usuario usuario;

    public Participacoes(int id, Evento evento, Usuario usuario) {
        this.id = id;
        this.evento = evento;
        this.usuario = usuario;
    }

    public Participacoes(Evento evento, Usuario usuario) {
        this.evento = evento;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
