package com.ipartek.modelo.dto;

public class Rol {
	 private int id;
	    private String rol;

	    public Rol(int id, String rol) {
	        super();
	        this.id = id;
	        this.rol = rol;
	    }

	    public Rol() {
	        super();
	        this.id = 0;
	        this.rol = "";
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getRol() {
	        return rol;
	    }

	    public void setRol(String rol) {
	        this.rol = rol;
	    }

	    @Override
	    public String toString() {
	        return "Rol [id=" + id + ", rol=" + rol + "]";
	    }
}
