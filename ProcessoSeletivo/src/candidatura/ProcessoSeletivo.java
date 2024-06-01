package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        System.out.println("######################################################################");
        selecaoCandidatos();
        System.out.println("######################################################################");
    }

    static void selecaoCandidatos() {
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "JORGE" };
        int candidaotsSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.00;
        while (candidaotsSelecionados < 5) {
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
