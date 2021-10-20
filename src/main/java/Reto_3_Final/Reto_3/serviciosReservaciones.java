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
public class serviciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;

    public serviciosReservaciones() {
    }

    public List<Reservaciones> getAll() {
        return this.metodosCrud.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservationId) {
        return this.metodosCrud.getReservation(reservationId);
    }

    public Reservaciones save(Reservaciones reservation) {
        if (reservation.getIdReservation() == null) {
            return this.metodosCrud.save(reservation);
        } else {
            Optional<Reservaciones> e = this.metodosCrud.getReservation(reservation.getIdReservation());
            return e.isEmpty() ? this.metodosCrud.save(reservation) : reservation;
        }
    }

    public Reservaciones update(Reservaciones reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservaciones> e = this.metodosCrud.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    ((Reservaciones)e.get()).setStartDate(reservation.getStartDate());
                }

                if (reservation.getDevolutionDate() != null) {
                    ((Reservaciones)e.get()).setDevolutionDate(reservation.getDevolutionDate());
                }

                if (reservation.getStatus() != null) {
                    ((Reservaciones)e.get()).setStatus(reservation.getStatus());
                }

                this.metodosCrud.save((Reservaciones)e.get());
                return (Reservaciones)e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = (Boolean)this.getReservation(reservationId).map((reservation) -> {
            this.metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
