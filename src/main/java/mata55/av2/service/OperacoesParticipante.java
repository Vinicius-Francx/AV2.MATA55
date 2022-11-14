package main.java.mata55.av2.service;

import main.java.mata55.av2.enums.TipoEspecialista;
import main.java.mata55.av2.model.Participante;

import java.util.Scanner;

import static main.java.mata55.av2.enums.StatusCadastro.PENDENTE;
import static main.java.mata55.av2.service.Inscricao.selectInscricao;
import static main.java.mata55.av2.service.Login.*;
import static main.java.mata55.av2.service.OperacoesEspecialista.operacoesAutor;
import static main.java.mata55.av2.service.OperacoesEspecialista.operacoesRevisor;

public class OperacoesParticipante {

    public static void operacoesPart(String cpf) {

        String cpfUser = cpf;

        System.out.println("");
        System.out.println("------- Selecione a operação que deseja realizar -------");
        System.out.println("|            Opção 1 - Fazer inscrição                 |");
        System.out.println("|            Opção 2 - Ver artigos aceitos             |");
        System.out.println("|            Opção 3 - Ver artigos negados             |");
        System.out.println("|            Opção 4 - Ver dados de um artigo          |");
        System.out.println("|            Opção 5 - Sair                            |");
        System.out.println("|            Opção 6 - Encerrar o programa             |");
        System.out.println("");

        int operacao = input.nextInt();

        switch(operacao) {

            case 1:
                selectInscricao(cpfUser);
                break;
            case 2:
                System.out.println("Artigos aceitos");
                operacoesPart(cpfUser);
                break;
            case 3:
                System.out.println("Artigos negados");
                operacoesPart(cpfUser);
                break;
            case 4:
                System.out.println("Dados Artigo");
                operacoesPart(cpfUser);
                break;
            case 5:
                System.out.println("");
                System.out.println("Você saiu da sua conta!");
                opLogin(true, "participante");
                break;
            case 6:
                System.out.println("");
                System.out.println("Obrigado(a) por utilizar nosso sistema!");
                System.exit(0);
            default:
                System.out.println("");
                System.out.println("Opção inválida, tente novamente!");
                operacoesPart(cpfUser);
                break;
        }
    }

    public static void fazerInscricao(String cpfUs) {

        String cpfUser = cpfUs;

        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("---------------------------------------------------------");
        System.out.println("* Para realizar a inscrição preencha seus dados abaixo! *");
        System.out.println("");
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite seu Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite sua Data de Nascimento (DD-MM-AAAA): ");
        String dataNasc =  scanner.nextLine();
        System.out.print("Qual o seu nível acadêmico? ");
        String titulacaoAcad = scanner.nextLine();
        System.out.print("Qual a sua instituição? ");
        String instituicaoAcad = scanner.nextLine();
        System.out.print("Qual a sua senha? ");
        String senha = scanner.nextLine();

        try{
            tipoParticipante(cpf, nome, dataNasc, titulacaoAcad, instituicaoAcad, senha, cpfUser);
        } catch (Exception ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            fazerInscricao(cpfUser);
        }
    }

    public static void tipoParticipante(String cpf, String nome, String dataNasc, String titulacaoAcad, String instituicaoAcad, String senha, String cpfUs) throws Exception {

        String cpfUser = cpfUs;

        participantes.forEach(esp -> {
            if (esp.getCpf().equals(cpf)) {
                criaInscritoPart(new Participante(cpf, nome, dataNasc, titulacaoAcad, instituicaoAcad, senha, PENDENTE), cpfUser);
            }
        });

        throw new Exception("Participante não encontrado, tente novamente!");
    }

    public static void criaInscritoPart(Participante participante, String cpfUs) {
        String cpfUser = cpfUs;
        String cpf = participante.getCpf();
        String nome = participante.getNome();
        String dataNasc = participante.getDataNascimento();
        String titulacaoAcad = participante.getTitulacaoAcademica();
        String instituicaoAcad = participante.getInstituicao();
        String senha = participante.getSenha();

        inscritos.forEach(ins -> {
            if (ins.getCpf().equals(cpf) && ins.getNome().equals(nome) && ins.getDataNascimento().equals(dataNasc) && ins.getTitulacaoAcademica().equals(titulacaoAcad) && ins.getInstituicao().equals(instituicaoAcad) && ins.getSenha().equals(senha)) {
                System.out.println("");
                System.out.println("O usuário já está cadastrado para assistir às palestras, aguarde autorização!");
                participantes.forEach(espec -> {
                    if(espec.getCpf().equals(cpfUser)) {
                        operacoesPart(cpfUser);
                    }
                });
                especialistas.forEach(espec -> {
                    if (espec.getCpf().equals(cpfUser) && espec.getTipoEspecialista().equals(TipoEspecialista.AUTOR_ARTIGO)) {
                        operacoesAutor(cpfUser);
                    } else if (espec.getCpf().equals(cpfUser) && espec.getTipoEspecialista().equals(TipoEspecialista.REVISOR_ARTIGO)) {
                        operacoesRevisor(cpfUser);
                    }
                });
            }
        });

        participantes.forEach(espec -> {
            if (espec.getCpf().equals(cpf) && espec.getNome().equals(nome) && espec.getDataNascimento().equals(dataNasc) && espec.getTitulacaoAcademica().equals(titulacaoAcad) && espec.getInstituicao().equals(instituicaoAcad) && espec.getSenha().equals(senha) ) {
                inscritos.add(participante);
                System.out.println("");
                System.out.println("Inscrição realizada com sucesso!");
                participantes.forEach(espec1 -> {
                    if (espec1.getCpf().equals(cpfUser)) {
                        operacoesPart(cpfUser);
                        }
                });
                especialistas.forEach(espec2 -> {
                    if (espec2.getCpf().equals(cpfUser) && espec2.getTipoEspecialista().equals(TipoEspecialista.AUTOR_ARTIGO)) {
                        operacoesAutor(cpfUser);
                    } else if (espec2.getCpf().equals(cpfUser) && espec2.getTipoEspecialista().equals(TipoEspecialista.REVISOR_ARTIGO)) {
                        operacoesRevisor(cpfUser);
                    }
                });
            }
        });
    }
}