package com.applicacion_hibernate.main;

import com.applicacion_hibernate.controller.DireccionController;
import com.applicacion_hibernate.controller.UsuarioController;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.Date;


public class HibernateJavaApp {

    public static void main(String[] args) {
        //new UsuarioController().listarUsuarios();
        //new UsuarioController().createUsuario("Manuel", "fhfdgsgdg", "example@gmail.com");
        //new UsuarioController().deleteUsuario(1);
        //new DireccionController().addDireccionUsuario(1, "Calle inventada", "12A", 12506, "A coruña", "España");
        new UsuarioController().updateUsuario(1, new Usuario("Editado", "0000", "martin@gmail.com", new Date(), new Date()));
    }
}
