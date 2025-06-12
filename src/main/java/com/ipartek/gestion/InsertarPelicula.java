package com.ipartek.gestion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Constantes;
import com.ipartek.modelo.dto.Pelicula;
import com.ipartek.modelo.dto.Usuario;
import com.ipartek.usuarios.ValidarPermisos;


@WebServlet("/InsertarPelicula")
public class InsertarPelicula extends HttpServlet implements I_Constantes{
	private static final long serialVersionUID = 1L;
       
    
    public InsertarPelicula() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pelicula = "";
		
		if (request.getParameter("p_pelicula") != null) {
		    pelicula = request.getParameter("p_pelicula");
		}

		int duracion = 0;
		if (request.getParameter("p_duracion") != null) {
			duracion = Integer.parseInt(request.getParameter("p_duracion"));
		}

		String descripcion_peli = "";
		if (request.getParameter("p_descripcion_peli") != null) {
			descripcion_peli = request.getParameter("p_descripcion_peli");
		}
		
		String estilo_pelicula = "";
		if (request.getParameter("p_estilo_pelicula") != null) {
			estilo_pelicula = request.getParameter("p_estilo_pelicula");
		}

		
		HttpSession session = request.getSession(false);
		Usuario usuario = null;
		if (session != null) {
		    usuario = (Usuario) session.getAttribute("usuario");
		}

		if (usuario == null) {
		    response.sendRedirect("login.jsp"); 
		    return;
		}

		int fk_usuario = usuario.getId();

		Pelicula p = new Pelicula(0, pelicula, duracion, descripcion_peli, estilo_pelicula, fk_usuario);
		String ruta = "MenuGestion";

		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		List<Integer> rolesPermitidos = Arrays.asList(1, 2);

		if (ValidarPermisos.validarUsuarioYRol(session, rolesPermitidos)) {
			db.insertarPelicua(p, con);
		    ruta = "MenuGestion";
		} else {
		    request.getSession().setAttribute("error", "No estás autorizado para hacer eso");
		    ruta = JSP_LOGIN;
		}

		db.desconectar(con);

		response.sendRedirect(ruta);  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
