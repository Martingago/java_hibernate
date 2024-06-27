package com.applicacion_hibernate.main;

import com.applicacion_hibernate.controller.DireccionController;
import com.applicacion_hibernate.controller.MarcaController;
import com.applicacion_hibernate.controller.ProductoController;
import com.applicacion_hibernate.controller.UsuarioController;
import com.applicacion_hibernate.entidades.Marca;
import com.applicacion_hibernate.entidades.Producto;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.Date;


public class HibernateJavaApp {

    public static void main(String[] args) {
        UsuarioController uc = new UsuarioController();
        DireccionController dc = new DireccionController();
        MarcaController mc = new MarcaController();
        ProductoController pc = new ProductoController();

        //uc.createUsuario("Manuel", "fhfdgsgdg", "example@gmail.com");
        //uc.createUsuario("Maria", "sdeoqopqdnffsf", "example02@gmail.com");

        //dc.addDireccionUsuario(3, "Calle Santiago", "10A", 12506, "A coruña", "España");
        //dc.addDireccionUsuario(4, "Calle Senrra", "12A", 12506, "A coruña", "España");

        //dc.listarDirecciones();
        //Marca newMarca = mc.addMarca("inventada", "Nueva marca añadida inventada");
        //new MarcaController().deleteMarca(newMarca.getId());
        //new MarcaController().updateMarca(newMarca.getId(), new Marca("Cambio cosasss", "Cambio desscripcion"));
        
        //mc.listarMarcas();
        //new DireccionController().deleteDireccionUsuario(2);
        //new DireccionController().addDireccionUsuario(2, "Cambio de la direccion 2", "545", 0, "editada", "inentado");

        //mc.deleteMarca(4);
        //pc.listarProductos();
        //pc.addProduct("Nuevo producto", "Descripcion de mi producto añadido", 154.23, 23, 3);
        //pc.addProduct("Nuevo producto", "Descripcion de mi producto añadido", 154.23, 23, 3);
        //pc.addProduct("Nuevo producto", "Descripcion de mi producto añadido", 154.23, 23, 3);
        //pc.updateProductInfo(15, "Nombre actualizado actualizado", "decripcion actualizada", 1999.9, 23, 2);
        pc.listFullProductInfo();
        

        //new UsuarioController().listarUsuarios();
    }
}
