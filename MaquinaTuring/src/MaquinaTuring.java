import java.util.Scanner;

public class MaquinaTuring {
    
    private Fita fita;

    private Estado estadoInicial;

    private Scanner entrada;

    public MaquinaTuring(){
        entrada = new Scanner(System.in);
        fita = new Fita();
        criarMaquina();
    }

    private void aguardarEnter(){
        System.out.println("Pressione ENTER para continuar!");
        entrada.nextLine();
    }

    private void imprimirTrechoFita(){
        System.out.println(fita.getTrechoFita());
    }

    private void criarMaquina(){

        Estado q0 = new Estado();
        Estado q1 = new Estado();
        Estado q2 = new Estado();
        Estado q3 = new Estado();
        Estado q4 = new Estado();
        Estado q5 = new Estado();
        Estado q6 = new Estado();
        Estado q7 = new Estado();
        Estado q8 = new Estado();
        Estado q9 = new Estado();
        Estado q10 = new Estado();

        Transicao t1 = new Transicao(q0, q1, 'B', 'B', Movimento.DIREITA);

        Transicao t2 = new Transicao(q1, q2, 'a', 'X', Movimento.DIREITA);
        Transicao t3 = new Transicao(q1, q2, 'b', 'Y', Movimento.DIREITA);
        Transicao t4 = new Transicao(q1, q5, 'Y', 'b', Movimento.ESQUERDA);
        Transicao t5 = new Transicao(q1, q6, 'X', 'a', Movimento.ESQUERDA);
        Transicao t6 = new Transicao(q1, q10, 'B', 'B', Movimento.ESQUERDA);

        Transicao t7 = new Transicao(q2, q2, 'a', 'a', Movimento.DIREITA);
        Transicao t8 = new Transicao(q2, q2, 'b', 'b', Movimento.DIREITA);
        Transicao t9 = new Transicao(q2, q3, 'X', 'X', Movimento.ESQUERDA);
        Transicao t10 = new Transicao(q2, q3, 'Y', 'Y', Movimento.ESQUERDA);
        Transicao t11 = new Transicao(q2, q3, 'B', 'B', Movimento.ESQUERDA);

        Transicao t12 = new Transicao(q3, q4, 'a', 'X', Movimento.ESQUERDA);
        Transicao t13 = new Transicao(q3, q4, 'b', 'Y', Movimento.ESQUERDA);

        Transicao t14 = new Transicao(q4, q4, 'b', 'b', Movimento.ESQUERDA);
        Transicao t15 = new Transicao(q4, q4, 'a', 'a', Movimento.ESQUERDA);
        Transicao t16 = new Transicao(q4, q1, 'X', 'X', Movimento.DIREITA);
        Transicao t17 = new Transicao(q4, q1, 'Y', 'Y', Movimento.DIREITA);

        Transicao t18 = new Transicao(q5, q5, 'Y', 'Y', Movimento.ESQUERDA);
        Transicao t19 = new Transicao(q5, q5, 'X', 'X', Movimento.ESQUERDA);
        Transicao t20 = new Transicao(q5, q7, 'B', 'B', Movimento.DIREITA);
        Transicao t21 = new Transicao(q5, q7, 'a', 'X', Movimento.DIREITA);
        Transicao t22 = new Transicao(q5, q7, 'b', 'Y', Movimento.DIREITA);

        Transicao t23 = new Transicao(q6, q6, 'Y', 'Y', Movimento.ESQUERDA);
        Transicao t24 = new Transicao(q6, q6, 'X', 'X', Movimento.ESQUERDA);
        Transicao t25 = new Transicao(q6, q8, 'B', 'B', Movimento.DIREITA);
        Transicao t26 = new Transicao(q6, q8, 'b', 'Y', Movimento.DIREITA);
        Transicao t27 = new Transicao(q6, q8, 'a', 'X', Movimento.DIREITA);

        Transicao t28 = new Transicao(q7, q9, 'Y', 'b', Movimento.DIREITA);
        
        Transicao t29 = new Transicao(q8, q9, 'X', 'a', Movimento.DIREITA);
        
        Transicao t30 = new Transicao(q9, q9, 'X', 'X', Movimento.DIREITA);
        Transicao t31 = new Transicao(q9, q9, 'Y', 'Y', Movimento.DIREITA);
        Transicao t32 = new Transicao(q9, q1, 'a', 'X', Movimento.DIREITA);
        Transicao t33 = new Transicao(q9, q1, 'b', 'Y', Movimento.DIREITA);

        q0.adicionarTransicao(t1);

        q1.adicionarTransicao(t2);
        q1.adicionarTransicao(t3);
        q1.adicionarTransicao(t4);
        q1.adicionarTransicao(t5);
        q1.adicionarTransicao(t6);

        q2.adicionarTransicao(t7);
        q2.adicionarTransicao(t8);
        q2.adicionarTransicao(t9);
        q2.adicionarTransicao(t10);
        q2.adicionarTransicao(t11);

        q3.adicionarTransicao(t12);
        q3.adicionarTransicao(t13);

        q4.adicionarTransicao(t14);
        q4.adicionarTransicao(t15);
        q4.adicionarTransicao(t16);
        q4.adicionarTransicao(t17);

        q5.adicionarTransicao(t18);
        q5.adicionarTransicao(t19);
        q5.adicionarTransicao(t20);
        q5.adicionarTransicao(t21);
        q5.adicionarTransicao(t22);

        q6.adicionarTransicao(t23);
        q6.adicionarTransicao(t24);
        q6.adicionarTransicao(t25);
        q6.adicionarTransicao(t26);
        q6.adicionarTransicao(t27);

        q7.adicionarTransicao(t28);

        q8.adicionarTransicao(t29);

        q9.adicionarTransicao(t30);
        q9.adicionarTransicao(t31);
        q9.adicionarTransicao(t32);
        q9.adicionarTransicao(t33);

        estadoInicial = q0;
        q10.setFinaL(true);
    }

    public boolean testar(String palavraEntrada){

        Estado estadoAtual = estadoInicial;

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
