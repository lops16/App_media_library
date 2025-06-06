package com.ipartek.modelo.dto;

public class V_Usuarios extends Usuario{
	private String rol;

	public V_Usuarios(int id, String user, String pass, int fk_rol, String rol) {
		super(id, user, pass, fk_rol);
		this.rol = rol;
	}
	
	public V_Usuarios() {
		super();
		this.rol = "";
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "V_Usuarios [rol=" + rol + ", getId()=" + getId() + ", getUser()=" + getUser() + ", getPass()="
				+ getPass() + ", getFk_rol()=" + getFk_rol() + "]";
	}
	
	
	
}
