package com.example.projetoeventos.repository;

import com.example.projetoeventos.modelDominio.Evento;
import com.example.projetoeventos.retrofit.ClienteRetrofit;
import com.example.projetoeventos.retrofit.EventoService;
import com.example.projetoeventos.retrofit.UsuarioService;

import java.util.List;

import retrofit2.Callback;

public class EventoRepository {
    private final EventoService eventoService = ClienteRetrofit.getInstance().create(EventoService.class);

    public void listarEventos (Callback<List<Evento>> callback) {
        eventoService.listarEventos().enqueue(callback);
    }
}
