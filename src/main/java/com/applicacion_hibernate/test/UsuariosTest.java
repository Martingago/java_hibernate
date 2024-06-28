package com.applicacion_hibernate.test;

import com.applicacion_hibernate.controller.UsuarioController;
import com.applicacion_hibernate.entidades.Usuario;

import java.util.Date;

public class UsuariosTest {

    UsuarioController uc = new UsuarioController();

    public void manageUsuarioFunctions(){
//        System.out.println("Añadir usuario:");
//        Usuario newUser01 = uc.createUsuario("Usuario prueba 2", "lalslalsas", "emailTest@mail.com");
//        Usuario newUser = uc.createUsuario("Usuario prueba", "pasword2324", "emailTest@mail.com");
//        System.out.println("Editar usuario:");
//        Usuario editUser = uc.getUsuario(newUser.getId());
//
//        editUser.setEmail("EmailEditado@gmail.com");
//        editUser.setPassword("123355");
//
//        uc.updateUsuario(newUser.getId(), editUser);
//
//        uc.listarUsuarios();
//        System.out.println("Eliminar usuario:");
//        uc.deleteUsuario(editUser.getId());
//        System.out.println("Listar usuarios: ");
        uc.listarUsuarios();

        //System.out.println(uc.getUsuarioDirecction(4));




    }
}
