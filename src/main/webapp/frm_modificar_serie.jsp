<%@page import="com.ipartek.modelo.dto.V_Canciones"%>
<%@page import="com.ipartek.modelo.dto.V_Peliculas"%>
<%@page import="com.ipartek.modelo.I_Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.V_Series"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%
	V_Series serie = new V_Series();
	if(request.getAttribute(I_Constantes.ATR_SERIE) !=null){
		serie = (V_Series)request.getAttribute(I_Constantes.ATR_SERIE);
	}
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
		<section class="mod_container">
        <section class="form_container_mod">
            <form action="ModificarSerie" method="get" class="form_box">
            			<label for="p_id">ID:</label>
                		<input type="text" id="p_id" name="p_id" required readonly value="<%= serie.getId() %>" /><br />
						<label for="p_serie">Serie:</label>
						<input type="text" id="p_serie" name="p_serie" required value="<%= serie.getSerie() %>"  /><br />
				
						<label for="p_num_temporadas">Número de Temporadas:</label>
						<input type="number" id="p_num_temporadas" name="p_num_temporadas" required min="1" value="<%= serie.getNum_temporadas() %>"  /><br />
				
						<label for="p_descripcion_serie">Descripción:</label>
						<textarea id="p_descripcion_serie" name="p_descripcion_serie" required maxlength="250" ><%= serie.getDescripcion_serie() %></textarea><br />
				
						<button type="submit" class="inpBtn">Modificar Serie</button>
					</form>
        </section>
    </section>
     	
    </main>

   	<%@include file="includes/pie.jsp" %>

</body>
</html>