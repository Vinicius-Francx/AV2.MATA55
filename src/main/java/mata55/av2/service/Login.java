package main.java.mata55.av2.service;

import main.java.mata55.av2.enums.StatusCadastro;
import main.java.mata55.av2.enums.TipoEspecialista;
import main.java.mata55.av2.enums.TipoOrganizador;
import main.java.mata55.av2.model.Especialista;
import main.java.mata55.av2.model.Organizador;
import main.java.mata55.av2.model.Participante;

import java.util.*;

import static java.util.Objects.*;
import static main.java.mata55.av2.service.OperacoesEspecialista.operacoesAutor;
import static main.java.mata55.av2.service.OperacoesEspecialista.operacoesRevisor;
import static main.java.mata55.av2.service.OperacoesGc.operacoesGeneralChair;
import static main.java.mata55.av2.service.OperacoesPc.operacoesProgramChair;
import static main.java.mata55.av2.service.OperacoesParticipante.operacoesPart;

public class Login {

    static Scanner input = new Scanner(System.in);
    public static final List<Participante> participantes = new ArrayList<>();
    private static String participante;
    public static final List<Participante> inscritos = new ArrayList<>();
    public static final List<Especialista> inscritosEsp = new ArrayList<>();
    public static final List<Organizador> organizadores = new ArrayList<>();
    private static String organizador;
    public static final List<Especialista> especialistas = new ArrayList<>();
    private static String especialista;

    public static void criaObjetos(){
        criaParticipantes();
        criaOrganizadores();
        criaEspecialistas();
    }

    public static void criaParticipantes() {
        Participante participante = new Participante("12345678910", "Lucas Castro", "21-12-1998", "Mestrado",
                "UFBA", "Pardal123", StatusCadastro.PENDENTE);

        Participante participante1 = new Participante("26365478892", "Lucia Maria", "26-03-1996", "Doutorado",
                "UNICAMP", "Lights22", StatusCadastro.PENDENTE);

        Participante participante2 = new Participante("78333456867", "Weskley Silva", "03-02-1995", "Bacharelado",
                "UFRJ", "Stay5574", StatusCadastro.PENDENTE);

        Participante participante3 = new Participante("55746256977", "Anderson Silva", "12-10-1986", "Doutorado",
                "UNICAMP", "Sun225", StatusCadastro.PENDENTE);

        Participante participante4 = new Participante("33657424598", "Gilberto Souza", "23-04-1999", "Licenciatura",
                "UFBA", "Moon7897", StatusCadastro.PENDENTE);

        participantes.add(participante);
        participantes.add(participante1);
        participantes.add(participante2);
        participantes.add(participante3);
        participantes.add(participante4);
    }

    public static void criaOrganizadores() {
        Organizador organizador = new Organizador("45612378998", "Alan Souza", "15-06-1998", "Doutorado",
                "instituicao", "Leeds336", TipoOrganizador.GENERAL_CHAIR);

        Organizador organizador1 = new Organizador("88912378774", "Jefferson Alba", "21-02-1989", "Doutorado",
                "UFRJ", "Silence334", TipoOrganizador.PROGRAM_CHAIR);

        organizadores.add(organizador);
        organizadores.add(organizador1);
    }

    public static void criaEspecialistas() {
        Especialista especialista = new Especialista("66529478627", "Alana Castro", "17-06-1982", "Mestrado",
                "UFBA", "Bird889", StatusCadastro.PENDENTE, "Desenvolvedora Web", TipoEspecialista. AUTOR_ARTIGO);

        Especialista especialista1 = new Especialista("22477698723", "Julia Ribeiro", "02-12-1995", "Doutorado",
                "UNICAMP", "Case779", StatusCadastro.PENDENTE, "Desenvolvedora Full Stack", TipoEspecialista.REVISOR_ARTIGO);

        especialistas.add(especialista);
        especialistas.add(especialista1);
    }

    public static void login(String cpfUser, String senha) throws Exception {

        participantes.forEach(part -> {
            if(part.getCpf().equals(cpfUser) && part.getSenha().equals(senha)){
                participante = cpfUser;
                try {
                    operacoesPart(cpfUser);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        if(isNull(participante) || !participante.equals(cpfUser)){
            organizadores.forEach(org -> {
                if(org.getCpf().equals(cpfUser) && org.getSenha().equals(senha) && org.getTipoOrganizador().equals(TipoOrganizador.PROGRAM_CHAIR)){
                    organizador = cpfUser;
                    try {
                        operacoesProgramChair();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

                if(org.getCpf().equals(cpfUser) && org.getSenha().equals(senha) && org.getTipoOrganizador().equals(TipoOrganizador.GENERAL_CHAIR)){
                    organizador = cpfUser;
                    try {
                        operacoesGeneralChair();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        if(isNull(participante) || !participante.equals(cpfUser) && isNull(organizador) || !organizador.equals(cpfUser)){
            especialistas.forEach(esp -> {
                if(esp.getCpf().equals(cpfUser) && esp.getSenha().equals(senha) && esp.getTipoEspecialista().equals(TipoEspecialista.AUTOR_ARTIGO)){
                    especialista = cpfUser;
                    try {
                        operacoesAutor(cpfUser);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

                if(esp.getCpf().equals(cpfUser) && esp.getSenha().equals(senha) && esp.getTipoEspecialista().equals(TipoEspecialista.REVISOR_ARTIGO)){
                    especialista = cpfUser;
                    try {
                        operacoesRevisor(cpfUser);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        if(isNull(participante) || !participante.equals(cpfUser) && isNull(organizador) || !organizador.equals(cpfUser) && isNull(especialista) || !especialista.equals(cpfUser)){
            throw new Exception("Usuário não encontrado, tente novamente!");
        }
    }

    public static void opLogin(Boolean logout, String tipoPessoa) {
        if (Boolean.TRUE.equals(logout)) {
            switch (tipoPessoa) {
                case "participante" -> {
                    participante = "";
                    System.out.println("Quem saiu foi " + tipoPessoa);
                    break;
                }
                case "organizador" -> {
                    organizador = "";
                    System.out.println("Quem saiu foi " + tipoPessoa);
                    break;
                }
                case "especialista" -> {
                    especialista = "";
                    System.out.println("Quem saiu foi " + tipoPessoa);
                    break;
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("---------------------------------------------------------");
        System.out.println("-------------Bem vindo(a) ao sistema CBPOO---------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("------------- Faça o login para continuar! --------------");
        System.out.println("");
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.next();
        System.out.print("Digite sua senha: ");
        String senha = scanner.next();

        try {
            login(cpf, senha);
        } catch (Exception ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            opLogin(false, "");
        }
    }

}