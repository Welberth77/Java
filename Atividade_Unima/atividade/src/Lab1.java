import java.util.Scanner;

public class Lab1 {
  public static void cadastrarCliente() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Qual o nome do cliente? ");
    String nome = scanner.nextLine();

    System.out.print("Qual a idade do cliente? ");
    int idade = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Qual o CPF do cliente? ");
    String cpf = scanner.nextLine();

    System.out.print("Qual o endereço do cliente? ");
    String endereco = scanner.nextLine();

    System.out.println("\nDados do cliente cadastrado:");
    System.out.println("Nome: " + nome);
    System.out.println("Idade: " + idade);
    System.out.println("CPF: " + cpf);
    System.out.println("Endereço: " + endereco);
  }

  public static void calcularEmprestimo() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Qual o seu Salário? ");
    double salario = scanner.nextDouble();

    System.out.println("Qual o saldo da sua conta? ");
    double saldo = scanner.nextDouble();

    double emprestimoMaximo = (salario * 3) + (saldo / 5);

    System.out.printf("O valor máximo do empréstimo é %.2f%n", emprestimoMaximo);
  }

  public static void idadeEmDias() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Quantos anos de idade ? ");
    int idadeAnos = scanner.nextInt();

    System.out.print("Quantos meses de idade ? ");
    int idadeMeses = scanner.nextInt();

    System.out.print("Quantos dias de idade? ");
    int idadeDias = scanner.nextInt();

    int idadeTotalDias = (idadeAnos * 365) + (idadeMeses * 30) + idadeDias;

    System.out.println("A idade total em dias é: " + idadeTotalDias);

  }

  public static void imparOuPar() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite um número inteiro: ");
    int numero = scanner.nextInt();

    if (numero % 2 == 0) {
      System.out.println("O número é par.");
    } else {
      System.out.println("O número é ímpar. ");
    }
  }

  public static void reajusteSalarial() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o sálario atual: ");
    double salario = scanner.nextDouble();

    if (salario >= 0 && salario < 2000) {
      salario = salario + (salario * 0.10) + 200;
    } else if (salario >= 2000 && salario < 5000) {
      salario = salario + (salario * 0.08) + 150;
    } else if (salario >= 5000) {
      salario = salario + (salario * 0.05);
    } else {
      System.out.println("Salário inválido");
    }

    System.out.println("O novo salário é: " + salario);
  }
}