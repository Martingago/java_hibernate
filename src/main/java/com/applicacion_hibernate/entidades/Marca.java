package com.applicacion_hibernate.entidades;

import com.applicacion_hibernate.DAO.IdentificadorInterface;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "marcas")
public class Marca implements IdentificadorInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "marca" , fetch = FetchType.LAZY, cascade = CascadeType.ALL) // Indicamos que la relación está mapeada por el atributo 'marca' de Producto
    private Set<Producto> productos; // Lista de productos pertenecientes a esta marca
            
    public Marca(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Marca() {
    }

    //Getters y setters
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Marca{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

}
