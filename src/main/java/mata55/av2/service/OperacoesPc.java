package main.java.mata55.av2.service;

import main.java.mata55.av2.enums.StatusCadastro;
import main.java.mata55.av2.model.Participante;

import java.util.Comparator;

import static main.java.mata55.av2.service.Login.*;

public class OperacoesPc {

    public static void operacoesProgramChair() throws Exception {

        System.out.println("");
        System.out.println("------- Selecione a operação que deseja realizar -------");
        System.out.println("|          Opção 1 - Ver avaliações de artigos         |");
        System.out.println("|          Opção 2 - Aceitar/Rejeitar artigo           |");
        System.out.println("|          Opção 3 - Ver artigos aceitos               |");
        System.out.println("|          Opção 4 - Ver artigos negados               |");
        System.out.println("|          Opção 5 - Ver dados de um artigo            |");
        System.out.println("|          Opção 6 - Ver participantes                 |");
        System.out.println("|          Opção 7 - Sair                              |");
        System.out.println("|          Opção 8 - Encerrar programa                 |");
        System.out.println("");

        int operacaoPc = input.nextInt();

        switch(operacaoPc) {

            case 1:
                System.out.println("Ver avaliações de artigos");
                break;
            case 2:
                System.out.println("Aceitar/rejeitar artigo");
                operacoesProgramChair();
                break;
            case 3:
                System.out.println("Ver artigos aceitos");
                operacoesProgramChair();
                break;
            case 4:
                System.out.println("Ver artigos negados");
                operacoesProgramChair();
                break;
            case 5:
                System.out.println("Dados Artigo");
                operacoesProgramChair();
                break;
            case 6:
                verParticipantesPc();
                operacoesProgramChair();
                break;
            case 7:
                System.out.println("");
                System.out.println("Você saiu da sua conta!");
                opLogin(true, "organizador");
                break;
            case 8:
                System.out.println("");
                System.out.println("Obrigado(a) por utilizar nosso sistema!");
                System.exit(0);
            default:
                System.out.println("");
                System.out.println("Opção inválida, tente novamente!");
                operacoesProgramChair();
                break;
        }
    }

    public static void verParticipantesPc() {

            inscritos.sort(Comparator.comparing(Participante::getNome));
            inscritosEsp.sort(Comparator.comparing(Participante::getNome));

            inscritos.forEach(item -> {

                if(item.getStatus().equals(StatusCadastro.AUTORIZADO) || item.getStatus().equals(StatusCadastro.EMITIR_CERTIFICADO)) {
                    System.out.println("");
                    System.out.println("Participante: ");
                    System.out.println(item);
                }
            });

            inscritosEsp.forEach(esp-> {

                if(esp.getStatus().equals(StatusCadastro.AUTORIZADO) || esp.getStatus().equals(StatusCadastro.EMITIR_CERTIFICADO)) {
                    System.out.println("");
                    System.out.println("Participante: ");
                    System.out.println(esp);
                }
            });
    }
}
