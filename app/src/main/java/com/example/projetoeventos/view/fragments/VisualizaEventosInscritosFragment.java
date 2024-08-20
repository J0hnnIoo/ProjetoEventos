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
import com.example.projetoeventos.view.viewModel.VisualizaEventosInscritosViewModel;

public class VisualizaEventosInscritosFragment extends Fragment {

    private VisualizaEventosInscritosViewModel mViewModel;

    public static VisualizaEventosInscritosFragment newInstance() {
        return new VisualizaEventosInscritosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_visualiza_eventos_inscritos, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VisualizaEventosInscritosViewModel.class);
        // TODO: Use the ViewModel
    }

}