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
public class serviciosDoctor {
    @Autowired
    private RepositorioDoctor metodosCrud;

    public serviciosDoctor() {
    }

    public List<Doctor> getAll() {
        return this.metodosCrud.getAll();
    }

    public Optional<Doctor> getDoctor(int doctorId) {
        return this.metodosCrud.getDoctor(doctorId);
    }

    public Doctor save(Doctor doctor) {
        if (doctor.getId() == null) {
            return this.metodosCrud.save(doctor);
        } else {
            Optional<Doctor> e = this.metodosCrud.getDoctor(doctor.getId());
            return e.isEmpty() ? this.metodosCrud.save(doctor) : doctor;
        }
    }

    public Doctor update(Doctor doctor) {
        if (doctor.getId() != null) {
            Optional<Doctor> e = this.metodosCrud.getDoctor(doctor.getId());
            if (!e.isEmpty()) {
                if (doctor.getName() != null) {
                    ((Doctor)e.get()).setName(doctor.getName());
                }

                if (doctor.getDepartment() != null) {
                    ((Doctor)e.get()).setDepartment(doctor.getDepartment());
                }

                if (doctor.getYear() != null) {
                    ((Doctor)e.get()).setYear(doctor.getYear());
                }

                if (doctor.getDescription() != null) {
                    ((Doctor)e.get()).setDescription(doctor.getDescription());
                }

                if (doctor.getSpecialty() != null) {
                    ((Doctor)e.get()).setSpecialty(doctor.getSpecialty());
                }

                this.metodosCrud.save((Doctor)e.get());
                return (Doctor)e.get();
            } else {
                return doctor;
            }
        } else {
            return doctor;
        }
    }

    public boolean deleteDoctor(int doctorId) {
        Boolean aBoolean = (Boolean)this.getDoctor(doctorId).map((doctor) -> {
            this.metodosCrud.delete(doctor);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
