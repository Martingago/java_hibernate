package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.config.HibernateUtil;
import com.applicacion_hibernate.entidades.Direccion;
import com.applicacion_hibernate.entidades.Pedido;
import com.applicacion_hibernate.entidades.Usuario;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.Date;
import java.util.List;
import java.util.Set;

public class UsuarioController {

    private final Model<Usuario> usuarioModel = new Model<>(Usuario.class) {
    };

    public void listarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioModel.listar();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al listar usuarios: " + e);
        }
    }

    public Usuario getUsuario(int identificador){
        return usuarioModel.get(identificador);
    }

    public Direccion getUsuarioDirecction(int identificador){
        Transaction tx = null;
        Session session = null;
        Direccion userDirecction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Usuario user = session.get(Usuario.class, identificador);
            userDirecction = user.getDireccion();
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
        }finally {
            if(session != null) session.close();
        }
        return userDirecction;
    }

    /**
     * Crea un usuario con los parámetros indicados en la Base de datos
     *
     * @param username
     * @param password
     * @param email
     */
    public Usuario createUsuario(String username, String password, String email) {
        Usuario newUsuario = new Usuario(username, password, email, new Date(), new Date());
        usuarioModel.add(newUsuario);
        return newUsuario;
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
     *                      usuario concreto
     */
    public void deleteUsuario(int identificador) {
        usuarioModel.delete(identificador);
    }

    /**
     * Funcion que lista los pedidos que ha realizado un usuario
     *
     * @param identificador
     */
    public void listarPedidosUsuario(int identificador) {
        Transaction tx = null;
        Session session = null;
        try {
            //Se inicia la session y la transaction
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            //Se buscan los datos del usuario
            Usuario usuario = session.get(Usuario.class, identificador);
            if (usuario != null) {
                //Se realiza una transaccion para obtener los datos del pedido
                Set<Pedido> pedidos = usuario.getPedido();
                if (pedidos != null && !pedidos.isEmpty()) {
                    //Se cargan los pedidos que realiza un usuario:
                    for (Pedido pedido : pedidos) {
                        System.out.println(pedido.toString());
                    }
                } else {
                    System.out.println("Este usuario aun no ha realizado pedidos");
                }
            }else{
                System.out.println("Este usuario no existe");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null){
                tx.rollback();
            }
        } finally {
            if(session != null){
                session.close();
            }
        }

    }
}


