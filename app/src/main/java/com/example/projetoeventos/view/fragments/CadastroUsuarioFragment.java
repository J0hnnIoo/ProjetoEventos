package com.example.projetoeventos.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.projetoeventos.databinding.FragmentCadastroUsuarioBinding;
import com.example.projetoeventos.modelDominio.Usuario;
import com.example.projetoeventos.utils.Validador;
import com.example.projetoeventos.view.viewModel.CadastroUsuarioViewModel;

public class CadastroUsuarioFragment extends Fragment {

    private CadastroUsuarioViewModel mViewModel;
    FragmentCadastroUsuarioBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCadastroUsuarioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CadastroUsuarioViewModel.class);

        mViewModel.getResultado().observe(getViewLifecycleOwner(), observaCadastroUsuario);

        //programando o clique dos botoes
        binding.btCadastro.setOnClickListener(view1 -> {
            if (!Validador.validaTexto(binding.etCadastroUsuarioNome.getText().toString())) {
                binding.etCadastroUsuarioNome.setError("Erro: informe o nome");
                binding.etCadastroUsuarioNome.requestFocus();
                return;
            }
            if (!Validador.validaEmail(binding.etCadastroUsuarioEmail.getText().toString())) {
                binding.etCadastroUsuarioEmail.setError("Erro: informe um email válido");
                binding.etCadastroUsuarioEmail.requestFocus();
                return;
            }
            if (!Validador.validaTexto(binding.etCadastroUsuarioLogin.getText().toString())) {
                binding.etCadastroUsuarioLogin.setError("Erro: informe um login válido");
                binding.etCadastroUsuarioLogin.requestFocus();
                return;
            }
            if (!Validador.validaTexto(binding.etCadastroUsuarioSenha.getText().toString())) {
                binding.etCadastroUsuarioSenha.setError("Erro: informe uma senha válida");
                binding.etCadastroUsuarioSenha.requestFocus();
                return;
            }

            //obtendo as informacoes
            String nome = binding.etCadastroUsuarioNome.getText().toString();
            String email = binding.etCadastroUsuarioEmail.getText().toString();
            String login = binding.etCadastroUsuarioLogin.getText().toString();
            String senha = binding.etCadastroUsuarioSenha.getText().toString();

            //instanciando o usuario
            Usuario usuario = new Usuario(nome, email, login, senha);

            //chamando o viewModel
            mViewModel.inserirUsuario(usuario);
        });

        binding.tvLoginCadastrar.setOnClickListener(view1 -> {
            Navigation.findNavController(requireView()).popBackStack();
            limpaCampos();
        });
    }


    Observer<Boolean> observaCadastroUsuario = aBoolean -> {
        if (aBoolean) {
            Toast.makeText(getContext(), "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            limpaCampos();
            Navigation.findNavController(requireView()).popBackStack();
        } else {
            Toast.makeText(getContext(), "Erro: usuário não cadastrado.", Toast.LENGTH_SHORT).show();
        }
    };



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void limpaCampos() {
        binding.etCadastroUsuarioNome.setText("");
        binding.etCadastroUsuarioEmail.setText("");
        binding.etCadastroUsuarioLogin.setText("");
        binding.etCadastroUsuarioSenha.setText("");
    }
}