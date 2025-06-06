package com.ipartek.modelo.dto;

public class Usuario {
	private int id;
    private String user;
    private String pass;
    private int fk_rol;
    
    
	public Usuario(int id, String user, String pass, int fk_rol) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.fk_rol = fk_rol;
	}
	
	public Usuario() {
		super();
		this.id = 0;
		this.user = "";
		this.pass = "";
		this.fk_rol = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getFk_rol() {
		return fk_rol;
	}

	public void setFk_rol(int fk_rol) {
		this.fk_rol = fk_rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", user=" + user + ", pass=" + pass + ", fk_rol=" + fk_rol + "]";
	}
    
	
    
}
