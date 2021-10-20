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
public class serviciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;

    public serviciosMensaje() {
    }

    public List<Mensaje> getAll() {
        return this.metodosCrud.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId) {
        return this.metodosCrud.getMessage(messageId);
    }

    public Mensaje save(Mensaje message) {
        if (message.getIdMessage() == null) {
            return this.metodosCrud.save(message);
        } else {
            Optional<Mensaje> e = this.metodosCrud.getMessage(message.getIdMessage());
            return e.isEmpty() ? this.metodosCrud.save(message) : message;
        }
    }

    public Mensaje update(Mensaje message) {
        if (message.getIdMessage() != null) {
            Optional<Mensaje> e = this.metodosCrud.getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText() != null) {
                    ((Mensaje)e.get()).setMessageText(message.getMessageText());
                }

                this.metodosCrud.save((Mensaje)e.get());
                return (Mensaje)e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = (Boolean)this.getMessage(messageId).map((message) -> {
            this.metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
