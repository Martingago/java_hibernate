package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.config.HibernateUtil;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

public class UsuarioController {

    private final Model<Usuario> usuarioModel = new Model<>(Usuario.class) {
    };

    public void listarUsuarios() {
        List<Usuario> usuarios = usuarioModel.listar();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }

    }

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Usuario oldUsuario = session.get(Usuario.class, identificador);

            if (oldUsuario != null) {
                updateUsuario.setId(identificador);
                session.merge(updateUsuario);
                session.getTransaction().commit();
                System.out.println("Usuario actualizado correctamente");
            } else {
                System.out.println("No se ha encontrado un usuario con el ID " + identificador + "especificado");
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario: \n" + e);
        } finally {
            session.close();
        }
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
