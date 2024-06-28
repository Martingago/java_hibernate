package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.entidades.Pedido;

import java.util.List;

public class PedidoController {

    private final Model<Pedido> pedidoModel = new Model<>(Pedido.class){};

    /**
     * Lista los pedidos existentes en la base de datos
     */
    public void listAllPedidos(){
        List<Pedido> pedidos = pedidoModel.listar();
        for(Pedido pedido : pedidos){
            System.out.println(pedido.toString());
        }

    }

    public void deletePedido(int identificador){
        pedidoModel.delete(identificador);
    }

}
