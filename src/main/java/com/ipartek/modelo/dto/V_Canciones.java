package com.ipartek.modelo.dto;


public class V_Canciones extends Cancion{
	private String username;

	public V_Canciones(int id, String titulo, String enlace, String estilo_cancion, String descripcion_cancion,
			int fk_usuario, String username) {
		super(id, titulo, enlace, estilo_cancion, descripcion_cancion, fk_usuario);
		this.username = username;
	}
	
	public V_Canciones() {
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
		return "V_Canciones [username=" + username + ", getId()=" + getId() + ", getTitulo()=" + getTitulo()
				+ ", getEnlace()=" + getEnlace() + ", getEstilo_cancion()=" + getEstilo_cancion()
				+ ", getDescripcion_cancion()=" + getDescripcion_cancion() + ", getFk_usuario()=" + getFk_usuario()
				+ "]";
	}
	
	
}
