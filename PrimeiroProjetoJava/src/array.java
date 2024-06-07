import java.util.Arrays;

public class array {
    public static void main(String[] args) {

        int[] numeros = new int[5];

        numeros[0] = 1;
        numeros[1] = 2;
        numeros[2] = 3;
        numeros[3] = 4;
        numeros[4] = 5;

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        String[] letras = {"A", "B", "C", "D", "E"};

        System.out.println(Arrays.toString(letras));

        // Calculando maior valor, menor valor e a soma
        int[] arrayNumeros = {9, 10, 12, 25, 2};

        int maior = arrayNumeros[0];
        int menor = arrayNumeros[0];
        int soma = 0;

        for (int i = 0; i < arrayNumeros.length; i++) {
            if (arrayNumeros[i] > maior) {
                maior = arrayNumeros[i];
            }
            if (arrayNumeros[i] < menor) {
                menor = arrayNumeros[i];
            }
            soma += arrayNumeros[i];
        }

        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);
        System.out.println("Média: " + soma / arrayNumeros.length);
    } 
}
