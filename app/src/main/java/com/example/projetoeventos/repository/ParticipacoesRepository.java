package com.example.projetoeventos.repository;

import com.example.projetoeventos.modelDominio.Participacoes;
import com.example.projetoeventos.retrofit.ClienteRetrofit;
import com.example.projetoeventos.retrofit.ParticipacoesService;

import java.util.List;

import retrofit2.Callback;

public class ParticipacoesRepository {
    private final ParticipacoesService participacoesService = ClienteRetrofit.getInstance().create(ParticipacoesService.class);

    public void cadastrarNoEvento(Participacoes participacao, Callback<Participacoes> callback) {
        participacoesService.cadastrarNoEvento(participacao).enqueue(callback);
    }

    public void listarEventosCadastrados(Callback<List<Participacoes>> callback) {
        participacoesService.listarEventosInscritos().enqueue(callback);
    }

    public void sairDoEvento(Participacoes participacao, Callback<Participacoes> callback) {
        participacoesService.sairDoEvento(participacao).enqueue(callback);
    }
}
