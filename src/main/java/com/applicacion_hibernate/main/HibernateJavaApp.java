package com.applicacion_hibernate.main;


import com.applicacion_hibernate.controller.blogController.PublicacionController;
import com.applicacion_hibernate.controller.blogController.PostController;
import com.applicacion_hibernate.controller.blogController.TagController;
import com.applicacion_hibernate.dto.Publicacion;
import com.applicacion_hibernate.entidades.blog.Post;


public class HibernateJavaApp {

    public static void main(String[] args) {

        PostController pc = new PostController();
        TagController tg = new TagController();
        PublicacionController bc = new PublicacionController();
//        tg.createTag(new Tag("Tecnología"));
//        tg.createTag(new Tag("Ciencia"));
//        tg.createTag(new Tag("Actualidad"));
//        tg.createTag(new Tag("Política"));
//        tg.createTag(new Tag("Programación"));


        //pc.addPost(new Post("Hola", "caracola"));

        //pc.deletePost(1);
        //pc.deletePost(2);
//        Set<Integer> tagsToAdd = new HashSet<>(Arrays.asList(3, 2, 1));
//        int idBlog = bc.crearPublicacion("Como crear buen contenido en línea", "Marketing",
//                "Este es el contenido de la publicacion de crear publicaciones de calidad", tagsToAdd);

        Publicacion publicacion = bc.getPublicacion(3);
        bc.imprimirDatosPublicacion(publicacion);
        Publicacion publicacion1 = bc.getPublicacion(4);
        bc.imprimirDatosPublicacion(publicacion1);

    }
}
