package com.ipartek.modelo.dto;

/**
 * <b>Clase cancion</b>
 * <p> esta clase define un objeto cancion. </p>
 * <p> los datos se obtienen de la tabla canciones BD. </p>
 * 
 * @author Alex
 * 
 * @version 1.0.0
 * @since 1.0
 **/
public class Cancion {
		/**
		 * Atributo id. en la BD es autonumerico y PK. no admite valores nulos
		 * 
		 */
	 	private int id;
	 	/**
		 * Atributo de titulo, en la BD es un varchar(45) not null.
		 * 
		 */
	    private String titulo;
	    /**
		 * Atributo de enlace, en la BD es un varchar(255) not null.
		 * 
		 */
	    private String enlace;
	    /**
		 * Atributo de estilo de cancion, en la BD es un varchar(45) not null.
		 * 
		 */
	    private String estilo_cancion;
	    /**
		 * Atributo de descripcion de cancion, en la BD es un varchar(255) not null.
		 * 
		 */
	    private String descripcion_cancion;
	    private int fk_usuario;
	    
	    public Cancion(int id, String titulo, String enlace, String estilo_cancion, String descripcion_cancion, int fk_usuario) {
	        super();
	        this.id = id;
	        this.titulo = titulo;
	        this.enlace = enlace;
	        this.estilo_cancion = estilo_cancion;
	        this.descripcion_cancion = descripcion_cancion;
	        this.fk_usuario = fk_usuario;
	    }

	    public Cancion() {
	        super();
	        this.id = 0;
	        this.titulo = "";
	        this.enlace = "";
	        this.estilo_cancion = "";
	        this.descripcion_cancion = "";
	        this.fk_usuario = 0;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public String getEnlace() {
	        return enlace;
	    }

	    public void setEnlace(String enlace) {
	        this.enlace = enlace;
	    }

	    public String getEstilo_cancion() {
	        return estilo_cancion;
	    }

	    public void setEstilo_cancion(String estilo_cancion) {
	        this.estilo_cancion = estilo_cancion;
	    }

	    public String getDescripcion_cancion() {
	        return descripcion_cancion;
	    }

	    public void setDescripcion_cancion(String descripcion_cancion) {
	        this.descripcion_cancion = descripcion_cancion;
	    }

	    public int getFk_usuario() {
	        return fk_usuario;
	    }

	    public void setFk_usuario(int fk_usuario) {
	        this.fk_usuario = fk_usuario;
	    }

	    @Override
	    public String toString() {
	        return "Cancion [id=" + id + ", titulo=" + titulo + ", enlace=" + enlace + ", estilo_cancion=" + estilo_cancion
	                + ", descripcion_cancion=" + descripcion_cancion + ", fk_usuario=" + fk_usuario + "]";
	    }

	
	
}
