package com.applicacion_hibernate.main;


import com.applicacion_hibernate.controller.blogController.BlogController;
import com.applicacion_hibernate.controller.blogController.TagController;

import com.applicacion_hibernate.entidades.blog.Tag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class HibernateJavaApp {

    public static void main(String[] args) {


        TagController tg = new TagController();




        BlogController bc = new BlogController();
        Set<Tag> tagsToAdd = tg.seleccionarTags(tg.getListAllTags(), new HashSet<>(Arrays.asList("Tecnología", "Ciencia")));
        int idBlog = bc.crearPublicacion("Teorema del mono infinito", "Ciencia y tencología", "¿Has oido hablar alguna vez del teorema del mono infinito?", tagsToAdd);

        bc.getPublicacion(idBlog);
    }
}
