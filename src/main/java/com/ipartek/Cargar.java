package com.ipartek;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;


import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Constantes;


@WebServlet("/Cargar")
public class Cargar extends HttpServlet implements I_Constantes {
	private static final long serialVersionUID = 1L;
       
    public Cargar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(); 
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		
		session.removeAttribute("s_lista_posibles_bloqueos");
		
		db.desconectar(con);
		
		
		
		request.getRequestDispatcher(JSP_LOGIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
