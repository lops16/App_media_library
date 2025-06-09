package com.ipartek.modelo;

public interface I_Constantes {

	// constantes de la BD
	String BD = "jsp_media_app";
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/" + BD;
	String USUARIO = "root";
	String PASS = "1234";

	// constantes de los JSP
	String JSP_INDEX = "index.jsp";
	String JSP_LOGIN = "login.jsp";
	String JSP_SERIES = "series.jsp";
	String JSP_CANCIONES = "musica.jsp";
	String JSP_PELICULAS = "peliculas.jsp";
	String JSP_GESTION = "gestion.jsp";
	String JSP_FRMMOD_SERIE = "frm_modificar_serie.jsp";

	String TABLA_CANCIONES = "canciones";

	String CANCIONES_ID_CANCION = "id";
	String CANCIONES_TITULO = "titulo";
	String CANCIONES_ENLACE = "enlace";
	String CANCIONES_ESTILO_CANCION = "estilo_cancion";
	String CANCIONES_DESCRIPCION_CANCION = "descripcion_cancion";
	String CANCIONES_FK_USUARIO = "fk_usuarios";

	String TABLA_PELICULAS = "peliculas";

	String PELICULAS_ID_PELICULA = "id";
	String PELICULAS_PELICULA = "pelicula";
	String PELICULAS_DURACION = "duracion";
	String PELICULAS_DESCRIPCION_PELICULA = "descripcion_peli";
	String PELICULAS_ESTILO_PELICULA = "estilo_pelicula";
	String PELICULAS_FK_USUARIO = "fk_usuarios";

	String TABLA_SERIES = "series";

	String SERIES_ID_SERIE = "id";
	String SERIES_SERIE = "serie";
	String SERIES_NUM_SERIE = "num_temporadas";
	String SERIES_DESCRIPCION_SERIE = "descripcion_serie";
	String SERIES_FK_USUARIO = "fk_usuarios";

	String TABLA_USUARIOS = "series";

	String USUARIO_ID = "id";
	String USUARIO_USUARIO = "username";
	String USUARIO_PASSWORD = "pass";
	String USUARIO_FK_ROL = "fk_rol";

	String TABLA_ROLES = "roles";

	String ROLES_ID_ROL = "id";
	String ROLES_ROL = "rol";

	// STORED PROCEDURES
	String SP_VALIDAR_USUARIO = "call sp_validar_usuario(?, ?);";
	String SP_OBTENER_TODAS_CANCIONES = "call sp_obtener_canciones_todas();";
	String SP_OBTENER_CANCIONES_USUARIO = "call sp_obtener_canciones_usuarios(?);";
	String SP_OBTENER_TODAS_PELICULAS = "call sp_obtener_peliculas_todas();";
	String SP_OBTENER_PELICULAS_USUARIO= "call sp_obtener_peliculas_usuario(?);";
	String SP_OBTENER_TODAS_SERIES = "call sp_obtener_series_todas();";
	String SP_OBTENER_SERIES_USUARIO = "call sp_obtener_series_usuarios(?);";
	String SP_OBTENER_TODOS_USUARIOS = "call sp_obtener_usuarios_todos();";
	String SP_OBTENER_ID_USUARIO = "call sp_obtener_usuario_id_nombre(?);";
	String SP_USUARIO_BLOQUEAR="call sp_usuarios_bloquear(?);";
	String SP_OBTENER_TODOS_ROLES = "call sp_obtener_todos_roles();";
	
	String SP_MODIFICAR_ROL = "call sp_editar_usuario_rol(?, ?);";
	String SP_MODIFICAR_PASS = "call sp_cambiar_pass_usuario(?, ?);";
	
	String SP_SERIES_INSERTAR = "call sp_insertar_serie(?, ?, ?, ?);";
	String SP_PELICULAS_INSERTAR ="call sp_insertar_pelicula(?, ?, ?, ?, ?);";
	String SP_CANCIONES_INSERTAR = "call sp_insertar_cancion(?, ?, ?, ?, ?);";
	
	String SP_BORRAR_SERIE = "call sp_editar_serie_id(?);";
	String SP_BORRAR_CANCION = "call sp_editar_cancion_id(?);";
	String SP_BORRAR_PELICULA = "call sp_editar_pelicula_id(?);";
	
	String SP_MODIFICAR_SERIE = "call sp_editar_serie(?, ?, ?, ?, ?);";
	String SP_MODIFICAR_CANCION = "call sp_editar_cancion(?, ?, ?, ?, ?);";
	String SP_MODIFICAR_PELICULA = "call sp_editar_pelicula(?, ?, ?, ?, ?);";
	
	String SP_OBTENER_SERIE_POR_ID="call jsp_media_app.sp_serie_obtener_por_id(?)";
	String SP_OBTENER_PELICULAS_POR_ID="";
	String SP_OBTENER_CANCIONES_POR_ID="";
	String SP_OBTENER_USUARIO_POR_ID = "sp_usuario_obtener_por_id(?);";
	
	String ATR_LISTAS_SERIES = "lista_series";
	String ATR_SERIE = "serie_sola";
	String ATR_LISTAS_SERIES_USUARIO = "lista_series_usuario";
	String ATR_LISTAS_PELICULAS = "lista_peliculas";
	String ATR_LISTAS_PELICULAS_USUARIO = "lista_peliculas_usuario";
	String ATR_LISTAS_CANCIONES = "lista_canciones";
	String ATR_LISTAS_CANCIONES_USUARIO = "lista_canciones_usuario";
	String ATR_LISTAS_USUARIOS = "lista_usuarios";
	String ATR_LISTA_ROLES = "lista_roles";

}
