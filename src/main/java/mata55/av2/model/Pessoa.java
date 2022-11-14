package main.java.mata55.av2.model;

public abstract class Pessoa {

    protected String cpf;
    protected String nome;
    protected String dataNascimento;
    protected String titulacaoAcademica;
    protected String instituicao;
    protected String senha;

    public Pessoa(String cpf, String nome, String dataNascimento, String titulacaoAcademica, String instituicao, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.titulacaoAcademica = titulacaoAcademica;
        this.instituicao = instituicao;
        this.senha = senha;
    }

    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTitulacaoAcademica() {
        return titulacaoAcademica;
    }

    public void setTitulacaoAcademica(String titulacaoAcademica) {
        this.titulacaoAcademica = titulacaoAcademica;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
