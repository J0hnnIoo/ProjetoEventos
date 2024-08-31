package com.example.projetoeventos.view.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projetoeventos.modelDominio.Evento;
import com.example.projetoeventos.repository.EventoRepository;

import java.io.Closeable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizaEventosViewModel extends ViewModel {
    private EventoRepository eventoRepository;
    private MutableLiveData<List<Evento>> mListaEventos;

    public VisualizaEventosViewModel() {
        this.eventoRepository = new EventoRepository();
        this.mListaEventos = new MutableLiveData<>();
    }

    public MutableLiveData<List<Evento>> getmListaEventos() {
        return mListaEventos;
    }

    public void obtemListaEventos() {
        this.eventoRepository.listarEventos(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                mListaEventos.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {
                mListaEventos.postValue(null);
            }
        });
    }
}