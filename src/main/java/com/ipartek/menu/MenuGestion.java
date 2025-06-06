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
import com.ipartek.modelo.dto.V_Canciones;
import com.ipartek.modelo.dto.V_Peliculas;
import com.ipartek.modelo.dto.V_Series;


@WebServlet("/MenuGestion")
public class MenuGestion extends HttpServlet implements I_Constantes{
	private static final long serialVersionUID = 1L;
       
    
    public MenuGestion() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		Usuario usuario = null;
		if (session != null) {
		    usuario = (Usuario) session.getAttribute("usuario");
		}

	    if (usuario == null) {
	        response.sendRedirect(JSP_LOGIN); 
	        return;
	    }
	    
	    int id_usuario = usuario.getId();
	    
	    DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		List<V_Series> listaSeriesUsuario = db.obtenerSeriesUsuario(id_usuario,con);
		List<V_Peliculas> listaPeliculasUsuario = db.obtenerPeliculasUsuario(id_usuario, con);
		List<V_Canciones> listaCancionesUsuario = db.obtenerCancionesUsuario(id_usuario, con);
		System.out.println(listaSeriesUsuario);
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTAS_SERIES_USUARIO, listaSeriesUsuario);
		request.setAttribute(ATR_LISTAS_PELICULAS_USUARIO, listaPeliculasUsuario);
		request.setAttribute(ATR_LISTAS_CANCIONES_USUARIO, listaCancionesUsuario);
	    request.getRequestDispatcher(JSP_GESTION).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
