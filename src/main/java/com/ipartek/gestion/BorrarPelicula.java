package com.ipartek.gestion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import com.ipartek.modelo.DB_Helper;


@WebServlet("/BorrarPelicula")
public class BorrarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BorrarPelicula() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		if (request.getParameter("p_id") != null) {
			id = Integer.parseInt(request.getParameter("p_id"));
		}
		
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		db.borrarPeliculaPorId(id, con);

		db.desconectar(con);
		
		response.sendRedirect("MenuGestion");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
