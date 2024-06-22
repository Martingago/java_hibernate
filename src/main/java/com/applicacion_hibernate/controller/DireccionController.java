package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.entidades.Direccion;
import com.applicacion_hibernate.entidades.Usuario;

public class DireccionController {

    private final Model<Direccion> direccionModel = new Model<>(Direccion.class) {
    };
    private final Model<Usuario> usuarioModel = new Model<>(Usuario.class) {
    };

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
                Direccion checkDireccion = dataUsuario.getDireccion(); //Comprueba si el usuario tiene una direccion añadida

                if (checkDireccion != null) {
                    //Si la direccion existe se actualizan los datos de la direccion del usuario:
                    checkDireccion.setDireccion(direccion);
                    checkDireccion.setNumero(numero);
                    checkDireccion.setCod_postal(cod_postal);
                    checkDireccion.setProvincia(provincia);
                    checkDireccion.setPais(pais);
                    direccionModel.update(checkDireccion.getIdentificador(), checkDireccion);

                } else {
                    Direccion newDireccion = new Direccion(direccion, numero, cod_postal, provincia, pais);
                    newDireccion.setUsuario(dataUsuario);
                    direccionModel.add(newDireccion);
                    //Actualiza las relaciones con el usuario
                    dataUsuario.setDireccion(newDireccion);
                    System.out.println("Direccion añadida con éxito");

                }

            } else {
                System.out.println("No se ha encontrado un usuario con identificador: " + idUsuario);
            }
        } catch (Exception e) {
            System.out.println("Error al añadir la direccion:" + e);
        }

    }

    public void deleteDireccionUsuario(int idUsuario) {
        try {
            Usuario dataUsuario = usuarioModel.get(idUsuario);
            if(dataUsuario != null){
                Direccion checkDireccion = dataUsuario.getDireccion();
                
                if(checkDireccion != null){
                    direccionModel.delete(checkDireccion.getIdentificador()); //Se elimina aquella direccion con el ID correspondiente
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
