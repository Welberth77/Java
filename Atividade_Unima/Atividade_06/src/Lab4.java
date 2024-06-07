import java.io.*;
import java.util.Scanner;
public class Lab4 {
    public static Scanner scanner = new Scanner(System.in);
    public static void ex() throws IOException {
        int resposta;
        do {
            System.out.print("=======================\n" +
                    "1. Criar Arquivo\n" +
                    "2. Escrever Linha\n" +
                    "3. Ler Arquivo\n" +
                    "4. Limpar Arquivo\n" +
                    "0. Fechar programa\n" +
                    "=======================\n" +
                    "Resposta: ");
            resposta = scanner.nextInt();
            switch (resposta){
                case 1: createFile(); break;
                case 2: writeToFile(); break;
                case 3: readFile(); break;
                case 4: clearFile(); break;
            }
        } while (resposta != 0);

    }
    public static void createFile() throws IOException {
        System.out.print("Nome do arquivo a ser criado: ");
        String nomeArquivo = scanner.nextLine();
        nomeArquivo = scanner.nextLine();

        //Caminho que o arquivo será criado
        File f = new File("C:/Users/welco/.vscode/.vscode/Java/Atividade_Unima/Atividade_06/src/" + nomeArquivo);
        boolean existe = f.exists();

        //Verificando se arquivo já existe
        if (existe) {
            System.out.println("Desculpe, já existe um arquivo com esse nome");
        }
        else {
            //Criando arquivo
            boolean arquivoCriado = f.createNewFile();
            System.out.println("Arquivo criado com sucesso!");
        }
    }

    public static void writeToFile() throws IOException {
        System.out.print("Nome do arquivo que deseja escrever? ");
        String nomeArquivo = scanner.nextLine();
        nomeArquivo = scanner.nextLine();

        //Verifica se arquivo existe
        File f = new File("C:/Users/welco/.vscode/.vscode/Java/Atividade_Unima/Atividade_06/src/" + nomeArquivo);
        boolean existe = f.exists();

        if (existe) {
            //Verifica aquivo para ser escrito
            FileWriter writer = new FileWriter("C:/Users/welco/.vscode/.vscode/Java/Atividade_Unima/Atividade_06/src/" + nomeArquivo, true);
            BufferedWriter bwriter = new BufferedWriter(writer);

            System.out.print("Escreva o que deseja adicionar: ");
            String texto = scanner.nextLine();

            bwriter.newLine();     //Cria uma linha vazia (Pula uma linha)
            bwriter.write(texto);  //Escreve o texto
            bwriter.close();       //Fecha o arquivo

            System.out.println("Texto adicionado com sucesso!");
        }
        else {
            System.out.println("Desculpe, arquivo não encontrado!");
        }
    }

    public static void readFile() throws IOException{
        System.out.print("Nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();
        nomeArquivo = scanner.nextLine();
        //Verificando se arquivo existe
        File f = new File("C:/Users/welco/.vscode/.vscode/Java/Atividade_Unima/Atividade_06/src/" + nomeArquivo);
        boolean existe = f.exists();

        if (existe) {
            //Lendo arquivo
            FileReader reader = new FileReader("C:/Users/welco/.vscode/.vscode/Java/Atividade_Unima/Atividade_06/src/" + nomeArquivo);
            BufferedReader bReader = new BufferedReader(reader);
            String linha;

            while ((linha = bReader.readLine()) != null){
                System.out.println(linha);
            }
            reader.close();
        }
        else {
            System.out.println("Arquivo não encontrado!");
        }
    }

    public static void clearFile() throws IOException{
        System.out.print("Nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();
        nomeArquivo = scanner.nextLine();

        File f = new File("C:/Users/welco/.vscode/.vscode/Java/Atividade_Unima/Atividade_06/src/" + nomeArquivo);
        boolean existe = f.exists();

        if (existe) {
            // Abre o arquivo para escrita
            FileWriter writer = new FileWriter(f);
            writer.write(""); // Limpa o conteúdo escrevendo uma string vazia
            writer.close();
            System.out.println("Arquivo limpo!");
        } else {
            System.out.println("Arquivo não encontrado!");
        }
    }
}
