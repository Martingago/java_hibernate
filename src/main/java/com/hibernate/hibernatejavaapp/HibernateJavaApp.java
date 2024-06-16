package com.hibernate.hibernatejavaapp;

import com.hibernate.controller.UsuarioController;


public class HibernateJavaApp {

    public static void main(String[] args) {
        new UsuarioController().createUsuario("Martin", "12345", "chgnitram@gmail.com");
    }
}
