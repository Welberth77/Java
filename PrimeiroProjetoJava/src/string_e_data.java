import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class string_e_data {
    public static void main(String[] args) {
        //Manipulação de strings
        String nome = "Welberth";
        System.out.println(nome.toUpperCase()); // Letras Maiusculas
        System.out.println(nome.toLowerCase()); // Letras minusculas
        System.out.println(nome.length()); // Tamanho do texto

        String nomeOutro = "welberth";
        System.out.println(nome.equalsIgnoreCase(nomeOutro)); // Comparação de duas strings

        LocalDate hoje = LocalDate.now();
        @SuppressWarnings("deprecation")
        Locale brasil = new Locale("pt", "BR"); // Adiciona novo local, Brasil e lingua pt
        String diaSemana = hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, brasil); // Exibe dia da semana atual em ptBR

        String saudacao;
        LocalDateTime agora = LocalDateTime.now(); // Verifica horario atual

        if (agora.getHour() >= 0 && agora.getHour() < 12) {
            saudacao = "Bom dia!";
        }
        else if (agora.getHour() >= 12 && agora.getHour() < 18) {
            saudacao = "Boa tarde!";
        }
        else if (agora.getHour() > 18 && agora.getHour() < 24) {
            saudacao = "Boa noite!";
        }
        else {
            saudacao = "Olá";
        }

        System.out.printf("Olá %s. Hoje é %s, %s.%n", nome, diaSemana, saudacao.toUpperCase());
    }
}
