public class App {
    public static void main(String[] args) throws Exception {

        if ( args.length >= 2 ){

            String texto1 = args[0];

            String texto2 = args[1];

            System.out.println(texto1 + "  --  " + texto2);

            MaquinaTuring mt = new MaquinaTuring();

            boolean palavraValida = mt.testar(texto2);

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
