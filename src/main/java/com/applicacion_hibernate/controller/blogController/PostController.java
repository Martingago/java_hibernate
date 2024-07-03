package com.applicacion_hibernate.controller.blogController;

import com.applicacion_hibernate.config.HibernateUtil;
import com.applicacion_hibernate.entidades.blog.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.ast.tree.predicate.BooleanExpressionPredicate;

public class PostController {

    /**
     * Funcion que añade un post a nuestra Base de datos
     * @param post
     */
    public Post addPost(Post post){
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
        return post;
    }

    /**
     * Funcion que añade un post desde una session manejada en el exterior
     * @param session general que maneja una serie de inserciones atomicas
     * @param post
     * @return
     */
    public Post addPost(Session session, Post post){
        try {
            session.persist(post);
        }catch (Exception e){
            System.out.println("Error al añadir un post \n" + e);
            throw e;
        }
        return post;
    }

    /**
     * Elimina un post de la base de datos
     * @param identificador
     * @return boolean si se ha eliminado o no un post
     */
    public boolean deletePost(int identificador){
        Transaction tx = null;
        boolean eliminado = false;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Post deletePost = session.get(Post.class, identificador);
            if(deletePost != null) session.remove(deletePost);
            tx.commit();
            System.out.println("Post eliminado con éxito");
            eliminado = true;
        }catch (Exception e){
            System.out.println("Error al eliminar los datos \n " + e);
            if(tx != null) tx.rollback();
        }
        return  eliminado;
    }

    /**
     * Actualiza la información de un post
     * @param identificador del post a modificar
     * @param postUpdated datos actualizados del post
     */
    public Post updatePost(int identificador,Post postUpdated){
        Transaction tx = null;
        Post oldPost = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            oldPost = session.get(Post.class, identificador);
            if(oldPost !=null){
                oldPost.setContent(postUpdated.getContent());
                oldPost.setTitle(postUpdated.getTitle());

                session.merge(oldPost);
                tx.commit();
            }else{
                System.out.println("El post que se pretende modificar no existe");
            }
        }catch (Exception e){
            System.out.println("Se ha producido un error al actualizar el post \n" + e);
            if(tx != null) tx.rollback();
        }
        return oldPost;
    }

    /**
     * Obtiene los datos de un post pasado como parámetro
     * @param identificador
     * @return datos obtenidos del post en la base de datos
     */
    public Post getPost(int identificador){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Post.class, identificador);
        }
    }
}
