import maquina.MaquinaTuring;

public class principal {
    public static void main(String[] args) throws Exception {

        if ( args.length >= 2 ){

            String nomeArquivoConfiguracao = args[0];

            String palavraEntrada = args[1];

            System.out.println("Máquina de Turing Determinística\n");

            MaquinaTuring mt = new MaquinaTuring(nomeArquivoConfiguracao);

            boolean palavraValida = mt.testar(palavraEntrada);

            if ( palavraValida ){
                System.out.println("Aceita!");
            }
            else {
                System.out.println("Rejeita!");
            }

        }
        else {

            System.out.println("Por favor, insira o arquivo texto contendo a configuração da máguina");
            System.out.println("seguida pela palavra de entrada.");

        }
        
    
    }
}
