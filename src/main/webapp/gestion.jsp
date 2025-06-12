<%@page import="com.ipartek.modelo.dto.Rol"%>
<%@page import="com.ipartek.modelo.dto.V_Usuarios"%>
<%@page import="com.ipartek.modelo.dto.Usuario"%>
<%@page import="com.ipartek.modelo.dto.V_Canciones"%>
<%@page import="com.ipartek.modelo.dto.V_Peliculas"%>
<%@page import="com.ipartek.modelo.I_Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.V_Series"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<V_Series>
	listaSeries = new ArrayList<>(); if
	(request.getAttribute(I_Constantes.ATR_LISTAS_SERIES_USUARIO) != null) {
	listaSeries = (List<V_Series>) request.getAttribute(I_Constantes.ATR_LISTAS_SERIES_USUARIO); } %>
	
	<% List<V_Peliculas>
	listaPeliculas = new ArrayList<>(); if
	(request.getAttribute(I_Constantes.ATR_LISTAS_PELICULAS_USUARIO) != null) {
	listaPeliculas = (List<V_Peliculas>) request.getAttribute(I_Constantes.ATR_LISTAS_PELICULAS_USUARIO); } %>
	
	<% List<V_Canciones>
	listaCanciones = new ArrayList<>(); if
	(request.getAttribute(I_Constantes.ATR_LISTAS_CANCIONES_USUARIO) != null) {
	listaCanciones = (List<V_Canciones>) request.getAttribute(I_Constantes.ATR_LISTAS_CANCIONES_USUARIO); } %>
	
	<% List<V_Usuarios>
	listaUsuarios = new ArrayList<>(); if
	(request.getAttribute(I_Constantes.ATR_LISTAS_USUARIOS) != null) {
	listaUsuarios = (List<V_Usuarios>) request.getAttribute(I_Constantes.ATR_LISTAS_USUARIOS); } %>
	
	<% List<Rol>
	listaRoles = new ArrayList<>(); if
	(request.getAttribute(I_Constantes.ATR_LISTA_ROLES) != null) {
	listaRoles = (List<Rol>) request.getAttribute(I_Constantes.ATR_LISTA_ROLES); } %>
	
	<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    int rol = usuario.getFk_rol();
	%>
	
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestion</title>
     <link rel="stylesheet" href="styles/style_variables.css" />
    <link rel="stylesheet" href="styles/style_form_table.css" >
    <link rel="stylesheet" href="styles/style.css" >
</head>
<body>
    
    <%@include file="includes/cabecera.jsp" %>


    <main>
    	<% if (rol == 2) { %>
		<section id="multi_control">
			<h2 class="titulo_series">Gestion de series</h2>
			<section class="control_inventario series_box">
				<section class="form_container">
					<form action="InsertarSerie" method="get" class="form_box">
						<label for="p_serie">Serie:</label>
						<input type="text" id="p_serie" name="p_serie" required /><br />
				
						<label for="p_num_temporadas">Número de Temporadas:</label>
						<input type="number" id="p_num_temporadas" name="p_num_temporadas" required min="1" /><br />
				
						<label for="p_descripcion_serie">Descripción:</label>
						<textarea id="p_descripcion_serie" name="p_descripcion_serie" required maxlength="250"></textarea><br />
				
						<button type="submit" class="inpBtn">Registrar Serie</button>
					</form>
				</section>
				<section class="table_container">
					<table class="table_box">
						<thead>
							<tr>
								<th>ID</th>
								<th>Serie</th>
								<th>Temporadas</th>
								<th>Descripción</th>
								<th>Usuario</th>
								<th>Opciones</th>
							</tr>
						</thead>
						<tbody>
							<% for (V_Series serie : listaSeries) { %>
							<tr>
								<td><%= serie.getId() %></td>
								<td><%= serie.getSerie() %></td>
								<td><%= serie.getNum_temporadas() %></td>
								<td><%= serie.getDescripcion_serie() %></td>
								<td><%= serie.getUsername() %></td>
								<td class="options">
									<a href="FrmModificar?tipo=serie&p_id=<%= serie.getId() %>">
										<!-- icono editar -->
										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
											<path d="M362.7 19.3L314.3 67.7 444.3 197.7l48.4-48.4c25-25 25-65.5 0-90.5L453.3 19.3c-25-25-65.5-25-90.5 0zm-71 71L58.6 323.5c-10.4 10.4-18 23.3-22.2 37.4L1 481.2C-1.5 489.7 .8 498.8 7 505s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L421.7 220.3 291.7 90.3z"/>
										</svg>
									</a>
									<a href="BorrarSerie?p_id=<%= serie.getId() %>">
										<!-- icono borrar -->
										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
											<path d="M135.2 17.7L128 32 32 32C14.3 32 0 46.3 0 64S14.3 96 32 96l384 0c17.7 0 32-14.3 32-32s-14.3-32-32-32l-96 0-7.2-14.3C307.4 6.8 296.3 0 284.2 0L163.8 0c-12.1 0-23.2 6.8-28.6 17.7zM416 128L32 128 53.2 467c1.6 25.3 22.6 45 47.9 45l245.8 0c25.3 0 46.3-19.7 47.9-45L416 128z"/>
										</svg>
									</a>
								</td>
							</tr>
							<% } %>
						</tbody>
					</table>
				</section>
			</section>
			
			<h2 class="titulo_peliculas">Gestion de peliculas</h2>
			<section class="control_inventario peliculas_box">
				<section class="form_container">
					<form action="InsertarPelicula" method="get" class="form_box">
						<label for="p_pelicula">Película:</label>
					    <input type="text" id="p_pelicula" name="p_pelicula" required /><br />
					
					    <label for="p_duracion">Duración (minutos):</label>
					    <input type="number" id="p_duracion" name="p_duracion" required min="1" /><br />
					
					    <label for="p_descripcion_peli">Descripción:</label>
					    <textarea id="p_descripcion_peli" name="p_descripcion_peli" required maxlength="250"></textarea><br />
					
					    <label for="p_estilo_pelicula">Estilo:</label>
					    <input type="text" id="p_estilo_pelicula" name="p_estilo_pelicula" required /><br />
					
					    <button type="submit" class="inpBtn">Registrar Película</button>
					</form>
				</section>
				<section class="table_container">
					<table class="table_box">
						 <thead>
					        <tr>
					            <th>ID</th>
					            <th>Película</th>
					            <th>Duración</th>
					            <th>Descripción</th>
					            <th>Estilo</th>
					            <th>Usuario</th>
					            <th>Opciones</th>
					        </tr>
					    </thead>
					    <tbody>
					        <% for (V_Peliculas pelicula : listaPeliculas) { %>
					        <tr>
					            <td><%= pelicula.getId() %></td>
					           <td><%= pelicula.getPelicula() %></td>
					            <td><%= pelicula.getDuracion() %> min</td>
					            <td><%= pelicula.getDescripcion_peli() %></td>
					            <td><%= pelicula.getEstilo_pelicula() %></td>
					            <td><%= pelicula.getUsername() %></td>
					            <td class="options">
					                <a href="FrmModificar?tipo=pelicula&p_id=<%= pelicula.getId() %>">
					                    <!-- icono editar -->
					                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
					                        <path d="M362.7 19.3L314.3 67.7 444.3 197.7l48.4-48.4c25-25 25-65.5 0-90.5L453.3 19.3c-25-25-65.5-25-90.5 0zm-71 71L58.6 323.5c-10.4 10.4-18 23.3-22.2 37.4L1 481.2C-1.5 489.7 .8 498.8 7 505s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L421.7 220.3 291.7 90.3z"/>
					                    </svg>
					                </a>
					                <a href="BorrarPelicula?p_id=<%= pelicula.getId() %>">
					                    <!-- icono borrar -->
					                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
					                        <path d="M135.2 17.7L128 32 32 32C14.3 32 0 46.3 0 64S14.3 96 32 96l384 0c17.7 0 32-14.3 32-32s-14.3-32-32-32l-96 0-7.2-14.3C307.4 6.8 296.3 0 284.2 0L163.8 0c-12.1 0-23.2 6.8-28.6 17.7zM416 128L32 128 53.2 467c1.6 25.3 22.6 45 47.9 45l245.8 0c25.3 0 46.3-19.7 47.9-45L416 128z"/>
					                    </svg>
					                </a>
					            </td>
					        </tr>
					        <% } %>
					    </tbody>
					</table>
				</section>
			</section>
			
			<h2 class="titulo_canciones">Gestion de canciones</h2>
			<section class="control_inventario canciones_box">
				<section class="form_container">
					<form action="InsertarCancion" method="get" class="form_box">
						<label for="p_titulo">Cancion:</label>
					    <input type="text" id="p_titulo" name="p_titulo" required /><br />
					
					   <label for="p_estilo_cancion">Estilo:</label>
					    <input type="text" id="p_estilo_cancion" name="p_estilo_cancion" required /><br />
					
					    <label for="p_descripcion_cancion">Descripción:</label>
					    <textarea id="p_descripcion_cancion" name="p_descripcion_cancion" required maxlength="250"></textarea><br />
					
					    <label for="p_enlace">Enlace:</label>
					    <input type="text" id="p_enlace" name="p_enlace" required /><br />
					
					    <button type="submit" class="inpBtn">Registrar Cancion</button>
					</form>
				</section>
				<section class="table_container">
					<table class="table_box">
						 <thead>
					        <tr>
					            <th>ID</th>
					            <th>Cancion</th>
					            <th>Estilo</th>
					            <th>Descripción</th>
					            <th>Enlace</th>
					            <th>Usuario</th>
					            <th>Opciones</th>
					        </tr>
					    </thead>
					    <tbody>
					        <% for (V_Canciones canciones : listaCanciones) { %>
					        <tr>
					            <td><%= canciones.getId() %></td>
					           <td><%= canciones.getTitulo() %></td>
					            <td><%= canciones.getEstilo_cancion() %> min</td>
					            <td><%= canciones.getDescripcion_cancion() %></td>
					            <td><%= canciones.getEnlace() %></td>
					            <td><%= canciones.getUsername() %></td>
					            <td class="options">
					                <a href="FrmModificar?tipo=cancion&p_id=<%= canciones.getId() %>">
					                    <!-- icono editar -->
					                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
					                        <path d="M362.7 19.3L314.3 67.7 444.3 197.7l48.4-48.4c25-25 25-65.5 0-90.5L453.3 19.3c-25-25-65.5-25-90.5 0zm-71 71L58.6 323.5c-10.4 10.4-18 23.3-22.2 37.4L1 481.2C-1.5 489.7 .8 498.8 7 505s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L421.7 220.3 291.7 90.3z"/>
					                    </svg>
					                </a>
					                <a href="BorrarCancion?p_id=<%= canciones.getId() %>">
					                    <!-- icono borrar -->
					                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
					                        <path d="M135.2 17.7L128 32 32 32C14.3 32 0 46.3 0 64S14.3 96 32 96l384 0c17.7 0 32-14.3 32-32s-14.3-32-32-32l-96 0-7.2-14.3C307.4 6.8 296.3 0 284.2 0L163.8 0c-12.1 0-23.2 6.8-28.6 17.7zM416 128L32 128 53.2 467c1.6 25.3 22.6 45 47.9 45l245.8 0c25.3 0 46.3-19.7 47.9-45L416 128z"/>
					                    </svg>
					                </a>
					            </td>
					        </tr>
					        <% } %>
					    </tbody>
					</table>
				</section>
		
		</section>
     	</section>
    	<% } %>
    	<% if (rol == 1) { %>
    		<section class="control_inventario">
				<section class="form_container">
					<form action="InsertarSerie" method="get" class="form_box">
						<label for="p_user">Usuario</label>
						<input type="text" id="p_user" name="p_user" required /><br />
						
						<label for="p_pass">Contraseña</label>
						<input type="text" id="p_pass" name="p_pass" required /><br />
						
						<label for="p_rol">Rol</label>
						<select type="text" id="p_rol" name="p_rol" required  />
							 <% for (Rol r : listaRoles) { %>
	                        	<option value="<%= r.getId() %>"><%= r.getRol() %></option>
	                    <% } %>
						</select><br />

						<button type="submit" class="inpBtn">Registrar</button>
					</form>
				</section>
				<section class="table_container">
					<table class="table_box">
						<thead>
							<tr>
								<th>ID</th>
								<th>Usuario</th>
								<th>Rol</th>
								<th>Opciones</th>
							</tr>
						</thead>
						<tbody>
							<% for (V_Usuarios u : listaUsuarios) { %>
							<tr>
								<td><%= u.getId() %></td>
								<td><%= u.getUser() %></td>
								<td><%= u.getRol() %></td>
								<td class="options">
									
									<% if (u.getFk_rol() == 2) { %>
									<a href="BanearUsuario?p_id=<%= u.getId() %>">
										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><!--!Font Awesome Free 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2025 Fonticons, Inc.--><path d="M144 144l0 48 160 0 0-48c0-44.2-35.8-80-80-80s-80 35.8-80 80zM80 192l0-48C80 64.5 144.5 0 224 0s144 64.5 144 144l0 48 16 0c35.3 0 64 28.7 64 64l0 192c0 35.3-28.7 64-64 64L64 512c-35.3 0-64-28.7-64-64L0 256c0-35.3 28.7-64 64-64l16 0z"/></svg>
									</a>
									<% } %>
									<% if (u.getFk_rol() == 3 || u.getFk_rol() == 4) { %>
									<a href="DesbloquearUsuario?p_id=<%= u.getId() %>">
										
										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512"><!--!Font Awesome Free 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2025 Fonticons, Inc.--><path d="M352 144c0-44.2 35.8-80 80-80s80 35.8 80 80l0 48c0 17.7 14.3 32 32 32s32-14.3 32-32l0-48C576 64.5 511.5 0 432 0S288 64.5 288 144l0 48L64 192c-35.3 0-64 28.7-64 64L0 448c0 35.3 28.7 64 64 64l320 0c35.3 0 64-28.7 64-64l0-192c0-35.3-28.7-64-64-64l-32 0 0-48z"/></svg>
									</a>
									<% } %>
									
									<% if (u.getFk_rol() == 1) { %>
									<a href="">
										
										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--!Font Awesome Free 6.7.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2025 Fonticons, Inc.--><path d="M367.2 412.5L99.5 144.8C77.1 176.1 64 214.5 64 256c0 106 86 192 192 192c41.5 0 79.9-13.1 111.2-35.5zm45.3-45.3C434.9 335.9 448 297.5 448 256c0-106-86-192-192-192c-41.5 0-79.9 13.1-111.2 35.5L412.5 367.2zM0 256a256 256 0 1 1 512 0A256 256 0 1 1 0 256z"/></svg>
									</a>
									<% } %>
									
									<a href="FrmModificar?tipo=usuario&p_id=<%= u.getId() %>">
										
										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
											<path d="M362.7 19.3L314.3 67.7 444.3 197.7l48.4-48.4c25-25 25-65.5 0-90.5L453.3 19.3c-25-25-65.5-25-90.5 0zm-71 71L58.6 323.5c-10.4 10.4-18 23.3-22.2 37.4L1 481.2C-1.5 489.7 .8 498.8 7 505s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L421.7 220.3 291.7 90.3z"/>
										</svg>
									</a>
									<a href="BorrarUsuario?p_id=<%= u.getId() %>">
										
										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
											<path d="M135.2 17.7L128 32 32 32C14.3 32 0 46.3 0 64S14.3 96 32 96l384 0c17.7 0 32-14.3 32-32s-14.3-32-32-32l-96 0-7.2-14.3C307.4 6.8 296.3 0 284.2 0L163.8 0c-12.1 0-23.2 6.8-28.6 17.7zM416 128L32 128 53.2 467c1.6 25.3 22.6 45 47.9 45l245.8 0c25.3 0 46.3-19.7 47.9-45L416 128z"/>
										</svg>
									</a>
								</td>
							</tr>
							<% } %>
						</tbody>
					</table>
				</section>
			</section>
    	<% } %>
    </main>
    

   	<%@include file="includes/pie.jsp" %>

</body>
</html>