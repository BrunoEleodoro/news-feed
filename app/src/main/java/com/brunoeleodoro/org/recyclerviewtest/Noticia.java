package com.brunoeleodoro.org.recyclerviewtest;

/**
 * Created by bruno on 23/12/17.
 */

public class Noticia {
    private String nome;
    private String autor;
    private String titulo;
    private String descricao;
    private String url;
    private String img;
    private String data;

    public Noticia(String nome, String autor, String titulo, String descricao, String url, String img, String data) {
        this.nome = nome;
        this.autor = autor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.img = img;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
