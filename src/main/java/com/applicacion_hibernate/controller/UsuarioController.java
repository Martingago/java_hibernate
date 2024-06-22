package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.Date;
import java.util.List;

public class UsuarioController {

    private final Model<Usuario> usuarioModel = new Model<>(Usuario.class) {
    };

    /**
     * Hace un listado de todos los usuarios existentes en la Base de datos
     */
    public void listarUsuarios() {
        List<Usuario> usuarios = usuarioModel.listar();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }

    }

    /**
     * Crea un usuario con los parámetros indicados en la Base de datos
     * @param username
     * @param password
     * @param email 
     */
    public void createUsuario(String username, String password, String email) {
        Usuario newUsuario = new Usuario(username, password, email, new Date(), new Date());
        usuarioModel.add(newUsuario);
    }
    
    /**
     * Actualiza los datos de un usurio especificado
     *
     * @param identificador del usuario a actualizar
     * @param updateUsuario información actualizada del usuario
     */
    public void updateUsuario(int identificador, Usuario updateUsuario) {
        usuarioModel.update(identificador, updateUsuario);
    }

    /**
     * Recibe como parametro un identificador a eliminar
     *
     * @param identificador Función que elimina de la tabla "usuarios" un
     * usuario concreto
     */
    public void deleteUsuario(int identificador) {
        usuarioModel.delete(identificador);
    }

}
