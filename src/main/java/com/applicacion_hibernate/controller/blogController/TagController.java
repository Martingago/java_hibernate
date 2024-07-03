package com.applicacion_hibernate.controller.blogController;

import com.applicacion_hibernate.config.HibernateUtil;
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

    /**
     * Recibe como parámetro un listado de tags existente en la Base de datos y una lista de nombres
     * @param allTags
     * @param objetiveTags
     * @return lista de tags que coinciden con las tags pasadas como cadena
     */
    public Set<Tag> seleccionarTags(Set<Tag> allTags, Set<String>objetiveTags ){
        Set<Tag> tagsSeleccionadas = new HashSet<>();
        for (Tag tag : allTags){
            if(objetiveTags.contains(tag.getName())){
                tagsSeleccionadas.add(tag);
            }
        }
        return tagsSeleccionadas;
    }
}
