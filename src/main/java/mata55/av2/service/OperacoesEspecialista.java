package main.java.mata55.av2.service;

import main.java.mata55.av2.enums.TipoEspecialista;
import main.java.mata55.av2.model.Especialista;

import java.util.Scanner;

import static main.java.mata55.av2.enums.StatusCadastro.PENDENTE;
import static main.java.mata55.av2.enums.TipoEspecialista.AUTOR_ARTIGO;
import static main.java.mata55.av2.enums.TipoEspecialista.REVISOR_ARTIGO;
import static main.java.mata55.av2.service.Inscricao.selectInscricao;
import static main.java.mata55.av2.service.Login.*;
import static main.java.mata55.av2.service.OperacoesParticipante.operacoesPart;

public class OperacoesEspecialista {

    private static Scanner scanner = new Scanner(System.in);

    public static void operacoesAutor(String cpf) {

        String cpfUser = cpf;

        System.out.println("");
        System.out.println("------- Selecione a operação que deseja realizar -------");
        System.out.println("|          Opção 1 - Fazer inscrição                   |");
        System.out.println("|          Opção 2 - Enviar Artigo                     |");
        System.out.println("|          Opção 3 - Avaliações de Artigo(s) (meus)    |");
        System.out.println("|          Opção 4 - Ver artigos aceitos               |");
        System.out.println("|          Opção 5 - Ver artigos negados               |");
        System.out.println("|          Opção 6 - Ver dados de um artigo            |");
        System.out.println("|          Opção 7 - Sair                              |");
        System.out.println("|          Opção 8 - Encerrar programa                 |");
        System.out.println("");

        int operacaoPc = input.nextInt();

        switch (operacaoPc) {

            case 1:
                selectInscricao(cpfUser);
                break;
            case 2:
//                enviarArtigo();
                break;
            case 3:
                System.out.println("Ver artigos aceitos");
                operacoesAutor(cpfUser);
                break;
            case 4:
                System.out.println("Ver artigos negados");
                operacoesAutor(cpfUser);
                break;
            case 5:
                System.out.println("Dados Artigo");
                operacoesAutor(cpfUser);
                break;
            case 6:
                System.out.println("Participantes");
                operacoesAutor(cpfUser);
                break;
            case 7:
                System.out.println("");
                System.out.println("Você saiu da sua conta!");
                opLogin(true, "especialista");
                break;
            case 8:
                System.out.println("");
                System.out.println("Obrigado(a) por utilizar nosso sistema!");
                System.exit(0);
            default:
                System.out.println("");
                System.out.println("Opção inválida, tente novamente!");
                operacoesAutor(cpfUser);
                break;
        }
    }

    public static void operacoesRevisor(String cpf) {

        String cpfUser = cpf;

        System.out.println("");
        System.out.println("------- Selecione a operação que deseja realizar -------");
        System.out.println("|          Opção 1 - Fazer inscrição                   |");
        System.out.println("|          Opção 2 - Avaliar Artigo                    |");
        System.out.println("|          Opção 3 - Ver Avaliações de Artigo(s)(meus) |");
        System.out.println("|          Opção 4 - Ver artigos aceitos               |");
        System.out.println("|          Opção 5 - Ver artigos negados               |");
        System.out.println("|          Opção 6 - Ver dados de um artigo            |");
        System.out.println("|          Opção 7 - Sair                              |");
        System.out.println("|          Opção 8 - Encerrar programa                 |");
        System.out.println("");

        int operacaoPc = input.nextInt();

        switch (operacaoPc) {

            case 1:
                selectInscricao(cpfUser);
                break;
            case 2:
                System.out.println("Ver Avaliações de Artigo(s)");
                operacoesRevisor(cpfUser);
                break;
            case 3:
                System.out.println("Ver artigos aceitos");
                operacoesRevisor(cpfUser);
                break;
            case 4:
                System.out.println("Ver artigos negados");
                operacoesRevisor(cpfUser);
                break;
            case 5:
                System.out.println("Dados Artigo");
                operacoesRevisor(cpfUser);
                break;
            case 6:
                System.out.println("Participantes");
                operacoesRevisor(cpfUser);
                break;
            case 7:
                System.out.println("");
                System.out.println("Você saiu da sua conta!");
                opLogin(true, "especialista");
                break;
            case 8:
                System.out.println("");
                System.out.println("Obrigado(a) por utilizar nosso sistema!");
                System.exit(0);
            default:
                System.out.println("");
                System.out.println("Opção inválida, tente novamente!");
                operacoesRevisor(cpfUser);
                break;
        }
    }

    public static void fazerInscricaoEsp(String cpfUs) {

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
        System.out.print("Qual a sua área de especialidade? ");
        String areaEspecialidade = scanner.nextLine();

        try{
            tipoEspecialista(cpf, nome, dataNasc, titulacaoAcad, instituicaoAcad, senha, areaEspecialidade, cpfUser);
        } catch (Exception ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            fazerInscricaoEsp(cpfUser);
        }
    }

    public static void tipoEspecialista(String cpf, String nome, String dataNasc, String titulacaoAcad, String instituicaoAcad, String senha, String areaEspecialidade, String cpfUs) throws Exception {

        String cpfUser = cpfUs;

        especialistas.forEach(esp -> {
            if (esp.getCpf().equals(cpf)) {
                criaInscrito(new Especialista(cpf, nome, dataNasc, titulacaoAcad, instituicaoAcad, senha, PENDENTE, areaEspecialidade,
                        (esp.getTipoEspecialista().equals(AUTOR_ARTIGO) ? AUTOR_ARTIGO : REVISOR_ARTIGO)), cpfUser);
            }
        });

        throw new Exception("Especialista não encontrado, tente novamente!");
    }

    public static void criaInscrito(Especialista especialista, String cpfUs) {
        String cpfUser = cpfUs;
        String cpf = especialista.getCpf();
        String nome = especialista.getNome();
        String dataNasc = especialista.getDataNascimento();
        String titulacaoAcad = especialista.getTitulacaoAcademica();
        String instituicaoAcad = especialista.getInstituicao();
        String senha = especialista.getSenha();
        String areaEspecialidade = especialista.getAreaEspecialidade();

        inscritosEsp.forEach(ins -> {
            if (ins.getCpf().equals(cpf) && ins.getNome().equals(nome) && ins.getDataNascimento().equals(dataNasc) && ins.getTitulacaoAcademica().equals(titulacaoAcad) && ins.getInstituicao().equals(instituicaoAcad) && ins.getSenha().equals(senha) && ins.getAreaEspecialidade().equals(areaEspecialidade)) {
                System.out.println("");
                System.out.println("O usuário já está cadastrado para assistir às palestras, aguarde autorização!");
//                operacoesAutor(cpfUser);
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

        especialistas.forEach(espec -> {
            if (espec.getCpf().equals(cpf) && espec.getNome().equals(nome) && espec.getDataNascimento().equals(dataNasc) && espec.getTitulacaoAcademica().equals(titulacaoAcad) && espec.getInstituicao().equals(instituicaoAcad) && espec.getSenha().equals(senha) && espec.getAreaEspecialidade().equals(areaEspecialidade)) {
                inscritosEsp.add(especialista);
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
