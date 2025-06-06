package com.ipartek.modelo.dto;

public class Serie {
	private int id;
    private String serie;
    private int num_temporadas;
    private String descripcion_serie;
    private int fk_usuarios;

    public Serie(int id, String serie, int num_temporadas, String descripcion_serie, int fk_usuarios) {
        super();
        this.id = id;
        this.serie = serie;
        this.num_temporadas = num_temporadas;
        this.descripcion_serie = descripcion_serie;
        this.fk_usuarios = fk_usuarios;
    }

    public Serie() {
        super();
        this.id = 0;
        this.serie = "";
        this.num_temporadas = 0;
        this.descripcion_serie = "";
        this.fk_usuarios = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNum_temporadas() {
        return num_temporadas;
    }

    public void setNum_temporadas(int num_temporadas) {
        this.num_temporadas = num_temporadas;
    }

    public String getDescripcion_serie() {
        return descripcion_serie;
    }

    public void setDescripcion_serie(String descripcion_serie) {
        this.descripcion_serie = descripcion_serie;
    }

    public int getFk_usuarios() {
        return fk_usuarios;
    }

    public void setFk_usuarios(int fk_usuarios) {
        this.fk_usuarios = fk_usuarios;
    }

    @Override
    public String toString() {
        return "Serie [id=" + id + ", serie=" + serie + ", num_temporadas=" + num_temporadas 
               + ", descripcion_serie=" + descripcion_serie + ", fk_usuarios=" + fk_usuarios + "]";
    }
}
