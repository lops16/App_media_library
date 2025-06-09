package com.ipartek.gestion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Constantes;
import com.ipartek.modelo.dto.Cancion;
import com.ipartek.modelo.dto.Pelicula;
import com.ipartek.modelo.dto.Serie;
import com.ipartek.modelo.dto.Usuario;
import com.ipartek.modelo.dto.V_Series;


@WebServlet("/FrmModificar")
public class FrmModificar extends HttpServlet implements I_Constantes{
	private static final long serialVersionUID = 1L;
       
   
    public FrmModificar() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("tipo");
		
		int id = 0;
		if (request.getParameter("p_id") != null) {
			id = Integer.parseInt(request.getParameter("p_id"));
		}
		
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		String ruta = "";
		List<V_Series> listaSeries = db.obtenerTodasSeries(con);
		
		
		switch (tipo != null ? tipo.toLowerCase() : "") {
        case "serie":
            Serie serie = db.obtenerSeriePorId(id, con);
            request.setAttribute(ATR_SERIE, serie);
            request.setAttribute(ATR_LISTAS_SERIES, listaSeries);
            ruta = JSP_FRMMOD_SERIE;
            
            break;
        
        case "cancion":
        	//to do
            Cancion cancion = db.obtenerCancionPorId(id, con);
            request.setAttribute("entidad", cancion);
            request.getRequestDispatcher("/editarCancion.jsp").forward(request, response);
            break;
        
        case "usuario":
        	//to do
            Usuario usuario = db.obtenerUsuarioPorId(id, con);
            request.setAttribute("entidad", usuario);
            request.getRequestDispatcher("/editarUsuario.jsp").forward(request, response);
            break;
        
        case "pelicula":
        	// to do
            Pelicula pelicula = db.obtenerPeliculaPorId(id, con);
            request.setAttribute("entidad", pelicula);
            request.getRequestDispatcher("/editarPelicula.jsp").forward(request, response);
            break;
        
        default:
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tipo no válido");
            break;
		}
		
		db.desconectar(con);
				
		
		request.getRequestDispatcher(ruta).forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
