package com.applicacion_hibernate.config;

import com.applicacion_hibernate.entidades.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private final static SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Función de configuracion que crea un objeto SessionFactory de la
     * aplicación
     *
     * @return
     */
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            List<Class<?>> annotatedClass = List.of(Usuario.class);

            //Se añaden todas los modelos <mapping> existentes en la aplicación
            for (Class<?> map : annotatedClass) {
                configuration.addAnnotatedClass(map);
            }

            return configuration.buildSessionFactory();

        } catch (HibernateException e) {
            System.out.println("Error al crear la configuración de la aplicación");
            e.printStackTrace();
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
