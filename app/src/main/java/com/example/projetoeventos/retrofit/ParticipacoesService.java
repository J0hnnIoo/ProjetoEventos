package com.example.projetoeventos.retrofit;

import com.example.projetoeventos.modelDominio.Participacoes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ParticipacoesService {
    @POST("participacoes/cadastrarNoEvento.php")
    Call<Participacoes> cadastrarNoEvento(@Body Participacoes participacao);

    @POST("participacoes/listarEventosInscritos.php")
    Call<List<Participacoes>> listarEventosInscritos();
}
