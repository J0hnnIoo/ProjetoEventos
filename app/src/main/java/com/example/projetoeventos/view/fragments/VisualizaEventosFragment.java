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
import com.example.projetoeventos.databinding.FragmentVisualizaEventosBinding;
import com.example.projetoeventos.modelDominio.Evento;
import com.example.projetoeventos.view.adapter.EventoAdapter;
import com.example.projetoeventos.view.viewModel.VisualizaEventosViewModel;

import java.util.ArrayList;
import java.util.List;

public class VisualizaEventosFragment extends Fragment {

    private VisualizaEventosViewModel mViewModel;
    FragmentVisualizaEventosBinding binding;
    EventoAdapter eventoAdapter;

    public VisualizaEventosFragment() {

    }

    public static VisualizaEventosFragment newInstance() {
        return new VisualizaEventosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentVisualizaEventosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VisualizaEventosViewModel.class);

        atualizaListaEventos(new ArrayList<>());

        mViewModel.obtemListaEventos();

        mViewModel.getmListaEventos().observe(getViewLifecycleOwner(), observaListaProdutos);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    Observer<List<Evento>> observaListaProdutos = eventos -> {
        atualizaListaEventos(eventos);
    };

    EventoAdapter.EventoOnClickListener trataCliqueItem = (view, position, evento) -> {
        Navigation.findNavController(view).navigate(R.id.acao_visualizaEventos_to_cadastraNoEvento_fragment);
    };

    public void atualizaListaEventos(List<Evento> listaEventos) {
        if (listaEventos == null) {
            listaEventos = new ArrayList<>();
        }

        eventoAdapter = new EventoAdapter(listaEventos, trataCliqueItem);
        binding.rvVisualizaEventos.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvVisualizaEventos.setItemAnimator(new DefaultItemAnimator());
        binding.rvVisualizaEventos.setAdapter(eventoAdapter);
    }
}