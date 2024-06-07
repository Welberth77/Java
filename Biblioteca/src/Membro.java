import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;

public class Membro {
    private String nome;
    private int id;
    private String cpf;
    private String endereco;
    private String telefone;
    private int dia;
    private int mes;
    private int ano;
    private List<Livro> livrosEmprestados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = Integer.parseInt(dia);
    }

    public int getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = Integer.parseInt(mes);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = Integer.parseInt(ano);
    }

//    public void solicitarEmprestimo(Livro livro) {
//        if (livro.isDisponivel()) {
//            livro.setDisponivel(false);
//            livrosEmprestados.add(livro);
//            System.out.println("Empréstimo do livro " + livro.getTitulo() + "realizado com sucesso!");
//        } else {
//            System.out.println("O livro " + livro.getTitulo() + " não está disponível para empréstimo.");
//        }
//    }
}
