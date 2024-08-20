package com.example.projetoeventos.retrofit;

import com.example.projetoeventos.modelDominio.Evento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface EventoService {
    @POST("eventos/listarEventos.php")
    Call<List<Evento>> listarEventos();
}
