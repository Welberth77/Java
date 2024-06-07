package animais;

public class Gato extends Animal {
    // Atributos
    static int numerodeGatos;

    public Gato(String nome, String cor, double peso) {
        super(nome, cor, peso);
        numerodeGatos++;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public void soar() {
        System.out.println("Miau");
    }
}
