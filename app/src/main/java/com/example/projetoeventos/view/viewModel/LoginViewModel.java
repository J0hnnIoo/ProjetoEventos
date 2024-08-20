package com.example.projetoeventos.view.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projetoeventos.modelDominio.Usuario;
import com.example.projetoeventos.repository.UsuarioRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    private UsuarioRepository usuarioRepository;
    private MutableLiveData<Usuario> mUsuarioLogado;

    public LoginViewModel() {
        this.usuarioRepository = new UsuarioRepository();
        this.mUsuarioLogado = new MutableLiveData<>();
    }

    public MutableLiveData<Usuario> getmUsuarioLogado() {
        return mUsuarioLogado;
    }

    // metodo responsavel por limpar o usuario logado
    public void limpaEstado() { mUsuarioLogado = new MutableLiveData<>(); }

    // metodo que efetua o login do usuario
    public void logarUsuario(Usuario usuario) {
        usuarioRepository.autenticarUsuario(usuario, new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario usuario = response.body();
                if (usuario.getId() > 0) {
                    mUsuarioLogado.postValue(usuario);
                } else {
                    mUsuarioLogado.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                mUsuarioLogado.postValue(null);
            }
        });
    }
}