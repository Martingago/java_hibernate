package com.applicacion_hibernate.main;

import com.applicacion_hibernate.controller.DireccionController;
import com.applicacion_hibernate.controller.UsuarioController;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.Date;


public class HibernateJavaApp {

    public static void main(String[] args) {
        
        //new UsuarioController().createUsuario("Manuel", "fhfdgsgdg", "example@gmail.com");
        //new UsuarioController().createUsuario("Maria", "sdeoqopqdnffsf", "example02@gmail.com");
        new UsuarioController().listarUsuarios();
        //new DireccionController().addDireccionUsuario(7, "Calle inventada editada", "10A", 12506, "A coruña", "España");
        //new DireccionController().addDireccionUsuario(8, "Calle inventada editada", "12A", 12506, "A coruña", "España");
        //new DireccionController().deleteDireccionUsuario(3);
        //new DireccionController().deleteDireccionUsuario(6);
        //new UsuarioController().deleteUsuario(4);
        
        //new UsuarioController().updateUsuario(1, new Usuario("Editado", "0000", "martin@gmail.com", new Date(), new Date()));
    }
}
