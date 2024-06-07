import java.util.Scanner;

public class Lab2 {
    // EX 01
    public static void sequencia(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // EX 02
    public static void potenciacao(int n, int y) {
        int temp = n;
        for (int i = 1; i < y; i++) {
            temp = temp * n;
        }
        System.out.println(temp);
    }

    // EX 03
    public static void somaTotal(int n) {
        int soma = 0;
        for (int i = 1; i <= n; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o " + i + "º número: ");
            int num = scanner.nextInt();
            soma = soma + num;
        }
        System.out.println("A soma total é: " + soma);
    }

    // EX 04
    public static void maisNovo() {
        Scanner scanner = new Scanner(System.in);

        String nomeMaisNova = "";
        int idadeMaisNova = Integer.MAX_VALUE;

        for (int i = 1; i <= 3; i++) {
            System.out.print("Digite o nome da " + i + "ª pessoa: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a idade da " + i + "ª pessoa: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            if (idade < idadeMaisNova) {
                idadeMaisNova = idade;
                nomeMaisNova = nome;
            }
        }
        System.out.println("A pessoa mais nova é " + nomeMaisNova + " com " + idadeMaisNova + " anos.");
    }

    // EX 05
    public static void faixasNumericas() {
        int faixa1 = 0; // Entre 0-100
        int faixa2 = 0; // Entre 101-500
        int faixa3 = 0; // Acima de 500+
        for (int i = 1; i <= 10; i++) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o " + i + "ª número: ");
            int num = scanner.nextInt();

            if (num >= 0 && num <= 100) {
                faixa1++;
            } else if (num >= 101 && num <= 500) {
                faixa2++;
            } else if (num > 500) {
                faixa3++;
            }
        }
        System.out.println("Números entre 0-100: " + faixa1);
        System.out.println("Números entre 101-500: " + faixa2);
        System.out.println("Números acima de 500: " + faixa3);
    }
}