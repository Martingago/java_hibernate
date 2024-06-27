package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.entidades.Marca;
import java.util.List;

public class MarcaController {

    private final Model<Marca> marcaModel = new Model<>(Marca.class) {
    };

    public void listarMarcas() {
        try {
            List<Marca> marcas = marcaModel.listar();
            for (Marca marca : marcas) {
                System.out.println(marca.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al listar marcas: " + e);
        }
    }

    public Marca addMarca(String nombre, String descripcion) {
        Marca newMarca = new Marca(nombre, descripcion);
        marcaModel.add(newMarca);
        return newMarca;
    }

    /**
     * Elimina una marca de la base de datos
     * @param id
     */
    public void deleteMarca(int id) {
        marcaModel.delete(id);
    }

    /**
     * Actualiza los datos de una marca en la base de datos
     * @param identificador
     * @param updatedMarca
     */
    public void updateMarca(int identificador, Marca updatedMarca) {
            marcaModel.update(identificador, updatedMarca);
    }
}
