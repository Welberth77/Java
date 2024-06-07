import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab3 {
    public static ArrayList<String> listaDeTintas = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void ex() {
        int resposta;
        do {
            System.out.println("1. Criar Array\n" +
                    "2. Printar Array\n" +
                    "3. Adicionar Cor\n" +
                    "4. Remover Cor\n" +
                    "5. Verificar Cor\n" +
                    "6. Cor na Posição\n" +
                    "7. Ordenar Array\n" +
                    "8. Embaralhar Array\n" +
                    "9. Sair");
            System.out.print("Resposta: ");
            resposta = scanner.nextInt();

            switch (resposta){
                case 1: createArray(); break;
                case 2: printArray(); break;
                case 3: addToArray(); break;
                case 4: removeFromArray(); break;
                case 5: hasString(); break;
                case 6: stringInPos(); break;
                case 7: sortArray(); break;
                case 8: shuffleArray(); break;
                case 9:
                    System.out.println("Fechando programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(resposta != 9);
    }

    public static void createArray(){
        for (int i = 1; i <= 3; i++){
            System.out.print("Digite a " + i + "º cor: ");
            String cor = scanner.next();
            listaDeTintas.add(cor);
        }
    }

    public static void printArray(){
        for (int i = 0; i < listaDeTintas.size(); i++){
            System.out.print(listaDeTintas.get(i) + " ");
        }
        System.out.println("\n");
    }

    public static void addToArray(){
        System.out.print("Digite a cor: ");
        String cor = scanner.next();
        listaDeTintas.add(cor);
        System.out.println("Cor " + cor + " adicionada com sucesso!" );
    }

    public static void removeFromArray(){
        System.out.print("Digite a cor que deseja remover: ");
        String cor = scanner.next();

        if (listaDeTintas.contains(cor)) {
            listaDeTintas.remove(cor);
            System.out.println("Cor removida com sucesso!");
        }
        else {
            System.out.println("Não foi encontrada essa cor na lista");
        }
    }

    public static void hasString(){
        System.out.print("Qual cor deseja verificar na lista? ");
        String cor = scanner.next();

        if (listaDeTintas.contains(cor)) {
            System.out.println("Cor encontrada com sucesso!");
        }
        else {
            System.out.println("Cor não encontrada na lista");
        }
    }

    public static void stringInPos(){
        System.out.print("Qual posição deseja verificar? ");
        int posicao = scanner.nextInt();

        if (posicao >= listaDeTintas.size()) {
            System.out.println("Erro! A posição digitada é maior que a lista");
        }
        else {
            System.out.println(listaDeTintas.get(posicao));
        }
    }

    public static void sortArray(){
        Collections.sort(listaDeTintas);
        System.out.println(listaDeTintas);
    }

    public static void shuffleArray(){
        Collections.shuffle(listaDeTintas);
        System.out.println(listaDeTintas);
    }
}