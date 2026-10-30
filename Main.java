import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int tamanho = 100;
        int quantidade = 1000;

        TabelaHash tabela = new TabelaHash(tamanho);
        Random random = new Random(1090);

        for (int i = 0; i < quantidade; i++) {
            int numero = random.nextInt(100001);
            tabela.inserir(numero);
        }

        System.out.println("Listas encadeadas: " + tabela.contarListas());
        System.out.println("Posicoes vazias: " + tabela.contarPosicoesVazias());
        System.out.println("Maior lista: " + tabela.tamanhoMaiorLista() + " nos");
        System.out.println("Posicao da maior lista: " + tabela.posicaoMaiorLista());

        tabela.imprimirUltimosValores();
    }
}