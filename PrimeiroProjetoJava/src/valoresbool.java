public class valoresbool {
    public static void main(String[] args) {

        Boolean fimDeSemana = false;
        boolean fazendoSol = true;
        boolean vamosAPraia = fimDeSemana && fazendoSol;

        System.out.println("resultado é " + vamosAPraia);
        
        String mensagem = fimDeSemana ? "É fim de semana!" : "Não é fim de semana!";
        System.out.println(mensagem);
    }
}
