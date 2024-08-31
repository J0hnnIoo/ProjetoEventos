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
import com.example.projetoeventos.modelDominio.Participacoes;
import com.example.projetoeventos.modelDominio.Usuario;
import com.example.projetoeventos.view.viewModel.CadastraNoEventoViewModel;
import com.example.projetoeventos.view.viewModel.InformacoesViewModel;

public class CadastraNoEventoFragment extends Fragment {


    private CadastraNoEventoViewModel mViewModel;
    FragmentCadastraNoEventoBinding binding;
    InformacoesViewModel informacoesViewModel;
    Evento evento;
    boolean cadastroNoEvento;

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

        binding.tvNomeEvento.setText(evento.getTitulo());
        binding.tvDataEvento.setText(evento.getDataEvento().toString());
        binding.tvDescricaoEvento.setText(evento.getDescricão());
        binding.tvLocalEvento.setText(evento.getLocalEvento());

        binding.btInscreverOuDeletar.setOnClickListener(view1 -> {
            Evento evento = informacoesViewModel.obtemEventoInscrito();
            Usuario usuario = informacoesViewModel.obtemUsuarioLogado();
            Participacoes participacao = new Participacoes(evento, usuario);
            mViewModel.cadastrarNoEvento(participacao);
        });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}