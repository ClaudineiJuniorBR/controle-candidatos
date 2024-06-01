package candidatura; //com a pasta candidatura criamos um package

import java.util.Random; //importa o pacote random
import java.util.concurrent.ThreadLocalRandom; //pra definir um valor entre dois pontos

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        System.out.println("######################################################################");
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "MIRELA", "DANIELA" };
        for (String candidato : candidatos) { // forma simplicada de mostrar cada candidato
            entrandoEmContato(candidato); // chama o metodo
        }
    }

    static void entrandoEmContato(String candidato) { // criação do metodo
        int tentativasRealizadas = 1;// cria a variavel
        boolean continuarTentando = true; // cria a variavel bool
        boolean atendeu = false; // cria a variavel bool
        do {
            // elas precisaram sofrer alterações
            // senão vai entrar em um loop infinito
            atendeu = atender(); // passsa pra variavel atendeu o valor do metodo atender
            continuarTentando = !atendeu; // quando for 0 ele para, inverte atendeu
            if (continuarTentando) // codnição se for 0, quando vai tentar 3 vezes
                tentativasRealizadas++; // soma um
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO"); // caso atenda
        } while (continuarTentando && tentativasRealizadas < 3);// se continuar e tentativa for true ele continua por
                                                                // tres vezes

        if (atendeu) { // condição para caso atender
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " Tentativa");
        } else { // caso não atendeu
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", Número máximo de tentativas "
                    + tentativasRealizadas);
        }
    }

    static boolean atender() { // criação do metodo
        return new Random().nextInt(3) == 1; // random o valor
    }

    static void imprimirSelecionados() { // para imprimir os candidatos
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "JORGE" }; // lista de candidatos
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for (int indice = 0; indice < candidatos.length; indice++) { // vai de 0 até o numero de candidatos
            System.out.println("O candidato de nº " + (indice + 1) + " é " + candidatos[indice]);
        }
        System.out.println("Forma abreviada de interação for each");
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() { // seleção de candidatos por conta do salario
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "JORGE" };
        int candidaotsSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.00; // defini o salario base
        while (candidaotsSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("----------------------------------------------------------------");
            System.out.println("O candidato " + candidato + " Solicitou este valor de salário R$ " + salarioPretendido);

            if (salarioBase >= salarioPretendido) { // condição para salario
                System.out.println("----------------------------------------------------------------");
                System.out.println("O candidato " + candidato + " Foi selecionado para a vaga com um salário de R$ "
                        + salarioPretendido);
                candidaotsSelecionados++; // quantidade de selecioandos aumenta com esse incrementador
            }
            candidatosAtual++;// quantidade de atuais aumenta com esse incrementador
        }
    }

    static double valorPretendido() { // gera um valor random entre 1800 até 2200
        return ThreadLocalRandom.current().nextDouble(1800, 2200); // retorna o valor
    }

    static void analisarCandidaro(double salarioPretendido) { // criação do metodo
        double salarioBase = 2000.00; // salario base
        try {
            if (salarioBase > salarioPretendido) { // codição para recrutar candidato
                System.out.println("----------------------------------------------------------------");
                System.out.println("LIGAR PARA O CANDIDATO. ");
            } else if (salarioBase == salarioPretendido) {
                System.out.println("----------------------------------------------------------------");
                System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA.");
            } else {
                System.out.println("----------------------------------------------------------------");
                System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS.");
            }
        } catch (Exception e) {
            System.out.println("ERRO DE ANALISE, TENTE NOVAMENTE.");
        }

    }
}
