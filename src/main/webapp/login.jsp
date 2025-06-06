
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="styles/style_variables.css" />
    <link rel="stylesheet" href="styles/style_login.css" />
    <link rel="stylesheet" href="styles/style.css" />
</head>
<body>

<%@include file="includes/cabecera.jsp" %>

<main>
    <section class="mod_container">
        <section class="form_container_login">
            <form id="loginForm" action="HacerLogin" method="get" class="form_box">


                <label for="p_Titulo" hidden="">Usuario:</label>
                <input type="text" id="p_user" name="p_user" required placeholder="Usuario" />

                <label for="p_ISBN" hidden="">Contraseña:</label>
                <input type="password" id="p_pass" name="p_pass" required  placeholder="Contraseña"/><br />

 

                <button type="submit" class="inpBtn">Login</button>
            </form>
        </section>
        <% if(session.getAttribute("error") != null) { %>
	    	<section class="error_mensaje">
	    		<p><%= session.getAttribute("error") %></p>
	    	</section>
		<% } %>
    </section>
</main>

<%@include file="includes/pie.jsp" %>
<script src="JS/HashLogin.js"></script>
</body>
</html>
