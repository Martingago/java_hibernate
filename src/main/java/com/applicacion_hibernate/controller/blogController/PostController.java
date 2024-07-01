package com.applicacion_hibernate.controller.blogController;

import com.applicacion_hibernate.config.HibernateUtil;
import com.applicacion_hibernate.entidades.blog.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PostController {

    /**
     * Funcion que añade un post a nuestra Base de datos
     * @param post
     */
    public void addPost(Post post){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(post);
            tx.commit();
        }catch (Exception e){
            System.out.println("Error al realizar transaccion: \n" + e);
            if(tx !=null) tx.rollback();
        }
    }

    public Post getPost(int postId){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Post.class, postId);
        }
    }
}
