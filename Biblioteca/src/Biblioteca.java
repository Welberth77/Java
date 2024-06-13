import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    // Salvar livros no arquivo
    public void salvarLivrosNoArquivo() {
        try (FileWriter writer = new FileWriter("livros.txt")) {
            for (Livro livro : livros) {
                writer.write(livro.getTitulo() + "," + livro.getAutor() + "," + livro.getAnoLancamento() + "," + livro.getGenero() + "," + livro.getEstoque() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar livros no arquivo: " + e.getMessage());
        }
    }

    // Carregar livros do arquivo
    public void carregarLivrosDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("livros.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                Livro livro = new Livro(dados[0], dados[1], Integer.parseInt(dados[2]), dados[3], Integer.parseInt(dados[4]));
                livros.add(livro);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar livros do arquivo: " + e.getMessage());
        }
    }
}
