package com.applicacion_hibernate.entidades;

import com.applicacion_hibernate.DAO.IdentificadorInterface;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pedidos")
public class Pedido  implements IdentificadorInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private int id;

    @Column(name="fecha_pedido")
    private Date fecha_pedido;

    @Column(name="fecha_entrega")
    private Date fecha_entrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<PedidoProducto> pedidosProductos = new HashSet<>();

    public Pedido(Date fecha_pedido, Date fecha_entrega, Usuario usuario) {
        this.fecha_pedido = fecha_pedido;
        this.fecha_entrega = fecha_entrega;
        this.usuario = usuario;
    }

    public Pedido() {
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<PedidoProducto> getPedidosProductos() {
        return pedidosProductos;
    }

    public void setPedidosProductos(Set<PedidoProducto> pedidosProductos) {
        this.pedidosProductos = pedidosProductos;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha_pedido=" + fecha_pedido +
                ", fecha_entrega=" + fecha_entrega +
                '}';
    }
}
