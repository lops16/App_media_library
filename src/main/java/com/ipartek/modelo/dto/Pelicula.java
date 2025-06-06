package com.ipartek.modelo.dto;

public class Pelicula {
	private int id;
    private String pelicula;
    private int duracion;
    private String descripcion_peli;
    private String estilo_pelicula;
    private int fk_usuarios;

    public Pelicula(int id, String pelicula, int duracion, String descripcion_peli, String estilo_pelicula, int fk_usuarios) {
        super();
        this.id = id;
        this.pelicula = pelicula;
        this.duracion = duracion;
        this.descripcion_peli = descripcion_peli;
        this.estilo_pelicula = estilo_pelicula;
        this.fk_usuarios = fk_usuarios;
    }

    public Pelicula() {
        super();
        this.id = 0;
        this.pelicula = "";
        this.duracion = 0;
        this.descripcion_peli = "";
        this.estilo_pelicula = "";
        this.fk_usuarios = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion_peli() {
        return descripcion_peli;
    }

    public void setDescripcion_peli(String descripcion_peli) {
        this.descripcion_peli = descripcion_peli;
    }

    public String getEstilo_pelicula() {
        return estilo_pelicula;
    }

    public void setEstilo_pelicula(String estilo_pelicula) {
        this.estilo_pelicula = estilo_pelicula;
    }

    public int getFk_usuarios() {
        return fk_usuarios;
    }

    public void setFk_usuarios(int fk_usuarios) {
        this.fk_usuarios = fk_usuarios;
    }

    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", pelicula=" + pelicula + ", duracion=" + duracion + ", descripcion_peli=" + descripcion_peli
                + ", estilo_pelicula=" + estilo_pelicula + ", fk_usuarios=" + fk_usuarios + "]";
    }
}
