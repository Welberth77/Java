import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private String nome;
    private String idAdm;
    private List<Livro> livros;

    public Administrador(String nome, String idAdm) {
        this.nome = nome;
        this.idAdm = idAdm;
        this.livros = new ArrayList<>();
    }

    public String obterNome() {
        return nome;
    }

    public String obterIdAdm() {
        return idAdm;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso: " + livro);
    }

    public void removerLivro(String nome_livro) {
        Livro livroARemover = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(nome_livro)) {
                livroARemover = livro;
                break;
            }
        }
        if (livroARemover != null) {
            livros.remove(livroARemover);
            System.out.println("Livro removido com sucesso: " + livroARemover);
        } else {
            System.out.println("Livro não encontrado: " + nome_livro);
        }
    }

    // Atualizar dados do livro
    public void atualizarLivro(Livro livro, String titulo, String autor, int anoLancamento, String genero, int estoque) {
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoLancamento(anoLancamento);
        livro.setGenero(genero);
        livro.setEstoque(estoque);
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}