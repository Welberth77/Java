package animais;

public class Cachorro extends Animal {
    // Atributos
    static int numeroDeCachorros;
    private int tamanhoDoRabo;

    // Construtores
    public Cachorro(String nome, String cor, double peso) {
        super(nome, cor, peso);
        numeroDeCachorros++;
    }

    // Metodos
    // Nome
    public static int getNumeroDeCachorros() {
        return numeroDeCachorros;
    }

    public static void setNumeroDeCachorros(int numeroDeCachorros) {
        Cachorro.numeroDeCachorros = numeroDeCachorros;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Cor
    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    // Altura
    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    // Peso
    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Tamanho do rabo
    public int getTamanhoDoRabo() {
        return this.tamanhoDoRabo;
    }

    public void setTamanhoDoRabo(int tamanhoDoRabo) {
        this.tamanhoDoRabo = tamanhoDoRabo;
    }

    // Estado de espirito
    public String getEstadoDeEspirito() {
        return this.estadoDeEspirito;
    }

    public void setEstadoDeEspirito(String estadoDeEspirito) {
        this.estadoDeEspirito = estadoDeEspirito;
    }

    public String pegar() {
        return "Bolinha";
    }

    public String interagir(String acao) {

        switch (acao) {
            case "carinho": this.estadoDeEspirito = "Feliz"; break;
            case "vai dormir": this.estadoDeEspirito = "Bravo"; break;
            case "pisar na patinha": this.estadoDeEspirito = "Triste"; break;
            default: this.estadoDeEspirito = "Neutro"; break;
        }
        return this.estadoDeEspirito;
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public void soar() {
        System.out.println("Au Au");
    }
}
