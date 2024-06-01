package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        System.out.println("######################################################################");
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "MIRELA", "DANIELA" };
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            // elas precisaram sofrer alterações
            // senão vai entrar em um loop infinito
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        } while (continuarTentando && tentativasRealizadas < 3);
        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " Tentativa");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", Número máximo de tentativas "
                    + tentativasRealizadas);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "JORGE" };
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de nº " + (indice + 1) + " é " + candidatos[indice]);
        }
        System.out.println("Forma abreviada de interação for each");
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "JORGE" };
        int candidaotsSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.00;
        while (candidaotsSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("----------------------------------------------------------------");
            System.out.println("O candidato " + candidato + " Solicitou este valor de salário R$ " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("----------------------------------------------------------------");
                System.out.println("O candidato " + candidato + " Foi selecionado para a vaga com um salário de R$ "
                        + salarioPretendido);
                candidaotsSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidaro(double salarioPretendido) {
        double salarioBase = 2000.00;
        try {
            if (salarioBase > salarioPretendido) {
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
