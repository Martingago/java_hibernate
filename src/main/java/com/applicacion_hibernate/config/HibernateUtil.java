package com.applicacion_hibernate.config;

import com.applicacion_hibernate.entidades.*;

import java.util.List;

import com.applicacion_hibernate.entidades.blog.Post;
import com.applicacion_hibernate.entidades.blog.Tag;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {


    private final static List<Class<?>> listaClases = List.of(Usuario.class, Direccion.class, Marca.class,
            Producto.class, Pedido.class, PedidoProducto.class, Post.class, Tag.class);

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


            //Se añaden todas los modelos <mapping> existentes en la aplicación
            for (Class<?> map : listaClases) {
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
