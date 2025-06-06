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
import com.ipartek.modelo.dto.Serie;
import com.ipartek.modelo.dto.Usuario;


@WebServlet("/ModificarSerie")
public class ModificarSerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ModificarSerie() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		if (request.getParameter("p_id") != null) {
			id = Integer.parseInt(request.getParameter("p_id"));
		}
		
		String serie = "";
		if (request.getParameter("p_serie") != null) {
		    serie = request.getParameter("p_serie");
		}

		int numTemporadas = 0;
		if (request.getParameter("p_num_temporadas") != null) {
		    numTemporadas = Integer.parseInt(request.getParameter("p_num_temporadas"));
		}

		String descripcion = "";
		if (request.getParameter("p_descripcion_serie") != null) {
		    descripcion = request.getParameter("p_descripcion_serie");
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

		Serie s = new Serie(id, serie, numTemporadas, descripcion, fk_usuario);

		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		db.modificarSerie(s, con);

		db.desconectar(con);

		response.sendRedirect("MenuGestion"); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
