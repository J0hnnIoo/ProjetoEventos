package com.example.projetoeventos.modelDominio;

import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable {
    private int id;
    private String titulo;
    private String descricão;
    private String localEvento;
    private Date dataEvento;

    public Evento(int id, String titulo, String descricão, String localEvento, Date dataEvento) {
        this.id = id;
        this.titulo = titulo;
        this.descricão = descricão;
        this.localEvento = localEvento;
        this.dataEvento = dataEvento;
    }

    public Evento(String titulo, String descricão, String localEvento, Date dataEvento) {
        this.titulo = titulo;
        this.descricão = descricão;
        this.localEvento = localEvento;
        this.dataEvento = dataEvento;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricão() {
        return descricão;
    }

    public void setDescricão(String descricão) {
        this.descricão = descricão;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }
}
