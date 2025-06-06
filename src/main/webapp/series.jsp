<%@page import="com.ipartek.modelo.I_Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.V_Series"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% List<V_Series>
	listaSeries = new ArrayList<>(); if
	(request.getAttribute(I_Constantes.ATR_LISTAS_SERIES) != null) {
	listaSeries = (List<V_Series>) request.getAttribute(I_Constantes.ATR_LISTAS_SERIES); } %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>IparMedia-Series</title>
    <link rel="stylesheet" href="styles/style_variables.css" />
    <link rel="stylesheet" href="styles/style.css" />
    <link rel="stylesheet" href="styles/style_series.css" />
</head>
<body>

<%@include file="includes/cabecera.jsp" %>

<main>
    <section class="cuadricula">
      
     	 <% for (V_Series serie : listaSeries) { %>
     	 <article >
             <div class="serie"> 
	            <div class="titulo">
	                <h2><%= serie.getSerie() %></h2>
	            </div>
	            <div class="descripcion">
		            <p>
		                <%= serie.getDescripcion_serie() %>
		            </p>
	            </div>
	            <div class="num_temporadas">
	                <h3>Temporadas</h3>
	                <p><%= serie.getNum_temporadas() %></p>
	            </div>
	            <div class="Usuario">
	                 <h3>Subido por</h3>
		                <p>
		                <%= serie.getUsername() %>
		            	</p>
	            </div>
           </div>
           </article>
          <% } %>
	  
    </section>
</main>

<%@include file="includes/pie.jsp" %>

</body>
</html>
