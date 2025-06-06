package com.ipartek.modelo.dto;

public class V_Peliculas extends Pelicula{
	private String username;

	public V_Peliculas(int id, String pelicula, int duracion, String descripcion_peli, String estilo_pelicula,
			int fk_usuarios, String username) {
		super(id, pelicula, duracion, descripcion_peli, estilo_pelicula, fk_usuarios);
		this.username = username;
	}
	
	public V_Peliculas() {
		super();
		this.username = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "V_Peliculas [username=" + username + ", getId()=" + getId() + ", getPelicula()=" + getPelicula()
				+ ", getDuracion()=" + getDuracion() + ", getDescripcion_peli()=" + getDescripcion_peli()
				+ ", getEstilo_pelicula()=" + getEstilo_pelicula() + ", getFk_usuarios()=" + getFk_usuarios() + "]";
	}
	
	
}
