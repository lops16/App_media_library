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
import com.ipartek.modelo.dto.Usuario;
import com.ipartek.usuarios.ValidarPermisos;



@WebServlet("/BorrarSerie")
public class BorrarSerie extends HttpServlet implements I_Constantes{
	private static final long serialVersionUID = 1L;
       
   
    public BorrarSerie() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		
		int id = 0;
		if (request.getParameter("p_id") != null) {
			id = Integer.parseInt(request.getParameter("p_id"));
		}
		String ruta = JSP_LOGIN;
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		List<Integer> rolesPermitidos = Arrays.asList(1, 2);

		if (ValidarPermisos.validarUsuarioYRol(session, rolesPermitidos)) {
		    db.borrarSeriePorId(id, con);  
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
