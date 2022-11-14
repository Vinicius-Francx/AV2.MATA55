package main.java.mata55.av2.service;

import main.java.mata55.av2.enums.StatusCadastro;
import main.java.mata55.av2.model.Especialista;
import main.java.mata55.av2.model.Participante;

import java.util.Comparator;
import java.util.Scanner;

import static main.java.mata55.av2.service.Login.*;

public class OperacoesGc {

    public static void operacoesGeneralChair() {

        System.out.println("");
        System.out.println("------- Selecione a operação que deseja realizar -------");
        System.out.println("|          Opção 1 - Validar/Invalidar Inscrições      |");
        System.out.println("|          Opção 2 - Emitir certificado                |");
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
                try {
                    listarInscricao();
                }catch (Exception ex) {
                    System.out.println("");
                    System.out.println(ex.getMessage());
                    operacoesGeneralChair();
                }
                break;
            case 2:
                try {
                    listarCertificado();;
                }catch (Exception ex) {
                    System.out.println("");
                    System.out.println(ex.getMessage());
                    operacoesGeneralChair();
                }
                break;
            case 3:
                System.out.println("Ver artigos aceitos");
                operacoesGeneralChair();
                break;
            case 4:
                System.out.println("Ver artigos negados");
                operacoesGeneralChair();
                break;
            case 5:
                System.out.println("Dados Artigo");
                operacoesGeneralChair();
                break;
            case 6:
                verParticipantesGc();
                operacoesGeneralChair();
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
                operacoesGeneralChair();
                break;
        }
    }

    public static void listarInscricao() throws Exception {

        if(inscritos.size() > 0 || inscritosEsp.size() > 0) {

            int count = 0;
            int count1 = 0;

            for(Participante inscrito: inscritos) {
                System.out.println("");
                System.out.println("Participante " + count + ":");
                count++;
                System.out.println(inscrito);
            }
            for(Especialista inscrito: inscritosEsp) {
                System.out.println("");
                System.out.println("Especialista " + count1 + ":");
                count1++;
                System.out.println(inscrito);
            }

            chamarValidacao();
        }

        throw new Exception("Não existem inscrições!");
    }

    public static void chamarValidacao() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Digite o CPF referente a inscrição que voce quer avalaliar.");
        System.out.println("");
        String cpf = scanner.next();
        try {
            validarInscricao(cpf);
        }catch (Exception ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            chamarValidacao();
        }
    }

    public static void validarInscricao(String cpf) throws Exception {

        inscritos.forEach(ins -> {
            if (ins.getCpf().equals(cpf)) {
                System.out.println("");
                System.out.println("Você está avaliando a inscrição de " + ins.getNome());
                System.out.println("");
                System.out.println("Digite" +
                        "\n1 para: Validar a inscrição;" +
                        "\n2 para: invalidar a inscrição;");
                System.out.println("");
                int op = input.nextInt();
                switch (op) {
                    case 1:
                        ins.setStatus(StatusCadastro.AUTORIZADO);
                        System.out.println("");
                        System.out.println("Você validou a inscrição de " + ins.getNome());
                        operacoesGeneralChair();
                        break;
                    case 2:
                        ins.setStatus(StatusCadastro.NAO_AUTORIZADO);
                        System.out.println("");
                        System.out.println("Você invalidou a inscrição de " + ins.getNome());
                        operacoesGeneralChair();
                        break;
                    default:
                        System.out.println("");
                        System.out.println("Opção inválida, tente novamente!");
                        try {
                            validarInscricao(cpf);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                }
            }
        });

        inscritosEsp.forEach(insEp -> {
            if (insEp.getCpf().equals(cpf)) {
                System.out.println("");
                System.out.println("Você está avaliando a inscrição de " + insEp.getNome());
                System.out.println("");
                System.out.println("Digite" +
                        "\n1 para: Validar a inscrição;" +
                        "\n2 para: invalidar a inscrição;");
                System.out.println("");
                int op = input.nextInt();
                switch (op) {
                    case 1:
                        insEp.setStatus(StatusCadastro.AUTORIZADO);
                        System.out.println("");
                        System.out.println("Você validou a inscrição de " + insEp.getNome());
                        operacoesGeneralChair();
                        break;
                    case 2:
                        insEp.setStatus(StatusCadastro.NAO_AUTORIZADO);
                        System.out.println("");
                        System.out.println("Você invalidou a inscrição de " + insEp.getNome());
                        operacoesGeneralChair();
                        break;
                    default:
                        System.out.println("");
                        System.out.println("Opção inválida, tente novamente!");
                        try {
                            validarInscricao(cpf);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
            }
        });

        throw new Exception("Inscrição não encontrada, tente novamente!");
    }

    public static void listarCertificado() throws Exception {

        if(inscritos.size() > 0 || inscritosEsp.size() > 0) {

            inscritos.forEach(item -> {

                int count0 = 0;
                boolean verifica = false;

                if(item.getStatus().equals(StatusCadastro.AUTORIZADO) || item.getStatus().equals(StatusCadastro.EMITIR_CERTIFICADO) && !item.getStatus().equals(StatusCadastro.PENDENTE) && !item.getStatus().equals(StatusCadastro.NAO_AUTORIZADO)) {
                    System.out.println("");
                    System.out.println("Participante " + count0 + ":");
                    count0++;
                    verifica = true;
                    System.out.println(item);
                }

                if(verifica == true) {
                    chamarCertificado();
                }
            });

            inscritosEsp.forEach(esp-> {

                int count1 = 0;
                boolean verifica = false;

                if(esp.getStatus().equals(StatusCadastro.AUTORIZADO) || esp.getStatus().equals(StatusCadastro.EMITIR_CERTIFICADO)  && !esp.getStatus().equals(StatusCadastro.PENDENTE) && !esp.getStatus().equals(StatusCadastro.NAO_AUTORIZADO)) {
                    System.out.println("");
                    System.out.println("Especialista " + count1 + ":");
                    count1++;
                    verifica = true;
                    System.out.println(esp);
                }

                if(verifica == true) {
                    chamarCertificado();
                }
            });
        }

        throw new Exception("Não existe inscrições para emitir certificado!");
    }

    public static void chamarCertificado() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Digite o CPF referente a inscrição que voce quer emetir o certificado.");
        System.out.println("");
        String cpf = scanner.next();

        try {
            validarCertificado(cpf);
        }catch (Exception ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            chamarCertificado();
        }

    }

    public static void validarCertificado(String cpf) throws Exception {

        if(!inscritos.isEmpty()) {
            inscritos.forEach(ins -> {
                if(ins.getCpf().equals(cpf) && ins.getStatus().equals(StatusCadastro.AUTORIZADO) && !ins.getStatus().equals(StatusCadastro.PENDENTE) && !ins.getStatus().equals(StatusCadastro.NAO_AUTORIZADO) && !ins.getStatus().equals(StatusCadastro.EMITIR_CERTIFICADO)) {
                    System.out.println("");
                    System.out.println("Você irá emitir um certificado para a inscrição de " + ins.getNome());
                    System.out.println("");
                    System.out.println("Digite" +
                            "\n1 para: Emitir um certificado;" +
                            "\n2 para: Cancelar a operação;");
                    System.out.println("");
                    int op = input.nextInt();
                    switch(op) {
                        case 1:
                            ins.setStatus(StatusCadastro.EMITIR_CERTIFICADO);
                            System.out.println("");
                            System.out.println("Você emitiu um certificado para a inscrição de " + ins.getNome());
                            operacoesGeneralChair();
                            break;
                        case 2:
                            System.out.println("");
                            System.out.println("Você cancelou a operação");
                            operacoesGeneralChair();
                            break;
                        default:
                            System.out.println("");
                            System.out.println("Opção inválida, tente novamente!");
                            try {
                                validarCertificado(cpf);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                    }

                }
            });

            inscritos.forEach(ins -> {
                if(ins.getCpf().equals(cpf) && !ins.getStatus().equals(StatusCadastro.AUTORIZADO) && !ins.getStatus().equals(StatusCadastro.PENDENTE) && !ins.getStatus().equals(StatusCadastro.NAO_AUTORIZADO) && ins.getStatus().equals(StatusCadastro.EMITIR_CERTIFICADO)) {
                    System.out.println("");
                    System.out.println("O usuário " + ins.getNome() + " já possui um certificado emitido, por favor tente novamente!");
                    chamarCertificado();
                }
            });
        }

        if(!inscritosEsp.isEmpty()) {
            inscritosEsp.forEach(insEsp -> {
                if(insEsp.getCpf().equals(cpf) && insEsp.getStatus().equals(StatusCadastro.AUTORIZADO) && !insEsp.getStatus().equals(StatusCadastro.PENDENTE) && !insEsp.getStatus().equals(StatusCadastro.NAO_AUTORIZADO) && !insEsp.getStatus().equals(StatusCadastro.EMITIR_CERTIFICADO)) {
                    System.out.println("");
                    System.out.println("Você irá emitir um certificado para a inscrição de " + insEsp.getNome());
                    System.out.println("");
                    System.out.println("Digite" +
                            "\n1 para: Emitir um certificado;" +
                            "\n2 para: Cancelar a operação;");
                    System.out.println("");
                    int op = input.nextInt();
                    switch(op) {
                        case 1:
                            insEsp.setStatus(StatusCadastro.EMITIR_CERTIFICADO);
                            System.out.println("");
                            System.out.println("Você emitiu um certificado para a inscrição de " + insEsp.getNome());
                            operacoesGeneralChair();
                            break;
                        case 2:
                            System.out.println("");
                            System.out.println("Você cancelou a operação");
                            operacoesGeneralChair();
                            break;
                        default:
                            System.out.println("");
                            System.out.println("Opção inválida, tente novamente!");
                            try {
                                validarCertificado(cpf);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                    }

                }

            });

            inscritosEsp.forEach(insEsp -> {
                if(insEsp.getCpf().equals(cpf) && !insEsp.getStatus().equals(StatusCadastro.AUTORIZADO) && !insEsp.getStatus().equals(StatusCadastro.PENDENTE) && !insEsp.getStatus().equals(StatusCadastro.NAO_AUTORIZADO) && insEsp.getStatus().equals(StatusCadastro.EMITIR_CERTIFICADO)) {
                    System.out.println("");
                    System.out.println("O usuário " + insEsp.getNome() + " já possui um certificado emitido, por favor tente novamente!");
                    chamarCertificado();
                }
            });
        }

        throw new Exception("Inscrição não encontrada, tente novamente!");
    }

    public static void verParticipantesGc() {

            inscritos.sort(Comparator.comparing(Participante::getNome));
            inscritosEsp.sort(Comparator.comparing(Participante::getNome));

            inscritos.forEach(item -> {

                int count0 = 0;

                if(item.getStatus().equals(StatusCadastro.AUTORIZADO) || item.getStatus().equals(StatusCadastro.EMITIR_CERTIFICADO)) {
                    System.out.println("");
                    System.out.println("Participante " + count0 + ":");
                    count0++;
                    System.out.println(item);
                }
            });

            inscritosEsp.forEach(esp-> {

                int count1 = 0;

                if(esp.getStatus().equals(StatusCadastro.AUTORIZADO) || esp.getStatus().equals(StatusCadastro.EMITIR_CERTIFICADO)) {
                    System.out.println("");
                    System.out.println("Especialista " + count1 + ":");
                    count1++;
                    System.out.println(esp);
                }
            });
    }
}
