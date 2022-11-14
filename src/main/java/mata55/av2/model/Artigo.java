package main.java.mata55.av2.model;

import java.time.LocalDate;
import java.util.List;

public class Artigo {

    private String titulo;
    private String abstractArtigo;
    private String palavrasChaves;
    private Integer paginas;
    private LocalDate dataSubmissao;
    private List<Especialista> autores;
    private int id;

    public Artigo(String titulo, String abstractArtigo, String palavrasChaves, Integer paginas, LocalDate dataSubmissao, List<Especialista> autores) {
        this.titulo = titulo;
        this.abstractArtigo = abstractArtigo;
        this.palavrasChaves = palavrasChaves;
        this.paginas = paginas;
        this.dataSubmissao = dataSubmissao;
        this.autores = autores;
        this.id = id++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAbstractArtigo() {
        return abstractArtigo;
    }

    public void setAbstractArtigo(String abstractArtigo) {
        this.abstractArtigo = abstractArtigo;
    }

    public String getPalavrasChaves() {
        return palavrasChaves;
    }

    public void setPalavrasChaves(String palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public LocalDate getDataSubmissao() {
        return dataSubmissao;
    }

    public void setDataSubmissao(LocalDate dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }

    public List<Especialista> getAutores() {
        return autores;
    }

    public void setAutores(List<Especialista> autores) {
        this.autores = autores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Artigo{" +
                "titulo='" + titulo + '\'' +
                ", abstractArtigo='" + abstractArtigo + '\'' +
                ", palavrasChaves='" + palavrasChaves + '\'' +
                ", paginas=" + paginas +
                ", dataSubmissao=" + dataSubmissao +
                ", autores=" + autores +
                '}';
    }
}
