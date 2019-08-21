package com.UO.zoqueApp;

public class Course {
    private String titulo;
    private String Categoria;
    private String Descripcion;
    private int foto;


    public Course() {
    }

    public Course(String titulo, String categoria, String descripcion, int foto) {
        this.titulo = titulo;
        Categoria = categoria;
        Descripcion = descripcion;
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}


