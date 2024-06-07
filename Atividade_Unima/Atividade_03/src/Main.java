public class Main {
    public static void main(String[] args) {

        Carro carro1 = new Carro("Chevrolet", "Celta", "2013", "30.000");
        Carro carro2 = new Carro("wolksvagen", "Gol", "2015", "15.000");

        System.out.println(carro1.toString());
        System.out.println(carro2.toString());

        System.out.println("________________________________________________________________________");

        // Criando alunos
        Aluno aluno1 = new Aluno("José", 1, 3);
        Aluno aluno2 = new Aluno("Wel", 2, 3);
        Aluno aluno3 = new Aluno("Zé da manga", 3, 3);

        // Criando as disciplinas
        Disciplina projetoProgramacão = new Disciplina("Projeto de programação", "João Gabriel", 2);
        Disciplina sistemasDigitais = new Disciplina("Sistemas Digitais", "César", 3);
        Disciplina calculoII = new Disciplina("Cálculo II", "Djair", 1);

        // Matriculando alunos nas disciplinas
        projetoProgramacão.matricularAluno(aluno1);
        projetoProgramacão.matricularAluno(aluno2);
        projetoProgramacão.matricularAluno(aluno3);

        sistemasDigitais.matricularAluno(aluno3);
        sistemasDigitais.matricularAluno(aluno1);

        calculoII.matricularAluno(aluno2);
        calculoII.matricularAluno(aluno3);

        // Listando alunos de acordo com as disciplinas
        System.out.println("__________________________________________________________");
        projetoProgramacão.listarAlunos();
        System.out.println("__________________________________________________________");
        sistemasDigitais.listarAlunos();
        System.out.println("__________________________________________________________");
        calculoII.listarAlunos();
        System.out.println("__________________________________________________________");
    }
}