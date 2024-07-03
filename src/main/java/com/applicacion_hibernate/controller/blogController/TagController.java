package com.applicacion_hibernate.controller.blogController;

import com.applicacion_hibernate.config.HibernateUtil;
import com.applicacion_hibernate.entidades.blog.Post;
import com.applicacion_hibernate.entidades.blog.Tag;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class TagController {

    public Tag createTag(Tag tag){
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(tag);
        }catch (Exception e){
            tag = null;
            throw e;
        }
        return tag;
    }

    /**
     * Elimina un tag con un identificador específico
     * @param identificador
     * @return
     */
    public boolean deleteTag(int identificador){
        boolean eliminado = false;
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            Tag tag = session.find(Tag.class, identificador);
            if(tag != null){
                //Se eliminan las asociaciones con otros post:
                for(Post post : tag.getPosts()){
                    post.removeTag(tag);
                }

                session.remove(tag);
                tx.commit();
                System.out.println("Tag con identificador: " + identificador + " eliminado con éxito");
                eliminado = true;
            }else{
                System.out.println("Tag con identificador: " +  identificador + " no existe");
            }
        }catch (Exception e){
            if(tx != null) tx.rollback();
            System.out.println("Se ha producido un error al eliminar el tag especificado \n" + e);
            throw  e;
        }

        return eliminado;
    }

    public Set<Tag> getListAllTags(){
        Set<Tag> tags = new HashSet<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tags = new HashSet<>(session.createQuery("from Tag", Tag.class).list());
        }catch (Exception e){
            System.out.println("Se ha producido un error al listar las tags \n" + e);
        }
        return tags;
    }

}
