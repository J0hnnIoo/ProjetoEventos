package com.example.projetoeventos.view.fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projetoeventos.R;
import com.example.projetoeventos.databinding.FragmentVisualizaEventosInscritosBinding;
import com.example.projetoeventos.modelDominio.Participacoes;
import com.example.projetoeventos.view.adapter.ParticipacoesAdapter;
import com.example.projetoeventos.view.viewModel.VisualizaEventosInscritosViewModel;

import java.util.ArrayList;
import java.util.List;

public class VisualizaEventosInscritosFragment extends Fragment {

    private VisualizaEventosInscritosViewModel mViewModel;
    FragmentVisualizaEventosInscritosBinding binding;
    ParticipacoesAdapter participacoesAdapter;


    public  VisualizaEventosInscritosFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentVisualizaEventosInscritosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VisualizaEventosInscritosViewModel.class);

        atualizaListaEventosInscritos(new ArrayList<>());

        mViewModel.obtemListaEventosInscritos();

        mViewModel.getmListaParticipacoes().observe(getViewLifecycleOwner(), observaListaParticipacoes);
    }


    public void atualizaListaEventosInscritos(List<Participacoes> listParticipacoes) {
        if (listParticipacoes == null) {
            listParticipacoes = new ArrayList<>();
        }

        participacoesAdapter = new ParticipacoesAdapter(listParticipacoes, trataCliqueItem);
        binding.rvVisualizaEventos.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvVisualizaEventos.setItemAnimator(new DefaultItemAnimator());
        binding.rvVisualizaEventos.setAdapter(participacoesAdapter);
    }

    ParticipacoesAdapter.ParticipacoesOnClickListener trataCliqueItem = (view, position, participacao) -> {
        Navigation.findNavController(view).navigate(R.id.acao_visualizaEventosInscritosFragment_to_cadastraNoEventoFragment);
    };

    Observer<List<Participacoes>> observaListaParticipacoes = participacoes -> {
        atualizaListaEventosInscritos(participacoes);
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}