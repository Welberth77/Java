import Lojas.Petshop;
import animais.Cachorro;
import animais.Gato;
import animais.Passaro;

public class Main {
    public static void main(String[] args) throws Exception {

        Cachorro cachorro1 = new Cachorro("Rex", "Marrom", 5);

        Gato gato1 = new Gato("Felix", "Preto", 10);

        Passaro passaro1 = new Passaro("Zeca Urubu", "Preto", 40);

        cachorro1.soar();
        gato1.soar();
        passaro1.soar();
    }
}
