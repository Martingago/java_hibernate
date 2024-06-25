package com.applicacion_hibernate.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "usuarios_direccion")
public class Direccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cod_postal")
    private int codPostal;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "pais")
    private String pais;

    public Direccion() {
    }

    public Direccion(String direccion, String numero, int codPostal, String provincia, String pais) {
        this.direccion = direccion;
        this.numero = numero;
        this.codPostal = codPostal;
        this.provincia = provincia;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", numero='" + numero + '\'' +
                ", codPostal=" + codPostal +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
