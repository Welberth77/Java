public class Aluno {
    private String curso;
    private int numMatricula;
    private int limiteEmprestimo;

    public Aluno(String curso, int numMatricula, int limiteEmprestimo) {
        this.curso = curso;
        this.numMatricula = numMatricula;
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public int getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(int limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

}

