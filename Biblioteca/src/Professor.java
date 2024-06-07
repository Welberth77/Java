public class Professor {
    private String departamento;
    private int limiteEmprestimo;

    public Professor(String departamento, int limiteEmprestimo) {
        this.departamento = departamento;
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(int limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public float obterDesconto() {
        return 0.10f; // Não lembro quanto vai ser o desconto então botei 10%
    }
}
