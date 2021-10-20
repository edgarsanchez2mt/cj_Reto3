/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3_Final.Reto_3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEspecialidad {
    @Autowired
    private InterfaceEspecialidad crud;

    public RepositorioEspecialidad() {
    }

    public List<Especialidad> getAll() {
        return (List)this.crud.findAll();
    }

    public Optional<Especialidad> getEspecialidad(int id) {
        return this.crud.findById(id);
    }

    public Especialidad save(Especialidad especialidad) {
        return (Especialidad)this.crud.save(especialidad);
    }

    public void delete(Especialidad especialidad) {
        this.crud.delete(especialidad);
    }
}
