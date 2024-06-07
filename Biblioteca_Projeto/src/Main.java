import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Criando uma nova biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Criando um administrador
        Administrador admin = new Administrador("Admin1", "001");

        // Criando alguns livros
        Livro livro1 = new Livro("A volta ao mundo em 80 dias", "Júlio Verne", 1872, "Romance", 10);
        Livro livro2 = new Livro("Dom Quixote", "Miguel de Cervantes", 1605, "Aventura", 5);

        // Adicionando os livros à biblioteca através do administrador
        admin.adicionarLivro(livro1);
        admin.adicionarLivro(livro2);

        // Listando todos os livros da biblioteca
        biblioteca.listarLivros();

        // Exemplo de professor solicitando empréstimo de um livro
        Professor professor = new Professor("João", 123, "123.456.789-00", "Rua A, 123", "99999-9999", LocalDate.of(1990, 1, 1), "Departamento de Matemática", 5);
        professor.solicitarEmprestimo(livro1);
        professor.listarLivrosEmprestados();

        // Exemplo de aluno solicitando empréstimo de um livro
        Aluno aluno = new Aluno("Maria", 456, "987.654.321-00", "Rua B, 456", "88888-8888", LocalDate.of(2000, 2, 2), "Engenharia", 789, 3);
        aluno.solicitarEmprestimo(livro2);
        aluno.listarLivrosEmprestados();

        // devolvendo livros
        professor.solicitarDevolucao(livro1);
    }
}

// Classe Membro representa um membro da biblioteca
class Membro {
    private String nome;
    private int id;
    private String cpf;
    private String endereco;
    private String telefone;
    private LocalDate dataNascimento;
    private List<Livro> livrosEmprestados;


    // Método Construtor do membro
    public Membro(String nome, int id, String cpf, String endereco, String telefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.livrosEmprestados = new ArrayList<>();
    }

    // Gets e Sets
    public String obterNome() {
        return nome;
    }

    public int obterId() {
        return id;
    }

    public String obterCpf() {
        return cpf;
    }

    public String obterEndereco() {
        return endereco;
    }

    public String obterTelefone() {
        return telefone;
    }

    public LocalDate obterDataNascimento() {
        return dataNascimento;
    }

    // Listar livros emprestados
    public List<Livro> listarLivrosEmprestados() {
        for (Livro livro : livrosEmprestados) {
            livro.exibirInformacoes();
        }
        return livrosEmprestados;
    }

    // Calculando valor do emprestimo
    public void calcularValorEmprestimo(){
        Scanner scanner = new Scanner(System.in);
        int tempo;
        float valorSemanal = 4;
        System.out.print("Por quantas semanas deseja alugar o livro? ");
        tempo = scanner.nextInt();
        float valorTotal = tempo * valorSemanal;
        System.out.printf("O valor a ser pago por %d semanas é de R$: %.2f\n", tempo, valorTotal);
    }

    // Solicitando emprestimo
    public void solicitarEmprestimo(Livro livro) {
        if (livro.isDisponivel()) {
            calcularValorEmprestimo();
            livro.setEstoque(livro.getEstoque() - 1);
            livrosEmprestados.add(livro);
            System.out.println("Empréstimo do livro " + livro.getTitulo() + " realizado com sucesso!");
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não está disponível para empréstimo.");
        }
    }

    public void situacaoLivro(){
        Scanner scanner = new Scanner(System.in);
        float nota;
        float multa = 0;
        System.out.println("De 0 a 10 qual o estado do seu livro? ");
        nota = scanner.nextInt();
        if (nota == 0) {
            multa = 80;
        } else if (nota >= 1 && nota <= 3) {
            multa = 50;
        } else if (nota >= 4 && nota <= 6) {
            multa = 40;
        } else if (nota >= 7 && nota <= 9) {
            multa = 20;
        } else if (nota == 10) {
            multa = 0;
        } else {
            System.out.println("Digite um valor válido!");
        }
        System.out.printf("O valor da multa é de R$: %.2f\n", multa);
    }

    // Solicitar devolução do livro
    public void solicitarDevolucao(Livro livro) {
        if (livrosEmprestados.remove(livro)) {
            situacaoLivro();
            livro.setEstoque(livro.getEstoque() + 1);
            System.out.println("Devolução do livro " + livro.getTitulo() + " realizada com sucesso!");
        } else {
            System.out.println("Este livro não foi emprestado a você.");
        }
    }

    // Renovar emprestimo
    public void renovarEmprestimo(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            System.out.println("Empréstimo do livro " + livro.getTitulo() + " renovado com sucesso!");
        } else {
            System.out.println("Este livro não foi emprestado a você.");
        }
    }
}

// Classe Professor que herda da classe Membro
class Professor extends Membro {
    private String departamento;
    private int limiteEmprestimo;

    // Método construtor
    public Professor(String nome, int id, String cpf, String endereco, String telefone, LocalDate dataNascimento, String departamento, int limiteEmprestimo) {
        super(nome, id, cpf, endereco, telefone, dataNascimento);
        this.departamento = departamento;
        this.limiteEmprestimo = limiteEmprestimo;
    }

    // Gets e Sets
    public String obterDepartamento() {
        return departamento;
    }

    public int obterLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    // Aplicando desconto para professores
    public float obterDesconto() {
        return 0.10f; // 10% de desconto
    }
}

// Classe Aluno que herda da classe Membro
class Aluno extends Membro {
    private String curso;
    private int numMatricula;
    private int limiteEmprestimo;

    // Método construtor
    public Aluno(String nome, int id, String cpf, String endereco, String telefone, LocalDate dataNascimento, String curso, int numMatricula, int limiteEmprestimo) {
        super(nome, id, cpf, endereco, telefone, dataNascimento);
        this.curso = curso;
        this.numMatricula = numMatricula;
        this.limiteEmprestimo = limiteEmprestimo;
    }

    // Gets e sets
    public String obterCurso() {
        return curso;
    }

    public int obterNumMatricula() {
        return numMatricula;
    }

    public int obterLimiteEmprestimo() {
        return limiteEmprestimo;
    }
}

// Classe Administrador
class Administrador {
    private String nome;
    private String idAdm;
    private List<Livro> livros;

    // Método construtor
    public Administrador(String nome, String idAdm) {
        this.nome = nome;
        this.idAdm = idAdm;
        this.livros = new ArrayList<>();
    }

    // Gets e sets
    public String obterNome() {
        return nome;
    }

    public String obterIdAdm() {
        return idAdm;
    }

    // Adicionando livro a biblioiteca
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso: " + livro.getTitulo());
    }

    // removendo livro da biblioteca
    public void removerLivro(String nomeLivro) {
        Livro livroARemover = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(nomeLivro)) {
                livroARemover = livro;
                break;
            }
        }
        if (livroARemover != null) {
            livros.remove(livroARemover);
            System.out.println("Livro removido com sucesso: " + livroARemover.getTitulo());
        } else {
            System.out.println("Livro não encontrado: " + nomeLivro);
        }
    }

    // Atualizando estoque da biblioteca
    public void atualizarEstoque(String tituloLivro, int novoEstoque) {
        Livro livro = buscarLivro(tituloLivro);
        if (livro != null) {
            livro.setEstoque(novoEstoque);
            System.out.println("Estoque do livro " + livro.getTitulo() + " atualizado para " + novoEstoque);
        } else {
            System.out.println("Livro não encontrado: " + tituloLivro);
        }
    }

    // Buscando livro na biblioteca
    private Livro buscarLivro(String tituloLivro) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(tituloLivro)) {
                return livro;
            }
        }
        return null;
    }

    // Listar todos os livros da biblioteca
    public void listarLivros() {
        for (Livro livro : livros) {
            livro.exibirInformacoes();
        }
    }
}

// Classe Biblioteca
class Biblioteca {
    private List<Livro> livros;

    // Método construtor
    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    // Adicionando livro à biblioteca
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    // Listando livros da biblioteca
    public void listarLivros() {
        for (Livro livro : livros) {
            livro.exibirInformacoes();
            System.out.println();
        }
    }
}

// Classe Livro
class Livro {
    private String titulo;
    private String autor;
    private int anoLancamento;
    private String genero;
    private int estoque;

    // Método construtor
    public Livro(String titulo, String autor, int anoLancamento, String genero, int estoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
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

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    // Verificando se livro está disponível
    public boolean isDisponivel() {
        return estoque > 0;
    }

    // Exibir iinformações do livro
    public void exibirInformacoes() {
        System.out.println("Título: " + titulo +
                " \nAutor: " + autor +
                " \nAno de lançamento: " + anoLancamento +
                " \nGênero: " + genero);
        if (estoque > 0) {
            System.out.println("Disponível? Sim");
            System.out.println("Estoque: " + estoque);
        } else {
            System.out.println("Disponível? Não");
        }
    }
}
