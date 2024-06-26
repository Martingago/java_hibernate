package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.config.HibernateUtil;
import com.applicacion_hibernate.entidades.Direccion;
import com.applicacion_hibernate.entidades.Usuario;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DireccionController {

    private final Model<Direccion> direccionModel = new Model<>(Direccion.class) {
    };
    private final Model<Usuario> usuarioModel = new Model<>(Usuario.class) {
    };

    public void listarDirecciones() {

        List<Direccion> direcciones = direccionModel.listar();
        for (Direccion direccion : direcciones) {
            System.out.println(direccion.toString());
        }

    }

    /**
     * Funcion que añade o actualiza la informacion de un usuario. Si el usuario
     * no contiene datos de direccion se crean datos de direccion asociados al
     * usuario Si el usuario ya tiene datos de direccion se sobreescribirán los
     * que existan
     *
     * @param idUsuario
     * @param direccion
     * @param numero
     * @param cod_postal
     * @param provincia
     * @param pais
     */
    public void addDireccionUsuario(int idUsuario, String direccion, String numero, int cod_postal, String provincia, String pais) {
        //Se crea un objeto direccion con la informacion introducida por el 
        Direccion direccionData = new Direccion(direccion, numero, cod_postal, provincia, pais);
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Obtener el usuario por su ID
            Usuario dataUsuario = session.get(Usuario.class, idUsuario);

            if (dataUsuario != null) {
                Direccion checkDireccion = dataUsuario.getDireccion(); // Acceder a la dirección (propiedad perezosa)

                if (checkDireccion != null) {
                    // Si el usuario ya tiene una dirección, actualizar los datos
                    System.out.println("Actualizando datos de dirección existente");
                    checkDireccion.setDireccion(direccion);
                    checkDireccion.setNumero(numero);
                    checkDireccion.setCodPostal(cod_postal);
                    checkDireccion.setProvincia(provincia);
                    checkDireccion.setPais(pais);
                    session.merge(checkDireccion); // Actualizar la dirección en la base de datos
                } else {
                    // Si el usuario no tiene dirección, crear una nueva dirección y asociarla
                    System.out.println("Creando nueva dirección para el usuario");
                    Direccion nuevaDireccion = new Direccion(direccion, numero, cod_postal, provincia, pais);
                    nuevaDireccion.setUsuario(dataUsuario); // Establecer la relación con el usuario
                    session.persist(nuevaDireccion); // Guardar la nueva dirección en la base de datos
                    dataUsuario.setDireccion(nuevaDireccion); // Actualizar la dirección en el usuario
                    session.merge(dataUsuario); // Actualizar el usuario en la base de datos
                }
                System.out.println("Dirección añadida o actualizada con éxito para el usuario con ID: " + idUsuario);
            } else {
                System.out.println("No se encontró un usuario con identificador: " + idUsuario);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error al añadir o actualizar la dirección: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Funcion que elimina la direccion de un usuario especificado
     *
     * @param idUsuario
     */
    public void deleteDireccionUsuario(int idUsuario) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Usuario dataUsuario = session.get(Usuario.class, idUsuario);
            System.out.println("datos usuario eliminar:" + dataUsuario.toString());

            if (dataUsuario != null) {
                Hibernate.initialize(dataUsuario.getDireccion());
                Direccion checkDireccion = dataUsuario.getDireccion();
                if (checkDireccion != null) {
                    dataUsuario.setDireccion(null); //Se desasocia la direccion del usuario
                    session.delete(checkDireccion);
                    System.out.println("Direccion eliminada con éxito");
                } else {
                    System.out.println("El usuario con id " + idUsuario + " no tiene asociada una direccion");
                }
            } else {
                System.out.println("No se ha encontrado un usuario con identificador: " + idUsuario);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("Error \n" + e);
        } finally {
            session.close();
        }
    }

}
