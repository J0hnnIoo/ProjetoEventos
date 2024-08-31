package com.example.projetoeventos.retrofit;

import com.example.projetoeventos.modelDominio.Participacoes;
import com.example.projetoeventos.modelDominio.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ParticipacoesService {
    @POST("eventosWeb/API/participacao/inserirParticipacao")
    Call<Participacoes> cadastrarNoEvento(@Body Participacoes participacao);

    @POST("eventosWeb/API/participacao/listarParticipacoes")
    Call<List<Participacoes>> listarEventosInscritos();

    @POST("eventosWeb/API/participacao/deletarParticipacao")
    Call<Participacoes> sairDoEvento(@Body Participacoes participacao);

    @POST("eventosWeb/API/participacao/buscarParticipacaoUsuarioEspecifico")
    Call<Participacoes> buscarUsuarioEspecifico(@Body Usuario usuario);
}
