package com.example.projetoeventos.retrofit;

import com.example.projetoeventos.modelDominio.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService {
    @POST("eventosWeb/API/usuario/inserirUsuario")
    Call<Usuario> inserirUsuario(@Body Usuario usuario);

    @POST("eventosWeb/API/usuario/autenticarUsuario")
    Call<Usuario> autenticarUsuario(@Body Usuario usuario);
}
