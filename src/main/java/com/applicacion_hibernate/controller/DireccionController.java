package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.entidades.Direccion;
import com.applicacion_hibernate.entidades.Usuario;

public class DireccionController {
    
    private final Model<Direccion> DireccionModel = new Model<>(Direccion.class){};
    private final Model<Usuario> UsuarioModel = new Model<>(Usuario.class){};
    
    public void addDireccionUsuario(int idUsuario, String direccion, String numero, int cod_postal, String provincia, String pais){
        try {
            Usuario dataUsuario = UsuarioModel.get(idUsuario);
            if(dataUsuario != null){
                Direccion newDireccion = new Direccion(direccion, numero, cod_postal, provincia, pais);
                newDireccion.setUsuario(dataUsuario);
                DireccionModel.add(newDireccion);
                
                //Actualiza las relaciones con el usuario
                dataUsuario.setDireccion(newDireccion);
                System.out.println("Direccion añadida con éxito");
            }else{
                System.out.println("No se ha encontrado un usuario con identificador: "+ idUsuario);
            }
        } catch (Exception e) {
            System.out.println("Error al añadir la direccion:" + e);
        }
        
    }
    
}
