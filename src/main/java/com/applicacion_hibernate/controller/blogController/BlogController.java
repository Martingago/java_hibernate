package com.applicacion_hibernate.controller.blogController;

import com.applicacion_hibernate.config.HibernateUtil;
import com.applicacion_hibernate.entidades.blog.Post;
import com.applicacion_hibernate.entidades.blog.PostDetails;
import com.applicacion_hibernate.entidades.blog.Tag;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class BlogController {
    PostController pc = new PostController();
    PostDetailsController pdc = new PostDetailsController();


    /**
     * Funcion que crea una publicacion en la base de datos
     * @param titulo
     * @param topic
     * @param contenido
     * @return
     */
    public int crearPublicacion(String titulo, String topic, String contenido, Set<Integer> IdTags) {
        //Se crea una transacction y una session:
        Transaction tx = null;
        int postId = -1;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Post post = pc.addPost(session, new Post(titulo, contenido)); //Se crea el post

            //Se realiza una búsqueda en la tabla de tags y se añaden al post
            if(!IdTags.isEmpty()){
                List<Tag> persistedTags = session.createQuery("FROM Tag WHERE id IN (:IdTags)", Tag.class)
                        .setParameter("IdTags", IdTags).list();

                //Se añaden las tags al post:
                for(Tag persistedtag : persistedTags){
                    post.addTag(persistedtag);
                }
            }

            pdc.addPostDetails(session, post, new PostDetails(topic, new Date())); //Se crea post details
            postId = post.getId();
            tx.commit();
            System.out.println("Se ha creado una publicación con id: " + postId);
        } catch (Exception e) {
            System.out.println("Se ha producido un error durante la creación de una publicación: \n" + e);
            if (tx != null) tx.rollback();
        }
        return postId;
    }

    /**
     * Obtiene la información de una publicación completa
     * @param identificador
     */
    public void getPublicacion(int identificador){
        Post post = pc.getPost(identificador);
        PostDetails details = pdc.getPostDetails(identificador);
        if(post != null && details != null)
        System.out.println("Detalles de la publicacion: \n" + post.toString() + "\n" + details.toString());
        else{
            System.out.println("No se encontraron datos para una publicacion con id: "+ identificador);
        }
    }

}
