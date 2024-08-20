package com.example.projetoeventos.view.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetoeventos.R;
import com.example.projetoeventos.view.viewModel.CadastroUsuarioViewModel;

public class CadastroUsuarioFragment extends Fragment {

    private CadastroUsuarioViewModel mViewModel;

    public static CadastroUsuarioFragment newInstance() {
        return new CadastroUsuarioFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cadastro_usuario, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CadastroUsuarioViewModel.class);
        // TODO: Use the ViewModel
    }

}