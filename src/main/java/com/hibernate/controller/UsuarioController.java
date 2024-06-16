package com.hibernate.controller;

import com.hibernate.model.Usuario;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsuarioController {

    public void createUsuario(String username, String password, String email) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Usuario newUsuario = new Usuario(username, password, email, new Date(), new Date());
            //Abre transaccion
            session.beginTransaction();
            //Se insertan valores
            session.save(newUsuario);
            //Guarda transaccion
            session.getTransaction().commit();
            session.close();
            System.out.println("Usuario creado");
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
