package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.config.HibernateUtil;
import com.applicacion_hibernate.entidades.Marca;
import com.applicacion_hibernate.entidades.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductoController {

    private final Model<Producto> productoModel = new Model<>(Producto.class){};

    /**
     * Lista los productos existentes en la base de datos
     */
    public void listarProductos(){
        List<Producto> productos = productoModel.listar();

        for(Producto producto : productos){
            System.out.println(producto.toString());
        }
    }

    public void listFullProductInfo(){
        String hql = "SELECT p FROM Producto p JOIN FETCH p.marca";

        for(Producto p : productoModel.joinList(hql)){
            System.out.println(p + " " + p.getMarca());
        }
    }

    /**
     * Funcion que añade un producto a la base de datos MySQL
     * @param nombre
     * @param descripcion
     * @param precio
     * @param stock
     * @param id_marca
     */
    public void addProduct(String nombre, String descripcion, double precio, int stock, int id_marca){
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession(); //Se abre sesion
            tx = session.beginTransaction();

            //Se busca marca por id:
            Marca marca = session.get(Marca.class, id_marca);
            if(marca == null){
                System.out.println("Error, la marca indicada no ha sido encontrada");
                return;
            }
            Producto p = new Producto(nombre, descripcion, precio, stock);
            p.setMarca(marca); //Se establece al producto la marca
            session.persist(p); //Se guardan los datos
            tx.commit();
            System.out.println("Datos del producto añadidos con éxito");

        }catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("Se ha producido un erro inesperado al añadir un producto" + e);
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

}
