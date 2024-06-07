import java.util.ArrayList;
import java.util.List;
public class Biblioteca {
    public String nome;
    public List<Livro> livros;
    public List<Membro> membros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso: " + livro.getTitulo());
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            livro.exibirInformacoes();
            System.out.println();
        }
    }
}
