package main.java.mata55.av2.model;

import main.java.mata55.av2.enums.StatusCadastro;
import main.java.mata55.av2.enums.TipoEspecialista;

public class Especialista extends Participante {

    private String areaEspecialidade;
    private TipoEspecialista tipoEspecialista;

    public Especialista(String cpf, String nome, String dataNascimento, String titulacaoAcademica, String instituicao, String senha, StatusCadastro status, String areaEspecialidade, TipoEspecialista tipoEspecialista) {
        super(cpf, nome, dataNascimento, titulacaoAcademica, instituicao, senha, status);
        this.areaEspecialidade = areaEspecialidade;
        this.tipoEspecialista = tipoEspecialista;
    }

    public Especialista() {
    }

    public String getAreaEspecialidade() {
        return areaEspecialidade;
    }

    public void setAreaEspecialidade(String areaEspecialidade) {
        this.areaEspecialidade = areaEspecialidade;
    }

    public TipoEspecialista getTipoEspecialista() {
        return tipoEspecialista;
    }

    public void setTipoEspecialista(TipoEspecialista tipoEspecialista) {
        this.tipoEspecialista = tipoEspecialista;
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
                "\nÁrea de especialidade: " + areaEspecialidade +
                "\n-----------------------------------------------";
    }

}
