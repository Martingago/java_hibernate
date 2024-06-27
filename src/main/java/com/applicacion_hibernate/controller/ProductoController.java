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
     * Lista  de forma simple los productos existentes en la base de datos
     */
    public void listarProductos(){
        List<Producto> productos = productoModel.listar();

        for(Producto producto : productos){
            System.out.println(producto.toString());
        }
    }

    /**
     * Lista de forma completa los productos y detalles especificos (Marca) procedentes de la base de datos
     */
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

    /**
     * Actualiza los datos de un producto con un identificador especificado
     * @param identificador
     * @param nombre
     * @param descripcion
     * @param precio
     * @param stock
     * @param id_marca
     */
    public void updateProductInfo(int identificador, String nombre, String descripcion, double precio, int stock, int id_marca){
        Transaction tx = null;
        Session session = null;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            //Se obtiene los datos del produto a través de su id:
            Producto oldP = session.get(Producto.class, identificador);
            if(oldP == null){
                System.out.println("No se ha encontrado un producto con identificador: "+ identificador);
                return;
            }
            //Se busca el identificador de la marca para ver si la nueva marca existe:
            Marca oldM = session.get(Marca.class, id_marca);
            if(oldM == null){
                System.out.println("No se ha encontrado una marca con el identificador: " + id_marca);
                return;
            }

            //Se actualizan los datos del producto:
            oldP.setNombre(nombre);
            oldP.setPrecio(precio);
            oldP.setStock(stock);
            oldP.setDescripcion(descripcion);
            oldP.setMarca(oldM);

            //Se actualizan y guarda la transaccion
            session.merge(oldP);
            tx.commit();

        }catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("Se ha producido un error inesperado: " + e);

        }finally {
        if(session != null){
            session.close();
        }
        }
    }

    /**
     * Elimina un producto de la base de datos
     * @param identificador
     */
    public void deleteProduct(int identificador){
        productoModel.delete(identificador);
    }

}
