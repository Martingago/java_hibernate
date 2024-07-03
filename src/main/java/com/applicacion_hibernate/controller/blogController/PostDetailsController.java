package com.applicacion_hibernate.controller.blogController;

import com.applicacion_hibernate.config.HibernateUtil;
import com.applicacion_hibernate.entidades.blog.Post;
import com.applicacion_hibernate.entidades.blog.PostDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PostDetailsController {


    public PostDetails addPostDetails(int identificador, PostDetails postDetails){
        Transaction tx = null;
        Post post = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            post = session.find(Post.class, identificador);
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
            postDetails = null;
        }
        return postDetails;
    }

    /**
     * Funcion que añade los postDetails desde una session manejada desde el exterior
     * @param session
     * @param post
     * @param postDetails
     * @return
     */
    public PostDetails addPostDetails(Session session, Post post, PostDetails postDetails){
        try {
            postDetails.setPost(post);
            session.persist(postDetails);
        }catch (Exception e){
            System.out.println("Error al añadir los post details \n" + e);
            throw  e;
        }
        return postDetails;
    }

    public void removePostDetails(int identificador){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            PostDetails postDetails = session.find(PostDetails.class, identificador);
            if(postDetails != null){
                session.remove(postDetails);
                tx.commit();
                System.out.println("Detalles del post eliminados con éxito");
            }else{
                System.out.println("El post indicado no tiene detalles de post");
            }
        }catch (Exception e){
            System.out.println("Error al eliminar un post: \n" + e);
            if(tx != null) tx.rollback();
        }
    }

    /**
     * Obtiene los detalles de un post especificado
     * @param identificador
     * @return datos del post
     */
    public PostDetails getPostDetails(int identificador){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
           return session.find(PostDetails.class, identificador);
        }
    }

}
