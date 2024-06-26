package com.applicacion_hibernate.controller;

import com.applicacion_hibernate.DAO.Model;
import com.applicacion_hibernate.entidades.Marca;
import java.util.List;

public class MarcaController {

    private final Model<Marca> marcaModel = new Model<>(Marca.class) {
    };

    public void listarMarcas() {
        try {
            List<Marca> marcas = marcaModel.getAll();
            for (Marca marca : marcas) {
                System.out.println(marca.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al listar marcas: " + e);
        }
    }

    public void addMarca(String nombre, String descripcion) {
        Marca newMarca = new Marca(nombre, descripcion);
        marcaModel.add(newMarca);
    }

    public void deleteMarca(int id) {
        marcaModel.delete(id);
    }

    public void updateMarca(int identificador, Marca updatedMarca) {
            marcaModel.update(identificador, updatedMarca);
    }
}
