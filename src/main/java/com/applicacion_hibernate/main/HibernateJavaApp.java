package com.applicacion_hibernate.main;

import com.applicacion_hibernate.controller.UsuarioController;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.Date;


public class HibernateJavaApp {

    public static void main(String[] args) {
        //new UsuarioController().listarUsuarios();
        new UsuarioController().createUsuario("Martin", "holahola", "marta@gmail.com");
        //new UsuarioController().deleteUsuario(1);
        //new UsuarioController().updateUsuario(1, new Usuario("Martin", "123456", "martin@gmail.com", new Date(), new Date()));
    }
}
