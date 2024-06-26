package com.applicacion_hibernate.main;

import com.applicacion_hibernate.controller.DireccionController;
import com.applicacion_hibernate.controller.UsuarioController;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.Date;


public class HibernateJavaApp {

    public static void main(String[] args) {
        
//        new UsuarioController().createUsuario("Manuel", "fhfdgsgdg", "example@gmail.com");
//        new UsuarioController().createUsuario("Maria", "sdeoqopqdnffsf", "example02@gmail.com");
//        new UsuarioController().createUsuario("Manuel", "343rernsfsdf", "example03@gmail.com");
//        new UsuarioController().createUsuario("Maria", "xvdgjd", "example05@gmail.com");
//        new DireccionController().addDireccionUsuario(2, "Calle Santiago", "10A", 12506, "A coruña", "España");
//        new DireccionController().addDireccionUsuario(4, "Calle Senrra", "12A", 12506, "A coruña", "España");
        new UsuarioController().listarUsuarios();
        //new DireccionController().listarDirecciones();
        
        //new DireccionController().deleteDireccionUsuario(3);
        //new DireccionController().deleteDireccionUsuario(6);
        //new UsuarioController().deleteUsuario(4);
        
        //new UsuarioController().updateUsuario(1, new Usuario("Editado", "0000", "martin@gmail.com", new Date(), new Date()));
    }
}
