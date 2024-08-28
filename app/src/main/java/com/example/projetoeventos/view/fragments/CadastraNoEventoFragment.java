package com.example.projetoeventos.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetoeventos.databinding.FragmentCadastraNoEventoBinding;
import com.example.projetoeventos.modelDominio.Evento;
import com.example.projetoeventos.view.viewModel.CadastraNoEventoViewModel;

public class CadastraNoEventoFragment extends Fragment {


    private CadastraNoEventoViewModel mViewModel;
    FragmentCadastraNoEventoBinding binding;

    public static CadastraNoEventoFragment newInstance() {
        return new CadastraNoEventoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCadastraNoEventoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CadastraNoEventoViewModel.class);
        Bundle parametros = getArguments();
        Evento evento = (Evento)parametros.getSerializable("evento");


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}