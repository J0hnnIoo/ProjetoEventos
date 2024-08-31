package com.example.projetoeventos.view.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projetoeventos.modelDominio.Participacoes;
import com.example.projetoeventos.repository.ParticipacoesRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VisualizaEventosInscritosViewModel extends ViewModel {
    private ParticipacoesRepository participacoesRepository;
    private MutableLiveData<List<Participacoes>> mListaParticipacoes;
    private MutableLiveData<Boolean> mResultadoOperacao;

    public VisualizaEventosInscritosViewModel() {
        this.participacoesRepository = new ParticipacoesRepository();
        this.mListaParticipacoes = new MutableLiveData<>();
        this.mResultadoOperacao = new MutableLiveData<>();
    }

    public MutableLiveData<List<Participacoes>> getmListaParticipacoes() {
        return mListaParticipacoes;
    }

    public MutableLiveData<Boolean> getmResultadoOperacao() {
        return mResultadoOperacao;
    }

    public void obtemListaEventosInscritos() {
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

    public void sairDoEvento(Participacoes participacao) {
        this.participacoesRepository.sairDoEvento(participacao, new Callback<Participacoes>() {
            @Override
            public void onResponse(Call<Participacoes> call, Response<Participacoes> response) {
                Participacoes participacao = response.body();
                if (participacao.getId() > 0) {
                    mResultadoOperacao.postValue(true);
                    obtemListaEventosInscritos();
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
}