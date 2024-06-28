package com.applicacion_hibernate.entidades;

import com.applicacion_hibernate.DAO.IdentificadorInterface;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "usuarios")
public class Usuario implements IdentificadorInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "date_creation")
    private Date fechaCreacion;

    @Column(name = "last_connection")
    private Date ultimaSesion;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Direccion direccion;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String username, String password, String email, Date fechaCreacion, Date ultimaSesion) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
        this.ultimaSesion = ultimaSesion;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getUltimaSesion() {
        return ultimaSesion;
    }

    public void setUltimaSesion(Date ultimaSesion) {
        this.ultimaSesion = ultimaSesion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<Pedido> getPedido() {
        return pedidos;
    }

    public void setPedido(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", ultimaSesion=" + ultimaSesion +
                '}';
    }
}
