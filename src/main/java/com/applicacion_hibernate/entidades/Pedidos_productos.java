package com.applicacion_hibernate.entidades;

import com.applicacion_hibernate.DAO.IdentificadorInterface;
import jakarta.persistence.*;

@Entity
@Table(name= "pedidos_productos")
public class Pedidos_productos implements IdentificadorInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private int id;

    @Column(name="cantidad")
    private int cantidad;

    @Column(name="precio")
    private double precio;

    @Column(name="subtotal")
    private double subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_producto")
    private Producto producto;

    public Pedidos_productos(int id, int cantidad, double subtotal, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.precio = precio;
    }

    public Pedidos_productos() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
    this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Pedidos_productos{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", subtotal=" + subtotal +
                '}';
    }
}
