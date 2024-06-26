package com.applicacion_hibernate.main;

import com.applicacion_hibernate.controller.DireccionController;
import com.applicacion_hibernate.controller.MarcaController;
import com.applicacion_hibernate.controller.UsuarioController;
import com.applicacion_hibernate.entidades.Marca;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.Date;


public class HibernateJavaApp {

    public static void main(String[] args) {
        
        new UsuarioController().createUsuario("Manuel", "fhfdgsgdg", "example@gmail.com");
        new UsuarioController().createUsuario("Maria", "sdeoqopqdnffsf", "example02@gmail.com");

        //new DireccionController().addDireccionUsuario(19, "Calle Santiago", "10A", 12506, "A coruña", "España");
        //new DireccionController().addDireccionUsuario(4, "Calle Senrra", "12A", 12506, "A coruña", "España");
        //
        //new DireccionController().listarDirecciones();
        new MarcaController().addMarca("inventada", "Nueva marca añadida inventada");
        new MarcaController().deleteMarca(19);
        new MarcaController().updateMarca(17, new Marca("Cambio cosasss", "Cambio desscripcion"));
        
        //new MarcaController().listarMarcas();
        //new DireccionController().deleteDireccionUsuario(2);
        //new DireccionController().addDireccionUsuario(2, "Cambio de la direccion 2", "545", 0, "editada", "inentado");
        //new DireccionController().listarDirecciones();

        
        //new DireccionController().deleteDireccionUsuario(6);
        //new UsuarioController().deleteUsuario(4);
        
        new UsuarioController().updateUsuario(1, new Usuario("Editado", "0000", "martin@gmail.com", new Date(), new Date()));
        new UsuarioController().listarUsuarios();
    }
}
