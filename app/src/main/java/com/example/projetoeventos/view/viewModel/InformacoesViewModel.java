package com.example.projetoeventos.view.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projetoeventos.modelDominio.Usuario;

public class InformacoesViewModel extends ViewModel {
    private MutableLiveData<Usuario> mUsuarioLogado;

    public InformacoesViewModel() {
        this.mUsuarioLogado = new MutableLiveData<>();
    }

    public MutableLiveData<Usuario> getmUsuarioLogado() {
        return mUsuarioLogado;
    }

    public void inicializaUsuarioLogado(Usuario usuario) {
        this.mUsuarioLogado.setValue(usuario);
    }

    public Usuario obtemUsuarioLogado() {
        return this.mUsuarioLogado.getValue();
    }
}
