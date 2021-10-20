/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3_Final.Reto_3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosEspecialidad {
    @Autowired
    private RepositorioEspecialidad metodosCrud;

    public serviciosEspecialidad() {
    }

    public List<Especialidad> getAll() {
        return this.metodosCrud.getAll();
    }

    public Optional<Especialidad> getEspecialidad(int specialtyId) {
        return this.metodosCrud.getEspecialidad(specialtyId);
    }

    public Especialidad save(Especialidad especialidad) {
        if (especialidad.getId() == null) {
            return this.metodosCrud.save(especialidad);
        } else {
            Optional<Especialidad> Especialidad1 = this.metodosCrud.getEspecialidad(especialidad.getId());
            return Especialidad1.isEmpty() ? this.metodosCrud.save(especialidad) : especialidad;
        }
    }

    public Especialidad update(Especialidad especialidad) {
        if (especialidad.getId() != null) {
            Optional<Especialidad> g = this.metodosCrud.getEspecialidad(especialidad.getId());
            if (!g.isEmpty()) {
                if (especialidad.getDescription() != null) {
                    ((Especialidad)g.get()).setDescription(especialidad.getDescription());
                }

                if (especialidad.getName() != null) {
                    ((Especialidad)g.get()).setName(especialidad.getName());
                }

                return this.metodosCrud.save((Especialidad)g.get());
            }
        }

        return especialidad;
    }

    public boolean deleteespecialidad(int specialtyId) {
        Boolean d = (Boolean)this.getEspecialidad(specialtyId).map((especialidad) -> {
            this.metodosCrud.delete(especialidad);
            return true;
        }).orElse(false);
        return d;
    }
}
