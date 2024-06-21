package com.applicacion_hibernate.DAO;

import com.applicacion_hibernate.config.HibernateUtil;
import java.lang.reflect.Field;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public abstract class Model<T> {

    //https://www.youtube.com/watch?v=9Z0Os9w_VMY
    /**
     * Constructor que recibe como parametro la entidad a la que debe aludir en la Base de datos para realizar las operaciones CRUD
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
            if(transaction != null){
                //Si se produce un error al insertar datos se realiza un rollback
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

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
     * Funcion que añade un modelo a una BBDD
     *
     * @param entidad
     */
    public void update(int identificador, T updatedEntidad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            T oldEntidad = session.get(entityClass, identificador);
            if (oldEntidad != null) {
                Field idField = entityClass.getDeclaredField("identificador");
                idField.setAccessible(true);

            }

            session.merge(updatedEntidad);
            session.getTransaction().commit();
            System.out.println("Datos añadidos con éxito");
        } catch (Exception e) {
            System.out.println("Error al añadir datos: " + e);
        } finally {
            session.close();
        }
    }

}
