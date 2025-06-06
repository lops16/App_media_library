package com.ipartek.gestion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Pelicula;
import com.ipartek.modelo.dto.Usuario;


@WebServlet("/InsertarPelicula")
public class InsertarPelicula extends HttpServlet {
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

		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		db.insertarPelicua(p, con);

		db.desconectar(con);

		response.sendRedirect("MenuGestion");  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
