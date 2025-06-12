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
import com.ipartek.modelo.dto.Cancion;
import com.ipartek.modelo.dto.Usuario;
import com.ipartek.usuarios.ValidarPermisos;


@WebServlet("/InsertarCancion")
public class InsertarCancion extends HttpServlet implements I_Constantes {
	private static final long serialVersionUID = 1L;
       
   
    public InsertarCancion() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = "";
		if (request.getParameter("p_titulo") != null) {
		    titulo = request.getParameter("p_titulo");
		}

		String estilo_cancion = "";
		if (request.getParameter("p_estilo_cancion") != null) {
		    estilo_cancion = request.getParameter("p_estilo_cancion");
		}

		String descripcion_cancion = "";
		if (request.getParameter("p_descripcion_cancion") != null) {
		    descripcion_cancion = request.getParameter("p_descripcion_cancion");
		}

		String enlace = "";
		if (request.getParameter("p_enlace") != null) {
		    enlace = request.getParameter("p_enlace");
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

		
		Cancion c = new Cancion(0, titulo, estilo_cancion, descripcion_cancion, enlace, fk_usuario);
		String ruta = "MenuGestion";

		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		List<Integer> rolesPermitidos = Arrays.asList(1, 2);

		if (ValidarPermisos.validarUsuarioYRol(session, rolesPermitidos)) {
			db.insertarCancion(c, con);
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
