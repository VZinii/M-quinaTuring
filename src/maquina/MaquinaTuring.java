package maquina;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MaquinaTuring {
    
    private Fita fita;

    private Estado estadoAtual;

    // Cada estado pode ser recuperado a partir de seu número.
    private HashMap<Integer, Estado> estados;

    private Scanner entrada;

    public MaquinaTuring(String nomeArquivoConfiguracao){
        entrada = new Scanner(System.in);
        estados = new HashMap<>();
        fita = new Fita();
        criarMaquina(nomeArquivoConfiguracao);
    }

    private void aguardarEnter(){
        System.out.println("Pressione ENTER para continuar!");
        entrada.nextLine();
    }

    private void imprimirTrechoFita(){
        System.out.println(fita.getTrechoFita());
    }

    /**
     * OBS: para funcionar, é necessário que o arquivo texto esteja configurado conforme
     * exemplo demonstrado no arquivo texto contido na pasta do projeto.
     * Leia o arquivo README para mais informações.
     * @param nomeArquivoConfiguracao nome do arquivo que contém a configuração da máquina
     */
    private void criarMaquina(String nomeArquivoConfiguracao){

        try {
            BufferedReader arquivo = new BufferedReader(new FileReader(nomeArquivoConfiguracao));

            String[] dados;
            String linha;

            /* As três primeiras linhas contém as seguintes informações:
             * => Quantidade de estados da máquina
             * => Estado Inicial
             * => Estado Final
             */

             /*
              * QUANTIDADE DE ESTADOS E CRIAÇÃO DOS ESTADOS:
              */
            linha = arquivo.readLine();
            dados = linha.split(",");
            int quantidadeEstados = Integer.parseInt(dados[1]);

            for (int i=0; i < quantidadeEstados; i++){
                Estado umEstado = new Estado();
                estados.put(umEstado.getNumero(), umEstado);
            }
            
            /*
             * ESTADO INICIAL E DEFINIÇÃO DO ESTADO ATUAL COMO O INICIAL.
             */
            linha = arquivo.readLine();
            dados = linha.split(",");
            int estadoInicial = Integer.parseInt(dados[1]);

            estadoAtual = estados.get(estadoInicial);

            /*
             * ESTADOS FINAIS, DEFININDO OS ESTADOS FINAIS COMO TAL A PARTIR DE UM BOOLEANO.
             */
            linha = arquivo.readLine();
            dados = linha.split(",");
            int quantidadeEstadosFinais = dados.length-1;
            int numeroEstadoFinal;

            for (int i=0; i < quantidadeEstadosFinais; i++){
                numeroEstadoFinal = Integer.parseInt(dados[i+1]);
                estados.get(numeroEstadoFinal).setFinaL(true);
            }

            // Pulando a linha "Transições:"
            arquivo.readLine();

            // Pegando a primeira transição:
            linha = arquivo.readLine();

            // Agora recebemos as transições da máquina:
            while ( linha != null ){

                dados = linha.split(",");

                int numeroEstadoPartida = Integer.parseInt(dados[0]);
                Estado partida = estados.get(numeroEstadoPartida);

                int numeroEstadoDestino = Integer.parseInt(dados[1]);
                Estado destino = estados.get(numeroEstadoDestino);

                char simboloEntrada = dados[2].charAt(0);

                char simboloSaida = dados[3].charAt(0);

                char simboloMovimento = dados[4].charAt(0);

                Movimento movimento;

                if ( simboloMovimento == 'R' ){
                    movimento = Movimento.DIREITA;
                }
                else if ( simboloMovimento == 'L' ){
                    movimento = Movimento.ESQUERDA;
                }
                else {
                    movimento = Movimento.PARADO;
                }

                Transicao umaTransicao = new Transicao(partida, destino, simboloEntrada, simboloSaida, movimento);

                partida.adicionarTransicao(umaTransicao);

                // Pegando a próxima transição:
                linha = arquivo.readLine();
            }
            
            arquivo.close();

        } catch (IOException e) {
            System.out.println("Houve um erro ao tentar carregar o arquivo de configuração: " + nomeArquivoConfiguracao);
            System.out.println("Mensagem de erro: " + e.getMessage());
        }

    }

    public boolean testar(String palavraEntrada){

        fita.input(palavraEntrada);

        System.out.println("Início da operação:");
        imprimirTrechoFita();

        while ( !estadoAtual.ehFinal() ){

            Transicao umaTransicao = estadoAtual.buscarTransicaoCompativel(fita.lerSimbolo());

            if ( umaTransicao != null ){
                // Realiza a modificação na fita:
                fita.realizarTransicao(umaTransicao);
                // Muda de estado:
                estadoAtual = umaTransicao.getDestino();
                // Aguarda o usuário:
                aguardarEnter();
                imprimirTrechoFita();
            }
            else {
                return false;
            }
        }

        return true;
    }
}
