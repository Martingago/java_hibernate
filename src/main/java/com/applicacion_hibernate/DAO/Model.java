package com.applicacion_hibernate.DAO;

import com.applicacion_hibernate.config.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public abstract class Model<T> {

//https://www.youtube.com/watch?v=9Z0Os9w_VMY

    private String nombreModelo;

    public List<T> listar() {
        List<T> entidades = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from " + getNombreModelo();
            Query q = session.createQuery(hql);
            entidades = q.list();
        } catch (Exception e) {
            System.out.println("Error al listar las entidades \n" + e);
        } finally {
            session.close();
        }

        return entidades;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

}
