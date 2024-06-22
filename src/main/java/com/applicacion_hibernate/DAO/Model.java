package com.applicacion_hibernate.DAO;

import com.applicacion_hibernate.config.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public abstract class Model<T> {

    //https://www.youtube.com/watch?v=9Z0Os9w_VMY
    /**
     * Constructor que recibe como parametro la entidad a la que debe aludir en
     * la Base de datos para realizar las operaciones CRUD
     */
    private final Class<T> entityClass;

    public Model(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Funcion que devuelve una lista con los elementos de una Base de datos
     *
     * @return
     */
    public List<T> listar() {
        List<T> entidades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from " + entityClass.getSimpleName();
            Query q = session.createQuery(hql);
            entidades = q.list();
        } catch (Exception e) {
            System.out.println("Error al listar las entidades \n" + e);
        } finally {
            session.close();
        }

        return entidades;
    }

    /**
     * Obtiene los datos de una entidad en especifico de la base de datos
     *
     * @param identificador de la entidad a buscar
     * @return identidad encontrada en la base de datos.
     */
    public T get(int identificador) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        T entidad = null;
        try {
            transaction = session.beginTransaction();
            //Buscar entidad por identificador:
            entidad = session.get(entityClass, identificador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Se ha producido un error al cargar los datos");
            if (transaction != null) {
                transaction.rollback(); //Se cancela la transaction
            }
        } finally {
            session.close();
        }
        return entidad;
    }

    /**
     * Funcion que añade un modelo a una BBDD
     *
     * @param entidad
     */
    public void add(T entidad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(entidad);
            session.getTransaction().commit();
            System.out.println("Datos añadidos con éxito");
        } catch (Exception e) {
            System.out.println("Error al añadir datos: " + e);
            if (transaction != null) {
                //Si se produce un error al insertar datos se realiza un rollback
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    /**
     * Elimina de la base de datos una entidad con un identificador especificado
     * @param identificador de la entidad a eliminar
     */
    public void delete(int identificador) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            T entidad = session.get(entityClass, identificador);
            if (entidad != null) {
                session.delete(entidad);
                session.getTransaction().commit();
                System.out.println("Datos eliminados con éxito");
            } else {
                System.out.println("No se encontró la entidad con el identificador: " + identificador);
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar datos: " + e);
        } finally {
            session.close();
        }
    }

    /**
     * Funcion que actualiza un modelo de una BBDD
     *
     * @param entidad
     */
    public void update(int identificador, T updatedEntidad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            T oldEntidad = session.get(entityClass, identificador);
            if (oldEntidad != null) {
                //Actualiza la entidad con los nuevos valores que recibe como parametro
                session.merge(updatedEntidad);
                transaction.commit();
                System.out.println("Datos actualizados con éxito");
            } else {
                System.out.println("No se ha encontrado una entidad con identificador: " + identificador);
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar los datos: " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

}
