public class Livro {
    private String titulo;
    private String autor;
    private int anoLancamento;
    private String genero;
    private int estoque;

    public Livro(String titulo, String autor, int anoLancamento, String genero, int estoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.estoque = estoque;  // Ao cadastrar um livro por padrão ele está disponível
    }

    // Getts e setts

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

    public void exibirInformacoes() {
        System.out.println("Titulo: " + titulo +
                " \nAutor: " + autor +
                " \nAno de lançamento " + anoLancamento +
                " \nGênero: " + genero);

        if (estoque > 0) {
            System.out.println("Disponível? Sim");
            System.out.println("Estoque: " + estoque);
        } else {
            System.out.println("Disponível? Não");
        }
    }
}
