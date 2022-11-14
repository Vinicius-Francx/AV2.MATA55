package main.java.mata55.av2.model;

import main.java.mata55.av2.enums.StatusCadastro;

public class Participante extends Pessoa {

    protected StatusCadastro status;

    public Participante(String cpf, String nome, String dataNascimento, String titulacaoAcademica, String instituicao, String senha, StatusCadastro status) {
        super(cpf, nome, dataNascimento, titulacaoAcademica, instituicao, senha);
        this.status = status;
    }

    public Participante() {
    }

    public StatusCadastro getStatus() {
        return status;
    }

    public void setStatus(StatusCadastro status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "\n-----------------------------------------------" +
                "\nCpf: " + cpf +
                "\nNome: " + nome +
                "\nData de Nascimento: " + dataNascimento +
                "\nTitulação Acadêmica: " + titulacaoAcademica +
                "\nInstituição de vínculo: " + instituicao +
                "\nStatus: " + status +
                "\n-----------------------------------------------";
    }

}
