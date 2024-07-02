package com.applicacion_hibernate.controller.blogController;

import com.applicacion_hibernate.config.HibernateUtil;
import com.applicacion_hibernate.entidades.blog.Post;
import com.applicacion_hibernate.entidades.blog.PostDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PostDetailsController {


    public void addPostDetails(Post post, PostDetails postDetails){
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            if(post != null){
                postDetails.setPost(post); //Se asocia el post creado a los postDetails a añadir
                session.persist(postDetails); //Se añaden los post details
                tx.commit();
                System.out.println("Detalles del post añadidos con éxito");
            }else{
                System.out.println("No se ha podido añadir los postDetails ya que Post es null");
            }
        }catch (Exception e){
            if(tx != null) tx.rollback();
            System.out.println("Se ha producido un error al añadir los detalles del post: \n" + e);
        }
    }
}
