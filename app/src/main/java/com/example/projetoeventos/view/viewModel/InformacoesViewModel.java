package com.example.projetoeventos.view.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projetoeventos.modelDominio.Evento;
import com.example.projetoeventos.modelDominio.Usuario;

public class InformacoesViewModel extends ViewModel {
    private MutableLiveData<Usuario> mUsuarioLogado;
    private MutableLiveData<Evento> mEventoInscrito;

    public InformacoesViewModel() {
        this.mUsuarioLogado = new MutableLiveData<>();
        this.mEventoInscrito = new MutableLiveData<>();
    }

    public MutableLiveData<Usuario> getmUsuarioLogado() {
        return mUsuarioLogado;
    }

    public MutableLiveData<Evento> getmEventoInscrito() {
        return mEventoInscrito;
    }

    public void inicializaEventoInscrito(Evento evento) {
        this.mEventoInscrito.setValue(evento);
    }
    public void inicializaUsuarioLogado(Usuario usuario) {
        this.mUsuarioLogado.setValue(usuario);
    }

    public Usuario obtemUsuarioLogado() {
        return this.mUsuarioLogado.getValue();
    }
    public Evento obtemEventoInscrito() {
        return this.mEventoInscrito.getValue();
    }
}
