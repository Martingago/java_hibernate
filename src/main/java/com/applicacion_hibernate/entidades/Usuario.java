package com.applicacion_hibernate.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;
    
    @Column(name = "user_name")
    private String username;
    
    @Column(name = "user_password")
    private String password;
    
    @Column(name = "user_email")
    private String email;
    
    @Column(name = "user_date_creation")
    private Date fecha_creacion;
    
    @Column(name = "user_last_connection")
    private Date ultima_sesion;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

    public Usuario(String username, String password, String email, Date fecha_creacion, Date ultima_sesion) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fecha_creacion = fecha_creacion;
        this.ultima_sesion = ultima_sesion;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

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

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getUltima_sesion() {
        return ultima_sesion;
    }

    public void setUltima_sesion(Date ultima_sesion) {
        this.ultima_sesion = ultima_sesion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", fecha_creacion=" + fecha_creacion + ", ultima_sesion=" + ultima_sesion + ", direccion=" + direccion + '}';
    }



}
