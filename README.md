## Máquina de Turing

Autor: Vítor Pires Zini
Data: 21/07/2024

Programa que recebe uma máquina de turing determinística e realiza a computação sobre uma palavra de entrada.
É possível visualizar cada etapa da computação a partir de uma impressão sequencial no terminal.

## Estrutura de arquivos

- `src`: Pasta raiz do projeto
- `lib`: Pasta com bibliotecas, caso necessário
- `maquina`: Pasta com as classes que descrevem a máquina de turing

Os arquivos compilados ficarão na pasta `bin`

## Como confirar o arquivo texto?

Tome o arquivo **BwwB.txt** como exemplo para adicionar mais máquinas de turing e testá-las.

A configuração segue o seguinte padrão  (**NÃO COLOQUE ESPAÇO ENTRE AS VÍRGULAS**):

=> 1ª linha: quantidade de estados,20 (20 estados nesse exemplo)

=> 2ª linha: inicial,0 (O estado inicial é o estado 0 nesse exemplo)

=> 3ª linha: finais,5,10,15,20... (Basta colocar todos os estados finais separados por vírgula)

=> 4ª linha: transições: (Linha de separação)

=> 5ª linha em diante: 0(estado de partida),1(estado de destino),B(símbolo a ser lido),B(símbolo a ser escrito),R(Right, Left or Stay)

## Para executar:

Basta adicionar novos arquivos textos com a configuração correta, e executando o código da seguinte forma:

**Dentro do diretório src:**

**Compilando todos os arquivos com a extensão .java:** 
> javac *.java


**Executando:**
> java principal.java `nome_arquivo.txt` `palavra_entrada`
