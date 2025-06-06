package com.ipartek.menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ipartek.modelo.I_Constantes;
import com.ipartek.modelo.dto.Usuario;


@WebServlet("/MenuPeliculas")
public class MenuPeliculas extends HttpServlet implements I_Constantes{
	private static final long serialVersionUID = 1L;
       
    
    public MenuPeliculas() {
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

	    request.getRequestDispatcher(JSP_PELICULAS).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
