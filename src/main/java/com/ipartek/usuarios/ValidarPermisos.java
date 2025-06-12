package com.ipartek.usuarios;

import java.util.List;

import com.ipartek.modelo.dto.Usuario;

import jakarta.servlet.http.HttpSession;

public class ValidarPermisos {

    public static boolean validarUsuarioYRol(HttpSession session, List<Integer> rolesPermitidos) {
        if (session == null) return false;
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        return usuario != null && rolesPermitidos.contains(usuario.getFk_rol());
    }
}
