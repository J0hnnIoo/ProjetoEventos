# Projeto Eventos

Este é um aplicativo Android para gerenciamento de eventos, onde os usuários podem visualizar eventos, se inscrever em eventos e gerenciar suas participações.

## Funcionalidades

- **Login e Cadastro de Usuário**: Os usuários podem se cadastrar e fazer login no aplicativo.
- **Visualização de Eventos**: Os usuários podem visualizar a lista de eventos disponíveis.
- **Inscrição em Eventos**: Os usuários podem se inscrever em eventos.
- **Gerenciamento de Participações**: Os usuários podem visualizar e gerenciar suas participações em eventos.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada.
- **Android SDK**: Ferramentas e APIs para desenvolvimento Android.
- **Retrofit**: Biblioteca para requisições HTTP.
- **ViewModel e LiveData**: Componentes do Android Jetpack para gerenciamento de UI e dados.
- **RecyclerView**: Componente para exibição de listas.
- **ConstraintLayout**: Layout para criação de interfaces responsivas.

## Configuração do Projeto

1. **Clone o repositório**:
    ```sh
    git clone https://github.com/J0hnnIoo/ProjetoEventos.git
    ```

2. **Abra o projeto no Android Studio**.

3. **Sincronize o projeto com o Gradle**.

4. **Execute o aplicativo** em um dispositivo ou emulador Android.

## Estrutura de Código

- **Modelos de Domínio**: Evento.java, Participacoes.java, Usuario.java
- **Repositórios**: EventoRepository.java, ParticipacoesRepository.java, UsuarioRepository.java
- **Serviços Retrofit**: ClienteRetrofit.java, EventoService.java, ParticipacoesService.java, UsuarioService.java
- **ViewModels**: CadastraNoEventoViewModel.java, CadastroUsuarioViewModel.java, InformacoesViewModel.java, LoginViewModel.java, VisualizaEventosInscritosViewModel.java, VisualizaEventosViewModel.java
- **Fragments**: CadastraNoEventoFragment.java, CadastroUsuarioFragment.java, LoginFragment.java, VisualizaEventosFragment.java, VisualizaEventosInscritosFragment.java
- **Adapters**: EventoAdapter.java, ParticipacoesAdapter.java
- **Utils**: Validador.java

---

Desenvolvido por Johnny Becker.
