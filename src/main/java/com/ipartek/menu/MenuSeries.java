package com.ipartek.menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Constantes;
import com.ipartek.modelo.dto.Usuario;
import com.ipartek.modelo.dto.V_Series;


@WebServlet("/MenuSeries")
public class MenuSeries extends HttpServlet implements I_Constantes{
	private static final long serialVersionUID = 1L;
       
   
    public MenuSeries() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); 
		Usuario usuario = null;
		if (session != null) {
		    usuario = (Usuario) session.getAttribute("usuario");
		}

	    if (usuario == null) {
	        response.sendRedirect(JSP_LOGIN); 
	        return;
	    }
	    
	    DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		List<V_Series> listaSeries = db.obtenerTodasSeries(con);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTAS_SERIES, listaSeries);
	    request.getRequestDispatcher(JSP_SERIES).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
