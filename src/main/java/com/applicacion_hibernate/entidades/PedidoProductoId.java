package com.applicacion_hibernate.entidades;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PedidoProductoId implements Serializable {
    private int idPedido;
    private int idProducto;

    public PedidoProductoId() {
    }

    public PedidoProductoId(int idPedido, int idProducto) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoProductoId that = (PedidoProductoId) o;
        return idPedido == that.idPedido && idProducto == that.idProducto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idProducto);
    }


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
