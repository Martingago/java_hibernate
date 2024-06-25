package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.entidades.Direccion;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.List;

public class DireccionController {

    private final Model<Direccion> direccionModel = new Model<>(Direccion.class) {
    };
    private final Model<Usuario> usuarioModel = new Model<>(Usuario.class) {
    };

    
  public void listarDirecciones() {
   
        List<Direccion> direcciones= direccionModel.listar();
        for (Direccion direccion : direcciones) {
            System.out.println(direccion.toString());
        }
   
}  
    
    /**
     * Funcion que añade o actualiza la informacion de un usuario.
     * Si el usuario no contiene datos de direccion se crean datos de direccion asociados al usuario
     * Si el usuario ya tiene datos de direccion se sobreescribirán los que existan
     * @param idUsuario
     * @param direccion
     * @param numero
     * @param cod_postal
     * @param provincia
     * @param pais 
     */
 public void addDireccionUsuario(int idUsuario, String direccion, String numero, int cod_postal, String provincia, String pais) {
    try {
        Usuario dataUsuario = usuarioModel.get(idUsuario);
        if (dataUsuario != null) {
            Direccion checkDireccion = dataUsuario.getDireccion(); // Comprueba si el usuario tiene una dirección asociada

            if (checkDireccion != null) {
                System.out.println("Actualizando datos de dirección existente");

                // Actualiza los datos de la dirección existente
                checkDireccion.setDireccion(direccion);
                checkDireccion.setNumero(numero);
                checkDireccion.setCodPostal(cod_postal);
                checkDireccion.setProvincia(provincia);
                checkDireccion.setPais(pais);

                direccionModel.update(checkDireccion.getId(), checkDireccion);
            } else {
                System.out.println("Creando nueva dirección para el usuario");

                // Crea una nueva dirección
                Direccion newDireccion = new Direccion(direccion, numero, cod_postal, provincia, pais);
                newDireccion.setUsuario(dataUsuario); // Establece la referencia al usuario

                // Guarda la nueva dirección en la base de datos
                direccionModel.add(newDireccion); // Suponiendo que "add" inserta la dirección en la base de datos

                System.out.println("Dirección añadida con éxito al usuario");
            }
        } else {
            System.out.println("No se ha encontrado un usuario con identificador: " + idUsuario);
        }
    } catch (Exception e) {
        System.out.println("Error al añadir la dirección: " + e);
    }
}


    public void deleteDireccionUsuario(int idUsuario) {
        try {
            Usuario dataUsuario = usuarioModel.get(idUsuario);
            if(dataUsuario != null){
                Direccion checkDireccion = dataUsuario.getDireccion();
                
                if(checkDireccion != null){
                    direccionModel.delete(checkDireccion.getId()); //Se elimina aquella direccion con el ID correspondiente
                }else{
                    System.out.println("El usuario con id " + idUsuario + " no tiene asociada una direccion");
                }
            }else{
                System.out.println("No se ha encontrado un usuario con identificador: " + idUsuario);
            }
        } catch (Exception e) {
        }
    }

}
