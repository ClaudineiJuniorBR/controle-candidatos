package candidatura;

import javax.lang.model.util.ElementScanner6;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        analisarCandidaro(1900);
        analisarCandidaro(2100);
        analisarCandidaro(2000);

        System.out.println("Hello, World!");
    }

    static void analisarCandidaro(double salarioPretendido) {
        double salarioBase = 2000.00;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO. ");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA.");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS.");
        }
    }
}
