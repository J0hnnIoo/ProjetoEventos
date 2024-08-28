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

import com.example.projetoeventos.R;
import com.example.projetoeventos.databinding.FragmentLoginBinding;
import com.example.projetoeventos.modelDominio.Usuario;
import com.example.projetoeventos.utils.Validador;
import com.example.projetoeventos.view.activities.MainActivity;
import com.example.projetoeventos.view.viewModel.InformacoesViewModel;
import com.example.projetoeventos.view.viewModel.LoginViewModel;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;
    FragmentLoginBinding binding;
    InformacoesViewModel informacoesViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        // Obtendo o viewModel de compartilhamento de informaçoe
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);

        //definindo o observador da autenticaçao do usuario
        mViewModel.getmUsuarioLogado().observe(getViewLifecycleOwner(), observaAutenticacaoUsuario);

        // programando o clique dos botoes
        binding.btLogin.setOnClickListener(view1 -> {
            if (!Validador.validaTexto(binding.etLoginUsuario.getText().toString())) {
                binding.etLoginUsuario.setError("Erro: Informe o usuário");
                binding.etLoginUsuario.requestFocus();
                return;
            }
            if (!Validador.validaTexto(binding.etLoginSenha.getText().toString())) {
                binding.etLoginSenha.setError("Erro: Senha incorreta");
                binding.etLoginSenha.requestFocus();
                return;
            }
            
            String login = binding.etLoginUsuario.getText().toString();
            String senha = binding.etLoginSenha.toString();

            Usuario usuario = new Usuario(login, senha);
            mViewModel.logarUsuario(usuario);
        });

        binding.tvLoginCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
                Navigation.findNavController(view).navigate(R.id.acao_login_to_cadastroUsuario_fragment);
            }
        });
    }
    
    Observer<Usuario> observaAutenticacaoUsuario = new Observer<Usuario>() {
        @Override
        public void onChanged(Usuario usuario) {
            if (usuario != null) {
                informacoesViewModel.inicializaUsuarioLogado(usuario);
                Navigation.findNavController(requireView()).navigate(R.id.acao_login_to_visualizaEventos_fragment); 
            } else {
                Toast.makeText(getContext(), "Erro: usuário e/ou senha inválidos", Toast.LENGTH_SHORT).show();
            }
            
        }
    };
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        mViewModel.limpaEstado();
    }

    public void limpaCampos() {
        binding.etLoginUsuario.setText("");
        binding.etLoginSenha.setText("");
    }

    @Override
    public void onResume() {
        super.onResume();
        // limpando os campos na tela quando "volta"
        limpaCampos();
        // escondendo a ToolBar e BottomNavigation
        if (requireActivity() instanceof MainActivity) {
            ((MainActivity) requireActivity()).escondeBottomNavigation();
            ((MainActivity) requireActivity()).getSupportActionBar().hide();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // mostrando a ToolBar e BottomNavigation
        if (requireActivity() instanceof MainActivity) {
            ((MainActivity) requireActivity()).mostraBottomNavigation();
            ((MainActivity) requireActivity()).getSupportActionBar().show();
        }
    }
}