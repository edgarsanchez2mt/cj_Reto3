/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3_Final.Reto_3;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/Specialty"})
@CrossOrigin(
    origins = {"*"},
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
public class EspecialidadWeb {
    @Autowired
    private serviciosEspecialidad servicio;

    public EspecialidadWeb() {
    }

    @GetMapping({"/all"})
    public List<Especialidad> getEspecialidad() {
        return this.servicio.getAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Especialidad> getEspecialidad(@PathVariable("id") int especialidadId) {
        return this.servicio.getEspecialidad(especialidadId);
    }

    @PostMapping({"/save"})
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidad save(@RequestBody Especialidad especialidad) {
        return this.servicio.save(especialidad);
    }

    @PutMapping({"/update"})
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidad update(@RequestBody Especialidad especialidad) {
        return this.servicio.update(especialidad);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int especialidadId) {
        return this.servicio.deleteespecialidad(especialidadId);
    }
}
