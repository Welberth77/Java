public class Disciplina {
    public String nome;
    public String professor;
    public Aluno[] alunos;
    public int tamanhoMaximo;
    public int contadorAlunos;

    public Disciplina(String nome, String professor, int tamanhoMaximo) {
        this.nome = nome;
        this.professor = professor;
        this.tamanhoMaximo = tamanhoMaximo;
        this.alunos = new Aluno[tamanhoMaximo];
        this.contadorAlunos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public int getTamanhoMaximo() {
        return tamanhoMaximo;
    }

    public void setTamanhoMaximo(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public void matricularAluno(Aluno aluno) {
        if (contadorAlunos < tamanhoMaximo) {
            alunos[contadorAlunos] = aluno;
            contadorAlunos++;
            System.out.println("Aluno " + aluno.getNome() + " matriculado com sucesso na disciplina " + nome);
        } else {
            System.out.println("Não foi possível matricular o aluno " + aluno.getNome() + ". Turma cheia.");
        }
    }

    public void listarAlunos() {
        System.out.println("Alunos matriculados na disciplina " + nome + ":");
        for (int i = 0; i < contadorAlunos; i++) {
            System.out.println(alunos[i].getNome());
        }
    }
}
