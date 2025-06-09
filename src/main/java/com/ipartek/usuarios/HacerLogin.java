package com.ipartek.usuarios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Constantes;
import com.ipartek.modelo.dto.Rol;
import com.ipartek.modelo.dto.Usuario;
import com.ipartek.modelo.dto.V_Usuarios;


@WebServlet("/HacerLogin")
public class HacerLogin extends HttpServlet implements I_Constantes{
	private static final long serialVersionUID = 1L;
       
    
    public HacerLogin() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession(); 
			
		    String username = "";
			if (request.getParameter("p_user") != null) {
				username = request.getParameter("p_user");
			}
			
			String password = "";
			if (request.getParameter("p_pass") != null) {
				password = request.getParameter("p_pass");
			}
		    
		    DB_Helper db = new DB_Helper();
		    Connection con = db.conectar();
		    
		    Usuario usuario = db.validarUsuario(username, password, con);
		    
		    HashMap<String, Integer> listaPosiblesBloqueos = new HashMap<String, Integer>();
		    
		    if (session.getAttribute("s_lista_posibles_bloqueos")!=null) {
				listaPosiblesBloqueos=(HashMap<String, Integer>) session.getAttribute("s_lista_posibles_bloqueos");
			}
		    
		    String ruta = JSP_LOGIN;
		    
		    if (usuario.getId() != 0) {
		    	
		    	if (usuario.getFk_rol() == 3 || usuario.getFk_rol() == 4 ) {
		            request.getSession().setAttribute("error", "Acceso bloquedado, esta cuenta ha sido baneda o bloqueada");
		            ruta = JSP_LOGIN;
		        } else {
		            if(usuario.getFk_rol() == 1) {
		            	request.getSession().setAttribute("usuario", usuario);
			            ruta = JSP_GESTION;} else {request.getSession().setAttribute("usuario", usuario);
			            ruta = JSP_INDEX; }
		            } 
		            
		    		
		    		session.removeAttribute("s_lista_posibles_bloqueos");
		    	
		    	
		    	
		    } else {
		    	if(usuario.getId() == 0)  {
			    	
			    	if(listaPosiblesBloqueos.containsKey(username)) { 
			    		int intentos = listaPosiblesBloqueos.get(username);
			    		listaPosiblesBloqueos.put(username, intentos + 1);
			    		System.out.println(username);
			    		request.getSession().setAttribute("error", "Usuario o contraseña incorrecto");
			    		ruta = JSP_LOGIN;
			    	} else { listaPosiblesBloqueos.put(username, 1);
				    	request.getSession().setAttribute("error", "Usuario o contraseña incorrectos");
				    	ruta = JSP_LOGIN;
			    	}
			    	
			    	session.setAttribute("s_lista_posibles_bloqueos", listaPosiblesBloqueos);
			    	
			    	if (listaPosiblesBloqueos.get(username)!=null) {
			    	 if(listaPosiblesBloqueos.get(username) == 3) {
					    	Usuario user = db.obtenerIdFkporNombre(username, con);
					    	
					    	if(user.getFk_rol() !=3) {
					    		db.bloquearUsuarioPorId(user.getId(), con);
					    		System.out.println("bloquea");
					    		request.getSession().setAttribute("error", "Demasiados intentos fallidos, cuenta bloqueada, contacta con el admin");
					    		}
					    	}
			    		}
		    		}
		        
		    }
		    
		    List<V_Usuarios>listaUsuarios = db.obtenerTodosUsuarios(con);
		    List<Rol>listaRoles = db.obtenerRoles(con);
		    System.out.println(listaUsuarios);
		    db.desconectar(con);
		    
			request.setAttribute(ATR_LISTAS_USUARIOS, listaUsuarios);
			request.setAttribute(ATR_LISTA_ROLES, listaRoles);
			request.getRequestDispatcher(ruta).forward(request, response);
		    
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
