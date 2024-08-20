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
import com.example.projetoeventos.view.viewModel.VisualizaEventosViewModel;

public class VisualizaEventosFragment extends Fragment {

    private VisualizaEventosViewModel mViewModel;

    public static VisualizaEventosFragment newInstance() {
        return new VisualizaEventosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_visualiza_eventos, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VisualizaEventosViewModel.class);
        // TODO: Use the ViewModel
    }

}