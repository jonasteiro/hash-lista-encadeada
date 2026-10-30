# Hash, rehash e colisões

Trabalho em Java que implementa uma tabela hash com tratamento de colisões por encadeamento. A ideia é inserir uma grande quantidade de números aleatórios numa tabela pequena e observar como as colisões se distribuem.

## Como funciona

A tabela tem 100 posições. Cada número inserido vai para a posição dada pelo resto da divisão por 100:

```
posicao = numero % 100
```

- Se a posição estiver livre, o número é guardado diretamente no vetor.
- Se já estiver ocupada, ocorre uma colisão. Nesse caso, o valor que já estava lá e o novo passam a ficar numa lista encadeada associada àquela posição. Os novos elementos entram sempre no início da lista.

Os números são gerados com `java.util.Random`, usando a semente `1090`, o que torna o resultado o mesmo a cada execução.

## Parâmetros

| Item                    | Valor            |
|-------------------------|------------------|
| Tamanho da tabela       | 100 posições     |
| Quantidade de inserções | 1000 números     |
| Intervalo dos números   | de 0 a 100000    |
| Semente do gerador      | 1090             |

## Estrutura do projeto

```
.
├── Main.java         # gera os números e imprime os resultados
└── TabelaHash.java   # tabela hash, nó da lista e estatísticas
```

## Como executar

É necessário ter o JDK instalado. Na pasta do projeto:

```bash
javac *.java
java Main
```

## O que é exibido

Ao final das inserções, o programa mostra:

- quantas posições possuem lista encadeada;
- quantas posições da tabela ficaram vazias;
- o tamanho da maior lista e a posição em que ela está;
- os três últimos valores que entraram em listas, ou seja, os três últimos que sofreram colisão.

## Observações

Com 1000 números para 100 posições, é esperado que quase todas as posições acabem com lista, já que há em média 10 números por posição. O interesse do exercício está justamente em ver como essa distribuição se comporta na prática.
