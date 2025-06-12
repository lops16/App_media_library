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
import com.ipartek.modelo.dto.Serie;
import com.ipartek.modelo.dto.Usuario;
import com.ipartek.usuarios.ValidarPermisos;


@WebServlet("/InsertarSerie")
public class InsertarSerie extends HttpServlet implements I_Constantes {
	private static final long serialVersionUID = 1L;
       
    
    public InsertarSerie() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		Serie s = new Serie(0, serie, numTemporadas, descripcion, fk_usuario);
		String ruta = "MenuGestion";

		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		List<Integer> rolesPermitidos = Arrays.asList(1, 2);

		if (ValidarPermisos.validarUsuarioYRol(session, rolesPermitidos)) {
			db.insertarSerie(s, con); 
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
