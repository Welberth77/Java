package Biblioteca_Projeto.src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class sistema_bibliotecario {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Administrador admin = new Administrador("Admin1", "1234");

        // Criando e adicionando uma lista de livros
        List<Livro> listaDeLivros = new ArrayList<>();
        listaDeLivros.add(new Livro("A volta ao mundo em 80 dias", "Júlio Verne", 10));
        listaDeLivros.add(new Livro("Dom Quixote", "Miguel de Cervantes", 5));
        listaDeLivros.add(new Livro("1984", "George Orwell", 8));
        listaDeLivros.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 6));
        listaDeLivros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 7));
        listaDeLivros.add(new Livro("Moby Dick", "Herman Melville", 4));
        listaDeLivros.add(new Livro("Guerra e Paz", "Liev Tolstói", 3));
        listaDeLivros.add(new Livro("A Divina Comédia", "Dante Alighieri", 2));
        listaDeLivros.add(new Livro("O Grande Gatsby", "F. Scott Fitzgerald", 5));
        listaDeLivros.add(new Livro("Cem Anos de Solidão", "Gabriel García Márquez", 9));

        // Adicionando a lista de livros à biblioteca através do administrador
        for (Livro livro : listaDeLivros) {
            admin.adicionarLivro(biblioteca, livro);
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bem-vindo ao Sistema Bibliotecário");
            System.out.println("Você é um:");
            System.out.println("1. Administrador");
            System.out.println("2. Professor");
            System.out.println("3. Aluno");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int usuarioTipo = lerOpcao(scanner);

            if (usuarioTipo == 1) {
                System.out.print("Digite seu ID de administrador: ");
                String idAdm = scanner.nextLine();
                if (!idAdm.equals(admin.getIdAdm())) {
                    System.out.println("ID de administrador inválido!");
                    continue;
                }
                while (true) {
                    System.out.println("Menu Administrador");
                    System.out.println("1. Listar todos os livros");
                    System.out.println("2. Adicionar livro");
                    System.out.println("3. Remover livro");
                    System.out.println("4. Atualizar estoque");
                    System.out.println("5. Sair");
                    System.out.print("Escolha uma opção: ");

                    int opcaoAdmin = lerOpcao(scanner);

                    switch (opcaoAdmin) {
                        case 1:
                            biblioteca.listarLivros();
                            break;
                        case 2:
                            System.out.print("Digite o título do livro: ");
                            String tituloLivro = scanner.nextLine();
                            System.out.print("Digite o autor do livro: ");
                            String autorLivro = scanner.nextLine();
                            System.out.print("Digite o estoque do livro: ");
                            int estoqueLivro = lerOpcao(scanner);
                            Livro novoLivro = new Livro(tituloLivro, autorLivro, estoqueLivro);
                            admin.adicionarLivro(biblioteca, novoLivro);
                            break;
                        case 3:
                            System.out.print("Digite o título do livro para remoção: ");
                            String tituloRemover = scanner.nextLine();
                            admin.removerLivro(biblioteca, tituloRemover);
                            break;
                        case 4:
                            System.out.print("Digite o título do livro para atualizar o estoque: ");
                            String tituloAtualizar = scanner.nextLine();
                            System.out.print("Digite o novo estoque: ");
                            int novoEstoque = lerOpcao(scanner);
                            admin.atualizarEstoque(biblioteca, tituloAtualizar, novoEstoque);
                            break;
                        case 5:
                            System.out.println("Saindo do menu administrador...");
                            break;
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                            break;
                    }
                    if (opcaoAdmin == 5) break;
                }
            } else if (usuarioTipo == 2) {
                System.out.print("Digite seu nome: ");
                String nomeProfessor = scanner.nextLine();
                System.out.print("Digite seu CPF: ");
                String cpfProfessor = scanner.nextLine();
                Professor professor = new Professor(nomeProfessor, cpfProfessor);
                while (true) {
                    System.out.println("Menu Professor");
                    System.out.println("1. Listar todos os livros");
                    System.out.println("2. Listar livros cadastrados");
                    System.out.println("3. Solicitar empréstimo");
                    System.out.println("4. Solicitar devolução");
                    System.out.println("5. Sair");
                    System.out.print("Escolha uma opção: ");

                    int opcaoProfessor = lerOpcao(scanner);

                    switch (opcaoProfessor) {
                        case 1:
                            biblioteca.listarLivros();
                            break;
                        case 2:
                            biblioteca.listarLivrosCadastrados();
                            break;
                        case 3:
                            System.out.print("Digite o título do livro para empréstimo: ");
                            String tituloEmprestimo = scanner.nextLine();
                            Livro livroEmprestimo = biblioteca.buscarLivro(tituloEmprestimo);
                            if (livroEmprestimo != null) {
                                professor.solicitarEmprestimo(livroEmprestimo);
                            } else {
                                System.out.println("Livro não encontrado.");
                            }
                            break;
                        case 4:
                            System.out.print("Digite o título do livro para devolução: ");
                            String tituloDevolucao = scanner.nextLine();
                            Livro livroDevolucao = biblioteca.buscarLivro(tituloDevolucao);
                            if (livroDevolucao != null) {
                                professor.solicitarDevolucao(livroDevolucao);
                            } else {
                                System.out.println("Livro não encontrado.");
                            }
                            break;
                        case 5:
                            System.out.println("Saindo do menu professor...");
                            break;
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                            break;
                    }
                    if (opcaoProfessor == 5) break;
                }
            } else if (usuarioTipo == 3) {
                System.out.print("Digite seu nome: ");
                String nomeMembro = scanner.nextLine();
                System.out.print("Digite seu CPF: ");
                String cpfMembro = scanner.nextLine();
                Membro membro = new Membro(nomeMembro, cpfMembro);
                while (true) {
                    System.out.println("Menu Aluno");
                    System.out.println("1. Listar todos os livros");
                    System.out.println("2. Solicitar empréstimo");
                    System.out.println("3. Solicitar devolução");
                    System.out.println("4. Sair");
                    System.out.print("Escolha uma opção: ");

                    int opcaoMembro = lerOpcao(scanner);

                    switch (opcaoMembro) {
                        case 1:
                            biblioteca.listarLivros();
                            break;
                        case 2:
                            System.out.print("Digite o título do livro para empréstimo: ");
                            String tituloEmprestimo = scanner.nextLine();
                            Livro livroEmprestimo = biblioteca.buscarLivro(tituloEmprestimo);
                            if (livroEmprestimo != null) {
                                membro.solicitarEmprestimo(livroEmprestimo);
                            } else {
                                System.out.println("Livro não encontrado.");
                            }
                            break;
                        case 3:
                            System.out.print("Digite o título do livro para devolução: ");
                            String tituloDevolucao = scanner.nextLine();
                            Livro livroDevolucao = biblioteca.buscarLivro(tituloDevolucao);
                            if (livroDevolucao != null) {
                                membro.solicitarDevolucao(livroDevolucao);
                            } else {
                                System.out.println("Livro não encontrado.");
                            }
                            break;
                        case 4:
                            System.out.println("Saindo do menu membro...");
                            break;
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                            break;
                    }
                    if (opcaoMembro == 4) break;
                }
            } else if (usuarioTipo == 4) {
                System.out.println("Encerrando o Sistema Bibliotecário...");
                break;
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    // Método para ler a opção do usuário e validar se é um número inteiro
    public static int lerOpcao(Scanner scanner) {
        int opcao = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Por favor, digite um número: ");
                scanner.nextLine();
            }
        }

        return opcao;
    }

    // Classe Membro representa um membro da biblioteca
    static class Membro {
        private String nome;
        private String cpf;
        private List<Livro> livrosEmprestados;

        // Método Construtor do membro
        public Membro(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
            this.livrosEmprestados = new ArrayList<>();
        }

        // Gets e Sets
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public List<Livro> getLivrosEmprestados() {
            return livrosEmprestados;
        }

        public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
            this.livrosEmprestados = livrosEmprestados;
        }

        // Listar livros emprestados
        public void listarLivrosEmprestados() {
            for (Livro livro : livrosEmprestados) {
                livro.exibirInformacoes();
            }
        }

        // Solicitando empréstimo
        public void solicitarEmprestimo(Livro livro) {
            if (livro.isDisponivel()) {
                livro.setEstoque(livro.getEstoque() - 1);
                livrosEmprestados.add(livro);
                System.out.println("Empréstimo do livro " + livro.getTitulo() + " realizado com sucesso!");
            } else {
                System.out.println("O livro " + livro.getTitulo() + " não está disponível para empréstimo.");
            }
        }

        // Solicitar devolução do livro
        public void solicitarDevolucao(Livro livro) {
            if (livrosEmprestados.remove(livro)) {
                livro.setEstoque(livro.getEstoque() + 1);
                System.out.println("Devolução do livro " + livro.getTitulo() + " realizada com sucesso!");
            } else {
                System.out.println("Este livro não foi emprestado a você.");
            }
        }

        // Verificar se o membro é um professor
        public boolean isProfessor() {
            return this instanceof Professor;
        }
    }

    // Classe Professor que herda da classe Membro
    static class Professor extends Membro {
        // Método construtor
        public Professor(String nome, String cpf) {
            super(nome, cpf);
        }

        // Sobrescrevendo o método de solicitar empréstimo para aplicar benefício de tempo extra
        @Override
        public void solicitarEmprestimo(Livro livro) {
            if (livro.isDisponivel()) {
                if (livro.getEstoque() > 0) {
                    livro.setEstoque(livro.getEstoque() - 1);
                    getLivrosEmprestados().add(livro);
                    System.out.println("Empréstimo do livro por 6 meses " + livro.getTitulo() + " realizado com sucesso!");
                } else {
                    System.out.println("O livro " + livro.getTitulo() + " não está disponível para empréstimo.");
                }
            } else {
                System.out.println("O livro " + livro.getTitulo() + " não está disponível para empréstimo.");
            }
        }
    }

    // Classe Aluno que herda da classe Membro
    static class Aluno extends Membro {
        // Método construtor
        public Aluno(String nome, String cpf) {
            super(nome, cpf);
        }

    }

    // Classe Administrador
    static class Administrador {
        private String nome;
        private String idAdm;

        // Método construtor
        public Administrador(String nome, String idAdm) {
            this.nome = nome;
            this.idAdm = idAdm;
        }

        // Gets
        public String getNome() {
            return nome;
        }

        public String getIdAdm() {
            return idAdm;
        }

        // Adicionando livro à biblioteca
        public void adicionarLivro(Biblioteca biblioteca, Livro livro) {
            biblioteca.adicionarLivro(livro);
            System.out.println("Livro adicionado com sucesso: " + livro.getTitulo());
        }

        // Removendo livro da biblioteca
        public void removerLivro(Biblioteca biblioteca, String nomeLivro) {
            Livro livroARemover = biblioteca.buscarLivro(nomeLivro);
            if (livroARemover != null) {
                biblioteca.removerLivro(livroARemover);
                System.out.println("Livro removido com sucesso: " + livroARemover.getTitulo());
            } else {
                System.out.println("Livro não encontrado: " + nomeLivro);
            }
        }

        // Atualizando estoque da biblioteca
        public void atualizarEstoque(Biblioteca biblioteca, String tituloLivro, int novoEstoque) {
            Livro livro = biblioteca.buscarLivro(tituloLivro);
            if (livro != null) {
                livro.setEstoque(novoEstoque);
                System.out.println("Estoque do livro " + livro.getTitulo() + " atualizado para " + novoEstoque);
            } else {
                System.out.println("Livro não encontrado: " + tituloLivro);
            }
        }

        // Listar todos os livros da biblioteca
        public void listarLivros(Biblioteca biblioteca) {
            biblioteca.listarLivros();
        }
    }

    // Classe Biblioteca
    static class Biblioteca {
        private List<Livro> livros;
        private List<Professor> professores;
        private List<Aluno> alunos;

        // Método construtor
        public Biblioteca() {
            this.livros = new ArrayList<>();
            this.professores = new ArrayList<>();
            this.alunos = new ArrayList<>();
        }

        // Adicionando livro à biblioteca
        public void adicionarLivro(Livro livro) {
            livros.add(livro);
        }

        // Removendo livro da biblioteca
        public void removerLivro(Livro livro) {
            livros.remove(livro);
        }

        // Adicionando professor à biblioteca
        public void adicionarProfessor(Professor professor) {
            professores.add(professor);
        }

        // Adicionando aluno à biblioteca
        public void adicionarAluno(Aluno aluno) {
            alunos.add(aluno);
        }

        // Listando livros da biblioteca
        public void listarLivros() {
            for (Livro livro : livros) {
                livro.exibirInformacoes();
                System.out.println();
            }
        }

        // Buscando livro na biblioteca
        public Livro buscarLivro(String titulo) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
            return null;
        }

        // Listando livros cadastrados na biblioteca
        public void listarLivrosCadastrados() {
            for (Livro livro : livros) {
                System.out.println(livro.getTitulo());
            }
        }

        // Listando professores cadastrados na biblioteca
        public void listarProfessoresCadastrados() {
            for (Professor professor : professores) {
                System.out.println(professor.getNome() + " - " + professor.getCpf());
            }
        }

        // Listando alunos cadastrados na biblioteca
        public void listarAlunosCadastrados() {
            for (Aluno aluno : alunos) {
                System.out.println(aluno.getNome() + " - " + aluno.getCpf());
            }
        }
    }

    // Classe Livro
    static class Livro {
        private String titulo;
        private String autor;
        private int estoque;

        // Método construtor
        public Livro(String titulo, String autor, int estoque) {
            this.titulo = titulo;
            this.autor = autor;
            this.estoque = estoque;
        }

        // Gets e sets
        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }


        public void setAutor(String autor) {
            this.autor = autor;
        }

        public int getEstoque() {
            return estoque;
        }

        public void setEstoque(int estoque) {
            this.estoque = estoque;
        }

        // Verificar se o livro está disponível para empréstimo
        public boolean isDisponivel() {
            return estoque > 0;
        }

        // Exibir informações do livro
        public void exibirInformacoes() {
            System.out.println("Título: " + titulo);
            System.out.println("Autor: " + autor);
            System.out.println("Estoque: " + estoque);
        }
    }
}
