package com.example.projetoeventos.retrofit;

import com.example.projetoeventos.modelDominio.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService {
    @POST("usuarios/inserirUsuario.php")
    Call<Usuario> inserirUsuario(@Body Usuario usuario);

    @POST("usuarios/autenticarUsuario.php")
    Call<Usuario> autenticarUsuario(@Body Usuario usuario);
}
