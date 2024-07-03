package com.applicacion_hibernate.main;


import com.applicacion_hibernate.controller.blogController.BlogController;
import com.applicacion_hibernate.controller.blogController.PostController;
import com.applicacion_hibernate.controller.blogController.TagController;

import com.applicacion_hibernate.entidades.blog.Tag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class HibernateJavaApp {

    public static void main(String[] args) {

        PostController pc = new PostController();
        TagController tg = new TagController();
        BlogController bc = new BlogController();
//        tg.createTag(new Tag("Tecnología"));
//        tg.createTag(new Tag("Ciencia"));
//        tg.createTag(new Tag("Actualidad"));
//        tg.createTag(new Tag("Programación"));


//        Set<Integer> tagsToAdd = new HashSet<>(Arrays.asList(3, 2));
//        int idBlog = bc.crearPublicacion("Como crear buen contenido en línea", "Marketing",
//                "Este es el contenido de la publicacion de crear publicaciones de calidad", tagsToAdd);

        bc.getPublicacion(7);
    }
}
