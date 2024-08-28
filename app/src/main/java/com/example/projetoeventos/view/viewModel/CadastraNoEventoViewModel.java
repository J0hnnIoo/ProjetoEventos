package com.example.projetoeventos.view.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projetoeventos.modelDominio.Evento;
import com.example.projetoeventos.modelDominio.Participacoes;
import com.example.projetoeventos.repository.ParticipacoesRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastraNoEventoViewModel extends ViewModel {
    private ParticipacoesRepository participacoesRepository;
    private MutableLiveData<Evento> eventoInscrito;
    private MutableLiveData<List<Participacoes>> mListaParticipacoes;

    public CadastraNoEventoViewModel() {
        this.participacoesRepository = new ParticipacoesRepository();
        this.eventoInscrito = new MutableLiveData<>();
        this.mListaParticipacoes = new MutableLiveData<>();
    }

    public void setEventoInscrito(Evento evento) {
        this.eventoInscrito.setValue(evento);
    }

    public MutableLiveData<List<Participacoes>> getmListaParticipacoes() {
        return mListaParticipacoes;
    }

    /*
    public void cadastrarNoEvento(Participacoes participacao) {
        this.participacoesRepository.cadastrarNoEvento(participacao, new Callback<Participacoes>() {
            @Override
            public void onResponse(Call<Participacoes> call, Response<Participacoes> response) {
                Participacoes participacao = response.body();
                if (participacao.getId() != -1) {
                    mResultadoOperacao.postValue(true);
                } else {
                    mResultadoOperacao.postValue(false);
                }
            }

            @Override
            public void onFailure(Call<Participacoes> call, Throwable t) {
                mResultadoOperacao.postValue(false);
            }
        });
    }
   */
    public void obtemListaPEventosCadastrados() {
        this.participacoesRepository.listarEventosCadastrados(new Callback<List<Participacoes>>() {
            @Override
            public void onResponse(Call<List<Participacoes>> call, Response<List<Participacoes>> response) {
                mListaParticipacoes.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Participacoes>> call, Throwable t) {
                mListaParticipacoes.postValue(null);
            }
        });
    }
}