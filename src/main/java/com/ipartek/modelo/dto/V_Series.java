package com.ipartek.modelo.dto;


public class V_Series extends Serie{
	private String username;

	public V_Series(int id, String serie, int num_temporadas, String descripcion_serie, int fk_usuarios,
			String username) {
		super(id, serie, num_temporadas, descripcion_serie, fk_usuarios);
		this.username = username;
	}
	
	public V_Series() {
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
		return "V_Series [username=" + username + ", getId()=" + getId() + ", getSerie()=" + getSerie()
				+ ", getNum_temporadas()=" + getNum_temporadas() + ", getDescripcion_serie()=" + getDescripcion_serie()
				+ ", getFk_usuarios()=" + getFk_usuarios() + "]";
	}
	
	
	
	
}
