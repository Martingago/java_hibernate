package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.Date;
import java.util.List;

public class UsuarioController {

    private final Model<Usuario> usuarioModel = new Model<>(Usuario.class) {
    };

    public void listarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioModel.getAll();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al listar usuarios: " + e);
        }
    }

    /**
     * Crea un usuario con los parámetros indicados en la Base de datos
     *
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
