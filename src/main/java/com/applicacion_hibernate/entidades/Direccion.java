package com.applicacion_hibernate.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "usuarios_direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private int identificador;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cod_postal")
    private int cod_postal;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "pais")
    private String pais;
    
    public Direccion() {
    }

    public Direccion(String direccion, String numero, int cod_postal, String provincia, String pais) {
        this.direccion = direccion;
        this.numero = numero;
        this.cod_postal = cod_postal;
        this.provincia = provincia;
        this.pais = pais;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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

    public int getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(int cod_postal) {
        this.cod_postal = cod_postal;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Direccion{");
        sb.append("identificador=").append(identificador);
        sb.append(", direccion=").append(direccion);
        sb.append(", numero=").append(numero);
        sb.append(", cod_postal=").append(cod_postal);
        sb.append(", provincia=").append(provincia);
        sb.append(", pais=").append(pais);
        sb.append('}');
        return sb.toString();
    }

}
