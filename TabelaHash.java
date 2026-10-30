public class TabelaHash {

    private static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private final int tamanho;
    private final int[] matriz;
    private final boolean[] ocupada;
    private final No[] listas;

    private int ultimo1 = -1;
    private int ultimo2 = -1;
    private int ultimo3 = -1;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.matriz = new int[tamanho];
        this.ocupada = new boolean[tamanho];
        this.listas = new No[tamanho];
    }

    public void inserir(int numero) {
        int posicao = numero % tamanho;

        if (!ocupada[posicao]) {
            matriz[posicao] = numero;
            ocupada[posicao] = true;
        } else {
            if (listas[posicao] == null) {
                listas[posicao] = new No(matriz[posicao]);
            }

            ultimo1 = ultimo2;
            ultimo2 = ultimo3;
            ultimo3 = numero;

            No novo = new No(numero);
            novo.proximo = listas[posicao];
            listas[posicao] = novo;
        }
    }

    public int contarListas() {
        int quantidade = 0;
        for (int i = 0; i < tamanho; i++) {
            if (listas[i] != null) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public int contarPosicoesVazias() {
        int vazias = 0;
        for (int i = 0; i < tamanho; i++) {
            if (!ocupada[i]) {
                vazias++;
            }
        }
        return vazias;
    }

    public int tamanhoMaiorLista() {
        int maior = 0;
        for (int i = 0; i < tamanho; i++) {
            int contador = contarNos(i);
            if (contador > maior) {
                maior = contador;
            }
        }
        return maior;
    }

    public int posicaoMaiorLista() {
        int maior = 0;
        int posicao = -1;
        for (int i = 0; i < tamanho; i++) {
            int contador = contarNos(i);
            if (contador > maior) {
                maior = contador;
                posicao = i;
            }
        }
        return posicao;
    }

    private int contarNos(int posicao) {
        int contador = 0;
        No atual = listas[posicao];
        while (atual != null) {
            contador++;
            atual = atual.proximo;
        }
        return contador;
    }

    public void imprimirUltimosValores() {
        System.out.println("Tres ultimos valores inseridos nas listas:");

        if (ultimo1 == -1) {
            System.out.println("Nao houve valores suficientes.");
        } else if (ultimo2 == -1) {
            System.out.println(ultimo3);
        } else if (ultimo1 == -1) {
            System.out.println(ultimo2);
            System.out.println(ultimo3);
        } else {
            System.out.println(ultimo1);
            System.out.println(ultimo2);
            System.out.println(ultimo3);
        }
    }
}