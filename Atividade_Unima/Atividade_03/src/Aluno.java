public class Aluno {
    public String nome;
    public int numeroMatricula;
    public Disciplina[] disciplinasMatriculadas;
    public int maximoDisciplinas;
    public int contadorDisciplinas;

    public Aluno(String nome, int numeroMatricula, int maximoDisciplinas) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
        this.maximoDisciplinas = maximoDisciplinas;
        this.disciplinasMatriculadas = new Disciplina[maximoDisciplinas];
        this.contadorDisciplinas = 0;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (contadorDisciplinas < maximoDisciplinas) {
            disciplinasMatriculadas[contadorDisciplinas] = disciplina;
            contadorDisciplinas++;
        } else {
            System.out.println("Limite de disciplinas alcançado para o aluno " + nome);
        }
    }

    public Disciplina[] getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }
}
