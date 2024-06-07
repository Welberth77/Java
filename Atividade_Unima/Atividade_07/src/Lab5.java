import java.util.ArrayList;

class Pessoa {
    private String nome;
    private int idade;
    private String cpf;

    public Pessoa(String nome, int idade, String cpf){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, int idade, String cpf, String matricula) {
        super(nome, idade, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno: " + getNome() + " | Idade: " + getIdade() + " | CPF: " + getCpf() + " | matricula: " + matricula;
    }
}

class Professor extends Pessoa {
    private String siape;
    private ArrayList<Aluno> turma;

    public Professor(String nome, int idade, String cpf, String siape) {
        super(nome, idade, cpf);
        this.siape = siape;
        this.turma = new ArrayList<>();
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public ArrayList<Aluno> getTurma() {
        return turma;
    }

    public void setTurma(ArrayList<Aluno> turma) {
        this.turma = turma;
    }

    public void addAluno(Aluno aluno){
        turma.add(aluno);
    }

    public void removerAluno(String nome) {
        boolean alunoRemovido = false;
        for (int i = 0; i < turma.size(); i++) {
            if (turma.get(i).getNome().equals(nome)) {
                turma.remove(i);
                alunoRemovido = true;
                System.out.println("Aluno removido com sucesso!");
                break; // Sair do loop após remover para evitar múltiplas remoções
            }
        }
        if (!alunoRemovido) {
            System.out.println("Aluno não encontrado!");
        }
    }
    public void printTurma() {
        for (Aluno aluno : turma){
            System.out.println(aluno);
        }
    }

    @Override
    public String toString() {
        return "Aluno: " + getNome() + " | Idade: " + getIdade() + " | CPF: " + getCpf() + " | SIAPE: " + getSiape();}
}

// Veiculo
class Veiculo {
    private String nome;
    private String marca;
    private String placa;
    private double aceleracao;
    private double velocidadeMaxima;

    public Veiculo(String nome, String marca, String placa, double aceleracao, double velocidadeMaxima){
        this.nome = nome;
        this.marca = marca;
        this.placa = placa;
        this.aceleracao = aceleracao;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getAceleracao() {
        return aceleracao;
    }

    public void setAceleracao(double aceleracao) {
        this.aceleracao = aceleracao;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void acelerar(int multiplicador) {
        double velocidadeAtual = aceleracao * multiplicador;
        if (velocidadeAtual > velocidadeMaxima){
            velocidadeAtual = velocidadeMaxima;
        }
        System.out.println("Velocidade atual é: " + velocidadeAtual + " km/h");
    }

    public void freio() {
        if (aceleracao <= 0) {
            System.out.println("A aceleração deve ser positiva.");
        }
        double tempoParaParar = velocidadeMaxima / aceleracao;
        System.out.println("Tempo para parar é: " + tempoParaParar + " segundos");
    }

    public void freio(int multiplicador) {
        if (aceleracao <= 0) {
            System.out.println("A aceleração deve ser positiva.");
        }
        double tempoParaParar = velocidadeMaxima / (aceleracao * multiplicador);
        System.out.println("Tempo para parar é: " + tempoParaParar + " segundos");
    }
}

class CarroPopular extends Veiculo {
    public CarroPopular(String nome, String marca, String placa, double aceleracao, double velocidadeMaxima) {
        super(nome, marca, placa, aceleracao, velocidadeMaxima);
        if (velocidadeMaxima > 160){
            setVelocidadeMaxima(160);
        }
    }

    @Override
    public void acelerar(int multiplicador) {
        double velocidadeAtual = getAceleracao() * multiplicador;
        if (velocidadeAtual <= getVelocidadeMaxima()) {
            System.out.println("A velocidade atual é: " + velocidadeAtual + " Km/h");
        } else {
            System.out.println("Erro!");
        }
    }
}

class CarroPotente extends Veiculo{
    public CarroPotente(String nome, String marca, String placa, double aceleracao, double velocidadeMaxima) {
        super(nome, marca, placa, aceleracao, velocidadeMaxima);
        if (velocidadeMaxima > 240){
            setVelocidadeMaxima(240);
        } else if (velocidadeMaxima < 160){
            setVelocidadeMaxima(160);
        }
    }

    @Override
    public void acelerar(int multiplicador){
        double velocidadeAtual = getAceleracao() * multiplicador;
        if (velocidadeAtual <= getVelocidadeMaxima()){
            System.out.println("A velocidade atual é: " + velocidadeAtual + " Km/h");
        } else {
            System.out.println("Erro!");
        }
    }
}

public class Lab5 {
    public static void main(String[] args) {
        // Criando 3 alunos
        Aluno a1 = new Aluno("Welberth", 19, "123456789-10", "1231525468");
        Aluno a2 = new Aluno("Ricardo", 19, "123654987-11", "1231525469");
        Aluno a3 = new Aluno("Paulo", 23, "123654987-14", "1231525472");
        // Criando Professor
        Professor p1 = new Professor("César", 33, "321654987-21", "78945612389");

        // Adicionando alunos a turma
        p1.addAluno(a1);
        p1.addAluno(a2);
        p1.addAluno(a3);

        // Printando turma
        System.out.println("==== Alunos da turma ====");
        p1.printTurma();


        // Criando carros
        CarroPopular carro1 = new CarroPopular("Onix", "Chevrolet", "abc1234", 5, 150);
        CarroPotente carro2 = new CarroPotente("Corvete", "Chevrolet", "cba4321", 15, 240);

        // Método acelerar e freiar
        carro1.acelerar(10);
        carro1.freio(4);

        carro2.acelerar(15);
        carro2.freio(4);
    }
}