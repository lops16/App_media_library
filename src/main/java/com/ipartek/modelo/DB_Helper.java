package com.ipartek.modelo;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Cancion;
import com.ipartek.modelo.dto.Pelicula;
import com.ipartek.modelo.dto.Rol;
import com.ipartek.modelo.dto.Serie;
import com.ipartek.modelo.dto.Usuario;
import com.ipartek.modelo.dto.V_Canciones;
import com.ipartek.modelo.dto.V_Peliculas;
import com.ipartek.modelo.dto.V_Series;
import com.ipartek.modelo.dto.V_Usuarios;


public class DB_Helper implements I_Constantes{
	
	/**
	 * Funcion para conecyar a la BD
	 * @return null si no se ha podido conectar a la BD, o un objeto Conection a nuestra BD
	 * 
	 * para conectar se usa este codigo:
	 * <pre>
	 * 	 DB_Helper db = new DB_Helper();
		 Connection con = db.conectar();
	 * </pre>
	 * 
	 * */
	public Connection conectar() {
		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, PASS);
			System.out.println("BASE DE DATOS CONECTADA");
		} catch (ClassNotFoundException e) {
			System.out.println("NO SE ENCONTRO EL DRIVER");
		} catch (SQLException e) {
			System.out.println("ERROR AL CONECTAR A LA BD");
		}
		
		return con;
	}
	/**
	 * 
	 * @param con
	 */
	public void desconectar(Connection con) {
		try {
			con.close();
			System.out.println("BASE DE DATOS DESCONECTADA");
		} catch (SQLException e) {
			System.out.println("NO SE PUDO DESCONECTAR");
		}
	}

	public Usuario validarUsuario(String username, String password, Connection con) {
		
	    try {
	    	Usuario usuario = new Usuario();
	        CallableStatement cstmt = con.prepareCall(SP_VALIDAR_USUARIO);
	        cstmt.setString(1, username);
	        cstmt.setString(2, password);

	        ResultSet rs = cstmt.executeQuery();
	        while (rs.next()) {
	            usuario = new Usuario();
	            usuario.setId(rs.getInt(USUARIO_ID));
	            usuario.setUser(rs.getString(USUARIO_USUARIO));
	            usuario.setPass("");
	            usuario.setFk_rol(rs.getInt(USUARIO_FK_ROL));
	        }
	        
	        System.out.println(usuario);
	        return usuario;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	    
	}
	
	public List<V_Usuarios> obtenerTodosUsuarios(Connection con) {
		try {
			List<V_Usuarios> lista = new ArrayList<V_Usuarios>();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_TODOS_USUARIOS);
			
			cstmt.execute();
		    ResultSet rs = cstmt.getResultSet();
		    
		    while (rs.next()) {
		        V_Usuarios user = new V_Usuarios();
		        user.setId(rs.getInt(USUARIO_ID));
		        user.setUser(rs.getString(USUARIO_USUARIO));
		        user.setRol(rs.getString(ROLES_ROL));
		        user.setFk_rol(rs.getInt(USUARIO_FK_ROL));
		        
		        lista.add(user);
		        
		        //lista.add()
		    }
		    return lista;
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public List<V_Series> obtenerTodasSeries(Connection con) {
		

		try {
			List<V_Series> lista = new ArrayList<V_Series>();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_TODAS_SERIES);
			
			cstmt.execute();
		    ResultSet rs = cstmt.getResultSet();
		    
		    while (rs.next()) {
		        V_Series serie = new V_Series();
		        serie.setId(rs.getInt(SERIES_ID_SERIE));
		        serie.setSerie(rs.getString(SERIES_SERIE));
		        serie.setDescripcion_serie(rs.getString(SERIES_DESCRIPCION_SERIE));
		        serie.setNum_temporadas(rs.getInt(SERIES_NUM_SERIE));
		        serie.setFk_usuarios(rs.getInt(SERIES_FK_USUARIO));
		        serie.setUsername(rs.getString(USUARIO_USUARIO));
		        

		        lista.add(serie);
		        
		        //lista.add()
		    }
		    
		    return lista;
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public Integer insertarSerie(Serie s, Connection con) {
		try {
	        CallableStatement cstmt = con.prepareCall(SP_SERIES_INSERTAR);
	        cstmt.setString(1, s.getSerie());
	        cstmt.setInt(2, s.getNum_temporadas());
	        cstmt.setString(3, s.getDescripcion_serie());
	        cstmt.setInt(4, s.getFk_usuarios());
	        
	        int resultado = cstmt.executeUpdate();
			System.out.println(resultado + " filas añadidas");
			
			return resultado;
			
	    } catch (SQLException e) {
	    	System.out.println("Error");
			e.printStackTrace();
			return null;
	    }
		
	}
	
	public Integer insertarPelicua(Pelicula p, Connection con) {
		
		try {
	        CallableStatement cstmt = con.prepareCall(SP_PELICULAS_INSERTAR);
	        cstmt.setString(1, p.getPelicula());
	        cstmt.setInt(2, p.getDuracion());
	        cstmt.setString(3, p.getDescripcion_peli());
	        cstmt.setString(4, p.getEstilo_pelicula());
	        cstmt.setInt(5, p.getFk_usuarios());
	        
	        int resultado = cstmt.executeUpdate();
			System.out.println(resultado + " filas añadidas");
			
			return resultado;
			
	    } catch (SQLException e) {
	    	System.out.println("Error");
			e.printStackTrace();
			return null;
	    }
	}
	
	public Integer insertarCancion(Cancion c, Connection con) {
		try {
	        CallableStatement cstmt = con.prepareCall(SP_CANCIONES_INSERTAR);
	        cstmt.setString(1, c.getTitulo());
	        cstmt.setString(2, c.getEstilo_cancion());
	        cstmt.setString(3, c.getDescripcion_cancion());
	        cstmt.setString(4, c.getEnlace());
	        cstmt.setInt(5, c.getFk_usuario());
	        
	        int resultado = cstmt.executeUpdate();
			System.out.println(resultado + " filas añadidas");
			
			return resultado;
			
	    } catch (SQLException e) {
	    	System.out.println("Error");
			e.printStackTrace();
			return null;
	    }
		
	}

	public List<V_Series> obtenerSeriesUsuario(int id, Connection con) {
		
		try {
			List<V_Series> lista = new ArrayList<V_Series>();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_SERIES_USUARIO);
			
			cstmt.setInt(1, id);
			cstmt.execute();
		    ResultSet rs = cstmt.getResultSet();
		    
		    while (rs.next()) {
		        V_Series serie = new V_Series();
		        serie.setId(rs.getInt(SERIES_ID_SERIE));
		        serie.setSerie(rs.getString(SERIES_SERIE));
		        serie.setDescripcion_serie(rs.getString(SERIES_DESCRIPCION_SERIE));
		        serie.setNum_temporadas(rs.getInt(SERIES_NUM_SERIE));
		        serie.setFk_usuarios(rs.getInt(SERIES_FK_USUARIO));
		        serie.setUsername(rs.getString(USUARIO_USUARIO));
		        

		        lista.add(serie);
		        
		        
		    }
		    
		    return lista;
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public List<V_Peliculas> obtenerPeliculasUsuario(int id, Connection con) {
		try {
			List<V_Peliculas> lista = new ArrayList<V_Peliculas>();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_PELICULAS_USUARIO);
			
			cstmt.setInt(1, id);
			cstmt.execute();
		    ResultSet rs = cstmt.getResultSet();
		    
		    while (rs.next()) {
		        V_Peliculas peli = new V_Peliculas();
		        peli.setId(rs.getInt(PELICULAS_ID_PELICULA));
		        peli.setPelicula(rs.getString(PELICULAS_PELICULA));
		        peli.setDuracion(rs.getInt(PELICULAS_DURACION));
		        peli.setDescripcion_peli(rs.getString(PELICULAS_DESCRIPCION_PELICULA));
		        peli.setEstilo_pelicula(rs.getString(PELICULAS_ESTILO_PELICULA));
		        peli.setFk_usuarios(rs.getInt(PELICULAS_FK_USUARIO));
		        peli.setUsername(rs.getString(USUARIO_USUARIO));
		        

		        lista.add(peli);
		        
		        
		    }
		    
		    return lista;
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public List<V_Canciones> obtenerCancionesUsuario(int id, Connection con) {
		try {
			List<V_Canciones> lista = new ArrayList<V_Canciones>();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_CANCIONES_USUARIO);
			
			cstmt.setInt(1, id);
			cstmt.execute();
		    ResultSet rs = cstmt.getResultSet();
		    
		    while (rs.next()) {
		    	V_Canciones can = new V_Canciones();
		        can.setId(rs.getInt(PELICULAS_ID_PELICULA));
		        can.setTitulo(rs.getString(CANCIONES_TITULO));
		        can.setDescripcion_cancion(rs.getString(CANCIONES_DESCRIPCION_CANCION));
		        can.setEstilo_cancion(rs.getString(CANCIONES_ESTILO_CANCION));
		        can.setEnlace(rs.getString(CANCIONES_ENLACE));
		        can.setFk_usuario(rs.getInt(CANCIONES_FK_USUARIO));
		        can.setUsername(rs.getString(USUARIO_USUARIO));
		        

		        lista.add(can);
		        
		        
		    }
		    
		    return lista;
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public Integer borrarSeriePorId(int id, Connection con) {
		CallableStatement cstmt;
		try {
			cstmt = con.prepareCall(SP_BORRAR_SERIE);
			cstmt.setInt(1, id);

			int resultado = cstmt.executeUpdate();
			System.out.println(resultado + " filas borradas");
			
			return resultado;
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Integer borrarPeliculaPorId(int id, Connection con) {
		CallableStatement cstmt;
		try {
			cstmt = con.prepareCall(SP_BORRAR_PELICULA);
			cstmt.setInt(1, id);

			int resultado = cstmt.executeUpdate();
			System.out.println(resultado + " filas borradas");
			
			return resultado;
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Integer borrarCancionPorId(int id, Connection con) {
		CallableStatement cstmt;
		try {
			cstmt = con.prepareCall(SP_BORRAR_CANCION);
			cstmt.setInt(1, id);

			int resultado = cstmt.executeUpdate();
			System.out.println(resultado + " filas borradas");
			
			return resultado;
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
			return null;
		}
		
	}

	public Usuario obtenerIdFkporNombre(String user, Connection con) {
		
	    try {
	    	Usuario usuario = new Usuario();
	        CallableStatement cstmt = con.prepareCall(SP_OBTENER_ID_USUARIO);
	        cstmt.setString(1, user);

	        ResultSet rs = cstmt.executeQuery();
	        while (rs.next()) {
	            usuario = new Usuario();
	            usuario.setId(rs.getInt(USUARIO_ID));
	            usuario.setFk_rol(rs.getInt(USUARIO_FK_ROL));
	        }
	        System.out.println(usuario);
	        return usuario;
	        
	        
	        
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public void bloquearUsuarioPorId(int id, Connection con) {
		try {
			CallableStatement cstm = con.prepareCall(SP_USUARIO_BLOQUEAR);
			cstm.setInt(1, id);
			
			cstm.execute();
			
		} catch (Exception e) {
			
		}
		
	}
	public Integer modificarSerie(Serie s, Connection con) {
		try {
			CallableStatement cstmt = con.prepareCall(SP_MODIFICAR_SERIE);
			
			cstmt.setInt(1, s.getId());
			cstmt.setString(2, s.getSerie());
			cstmt.setInt(3, s.getNum_temporadas());
			cstmt.setString(4, s.getDescripcion_serie() );
			cstmt.setInt(5, s.getFk_usuarios());

			int resultado = cstmt.executeUpdate();
			System.out.println(resultado + " fila modificada");
			
			return resultado;
			
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
			return null;
		}
		
	}
	public Serie obtenerSeriePorId(int id, Connection con) {
		try {
			V_Series serie = new V_Series();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_SERIE_POR_ID);

			cstmt.setInt(1, id);

			cstmt.execute();
			ResultSet rs = cstmt.getResultSet();
			int contador = 0;
			while (rs.next()) {

				serie.setId(rs.getInt(SERIES_ID_SERIE));
				serie.setSerie(rs.getString(SERIES_SERIE));
		        serie.setNum_temporadas(rs.getInt(SERIES_NUM_SERIE));
		        serie.setDescripcion_serie(rs.getString(SERIES_DESCRIPCION_SERIE));
		        serie.setFk_usuarios(rs.getInt(SERIES_FK_USUARIO));
		        
		        contador ++;

			}
			if(contador <= 1) {
				System.out.println(serie);
				return serie;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public List<Rol> obtenerRoles(Connection con) {
		try {
			List<Rol> lista = new ArrayList<Rol>();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_TODOS_ROLES);
			
			cstmt.execute();
		    ResultSet rs = cstmt.getResultSet();
		    
		    while (rs.next()) {
		    Rol r = new Rol();
		        r.setId(rs.getInt(ROLES_ID_ROL));
		        r.setRol(rs.getString(ROLES_ROL));
		        

		        lista.add(r);
		    }
		    
		    return lista;
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public Cancion obtenerCancionPorId(int id, Connection con) {
		// TODO Auto-generated method stub
		return null;
	}
	public Usuario obtenerUsuarioPorId(int id, Connection con) {
		try {
			V_Usuarios user = new V_Usuarios();
			CallableStatement cstmt = con.prepareCall(SP_OBTENER_USUARIO_POR_ID);

			cstmt.setInt(1, id);

			cstmt.execute();
			ResultSet rs = cstmt.getResultSet();
			int contador = 0;
			while (rs.next()) {

				user.setId(rs.getInt(USUARIO_ID));
				user.setUser(rs.getString(USUARIO_USUARIO));
				user.setPass(rs.getString(USUARIO_PASSWORD));
				user.setFk_rol(rs.getInt(USUARIO_FK_ROL));
				user.setRol(rs.getString(ROLES_ROL));
		        
		        contador ++;

			}
			if(contador <= 1) {
				System.out.println(user);
				return user;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public Pelicula obtenerPeliculaPorId(int id, Connection con) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

	

	
	
}
