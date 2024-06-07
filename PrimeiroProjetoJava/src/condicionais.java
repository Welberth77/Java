public class condicionais {
    public static void main(String[] args) {
        // Armazenando a nota
        int nota = 75;
        String graduação;

        //A 80, B 70, C 60, C 0
        if (nota >= 80) {
            graduação = "A";
        }
        else if (nota < 80 && nota >= 70) {
            graduação = "B";
        }
        else if (nota < 70 && nota >= 60) {
            graduação = "C";
        }
        else if (nota < 60 && nota >= 0) {
            graduação = "D";
        }
        else {
            graduação = " ";
        }

        switch (graduação) {
            case "A":
            case "B":
                System.out.println("Aluno aprovado!");
                break;
            case "C":
            case "D":
                System.out.println("Não aprovado");
                break;
            default:
                System.out.println("Graduação inválida");
                break;
        }
    }
}
