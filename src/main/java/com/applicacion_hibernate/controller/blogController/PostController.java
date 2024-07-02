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
            System.out.println("Post añadido con éxito");
        }catch (Exception e){
            System.out.println("Error al realizar transaccion: \n" + e);
            if(tx !=null) tx.rollback();
        }
    }

    /**
     * Elimina un post de la base de datos
     * @param identificador
     */
    public void deletePost(int identificador){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Post deletePost = session.get(Post.class, identificador);
            if(deletePost != null) session.remove(deletePost);
            tx.commit();
            System.out.println("Post eliminado con éxito");
        }catch (Exception e){
            System.out.println("Error al eliminar los datos \n " + e);
            if(tx != null) tx.rollback();
        }
    }

    /**
     * Actualiza la información de un post
     * @param identificador del post a modificar
     * @param postUpdated datos actualizados del post
     */
    public void updatePost(int identificador,Post postUpdated){
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            Post oldPost = session.get(Post.class, identificador);
            if(oldPost !=null){
                oldPost.setContent(postUpdated.getContent());
                oldPost.setTitle(postUpdated.getTitle());

                session.merge(oldPost);
                tx.commit();
            }
        }catch (Exception e){
            System.out.println("Se ha producido un error al actualizar el post \n" + e);
            if(tx != null) tx.rollback();
        }
    }

    public Post getPost(int postId){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Post.class, postId);
        }
    }
}
