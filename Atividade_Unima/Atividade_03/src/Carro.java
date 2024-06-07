public class Carro {
    private String marca;
    private String modelo;
    private String ano;
    private String preco;

    public Carro(String marca, String modelo, String ano, String preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "marca: " + marca + " | "+
                "modelo: " + modelo + " | " +
                "ano: " + ano + " | " +
                "preco: " + preco;
    }
}
