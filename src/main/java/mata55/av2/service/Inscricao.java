package main.java.mata55.av2.service;

import java.util.Scanner;

import static main.java.mata55.av2.service.OperacoesEspecialista.fazerInscricaoEsp;
import static main.java.mata55.av2.service.OperacoesParticipante.fazerInscricao;

public class Inscricao {

    public static void selectInscricao(String cpfUs) {

        String cpfUser = cpfUs;

        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("---------------------------------------------------------");
        System.out.println("* Selecione o tipo de inscrição que você quer realizar: *");
        System.out.println("");
        System.out.println("Digite" +
                "\n1 para: Inscrever um participante;" +
                "\n2 para: Inscrever um especialista;");
        int op = scanner.nextInt();
        switch (op) {
            case 1:
                fazerInscricao(cpfUser);
                break;
            case 2:
                fazerInscricaoEsp(cpfUser);
                break;
            default:
                System.out.println("");
                System.out.println("Opção inválida, tente novamente!");
                selectInscricao(cpfUser);
                break;
        }

    }
}