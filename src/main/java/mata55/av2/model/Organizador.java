package main.java.mata55.av2.model;

import main.java.mata55.av2.enums.TipoOrganizador;

public class Organizador extends Pessoa {

    private TipoOrganizador tipoOrganizador;

    public Organizador(String cpf, String nome, String dataNascimento, String titulacaoAcademica, String instituicao, String senha, TipoOrganizador tipoOrganizador) {
        super(cpf, nome, dataNascimento, titulacaoAcademica, instituicao, senha);
        this.tipoOrganizador = tipoOrganizador;
    }

    public Organizador() {
    }

    public TipoOrganizador getTipoOrganizador() {
        return tipoOrganizador;
    }

    public void setTipoOrganizador(TipoOrganizador tipoOrganizador) {
        this.tipoOrganizador = tipoOrganizador;
    }
}