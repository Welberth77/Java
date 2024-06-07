import java.util.*;
import java.util.HashMap;

public class Lista1 {
    public static void listaTelefonica() {
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int resposta;
        do {
            System.out.println("[1] - Adicionar contato\n" +
                    "[2] - Remover contato\n" +
                    "[0] - Sair");
            System.out.print("Resposta: ");
            resposta = scanner.nextInt();

            // Adicionando nome e numero a lista
            if (resposta == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                nome = scanner.nextLine();
                System.out.print("Número: ");
                int numero = scanner.nextInt();
                nomes.add(nome);
                numeros.add(numero);
                System.out.println("Contato " + nome + " adicionado com sucesso!");
                System.out.println(nomes);
            }

            // Removendo nome e numero da lista
            if (resposta == 2) {
                System.out.print("Nome do contato a ser removido: ");
                String nome = scanner.nextLine();
                nome = scanner.nextLine();

                for (int i = 0; i < nomes.size(); i++) {
                    if (nomes.get(i).equals(nome)){
                        nomes.remove(i);
                        numeros.remove(i);
                        System.out.println("Contato " + nome + " removido com sucesso!");
                        break;
                    }
                    else {
                        System.out.println("Contato " + nome + " não encontrado!");
                    }
                }
            }
        } while (resposta != 0);
    }

    public static void bauDePizza() {
        Stack<String> sabores = new Stack<>();
        Stack<String> enderecos = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        int resposta;
        do {
            System.out.println("\n[1] - Adicionar pizza\n" +
                    "[2] - Remover pizza\n" +
                    "[3] - Checar pizza\n" +
                    "[4] - listar pizzas\n" +
                    "[0] - Sair");
            System.out.print("Resposta: ");
            resposta = scanner.nextInt();

            // Adicionar pizza
            if (resposta == 1) {
                System.out.println("===== NOVO PEDIDO =====");
                System.out.print("Sabor da pizza: ");
                String sabor = scanner.nextLine();
                sabor = scanner.nextLine();
                System.out.print("Endereço de entrega: ");
                String endereco = scanner.nextLine();

                sabores.push(sabor);
                enderecos.push(endereco);

                System.out.println("Pedido finalizado com sucesso!");
            }

            // Removendo pizza (so pode remover a pilha do topo)
            else if (resposta == 2) {
                if (!sabores.empty()) {
                    System.out.print("Pizza " + sabores.peek());
                    sabores.pop();
                    enderecos.pop();
                    System.out.println(" removida com sucesso!");
                }
                else {
                    System.out.println("Não tem pizzas para remover!");
                }
            }

            // Checando pizza do topo
            else if (resposta == 3) {
                if (!sabores.empty()) {
                    System.out.println("A pizza de " + sabores.peek() + " está no topo");
                }
                else {
                    System.out.println("Não tem nenhuma pizza!");
                }
            }

            // Listando pizzas
            else if (resposta == 4){
                Iterator<String> i = sabores.iterator();
                Iterator<String> j = enderecos.iterator();
                while (i.hasNext()) {
                    System.out.print("Sabor: " + i.next() + ", enderço: " + j.next() + "\n");
                }
            }
        } while(resposta != 0);
    }

    public static void sistemaAcademico() {
        HashMap<Integer, String> mapa = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int resposta;
        do {
            System.out.println("[1] - Adicionar aluno\n" +
                    "[2] - Remover aluno\n" +
                    "[3] - Listar alunos\n" +
                    "[4] - Listar CPFs\n" +
                    "[0] - Sair");
            System.out.print("Resposta: ");
            resposta = scanner.nextInt();

            // Adicionar aluno
            if (resposta == 1) {
                int cpf;
                String nome;

                System.out.print("CPF do aluno: ");
                cpf = scanner.nextInt();
                System.out.print("Nome do aluno: ");
                nome = scanner.nextLine();
                nome = scanner.nextLine();

                if (mapa.containsKey(cpf)) {
                    System.out.println("O aluno não foi adicionado!");
                    System.out.println("Este CPF já esta cadastrado!");
                }
                else {
                    mapa.put(cpf, nome);
                    System.out.println("Aluno adicionado com sucesso!");
                }
            }

            // Remover aluno
            else if (resposta == 2) {
                int cpf;

                System.out.print("cpf do aluno que deseja remover: ");
                cpf = scanner.nextInt();

                if (mapa.containsKey(cpf)) {
                    mapa.remove(cpf);
                    System.out.println("Aluno removido com sucesso!");
                }
                else {
                    System.out.println("Desculpe, não encontramos nenhum aluno com esse CPF!");
                }
            }

            // Listar alunos
            else if (resposta == 3) {
                Set<Integer> chaves = mapa.keySet();
                Iterator<Integer> i = chaves.iterator();
                Integer ch;

                System.out.println("====== Lista de alunos ======");
                while (i.hasNext()) {
                    ch = i.next();
                    System.out.println(mapa.get(ch));
                }
                System.out.println("========================");
            }

            // Listar CPFs
            else if (resposta == 4) {
                Set<Integer> chaves = mapa.keySet();
                Iterator<Integer> i = chaves.iterator();
                Integer ch;

                System.out.println("====== Lista de CPFs ======");
                while (i.hasNext()) {
                    ch = i.next();
                    System.out.println(ch);
                }
                System.out.println("========================");
            }
        } while (resposta != 0);
    }
}
