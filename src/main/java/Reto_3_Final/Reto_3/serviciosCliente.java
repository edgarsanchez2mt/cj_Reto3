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
public class serviciosCliente {
    @Autowired
    private RepositorioCliente metodosCrud;

    public serviciosCliente() {
    }

    public List<Cliente> getAll() {
        return this.metodosCrud.getAll();
    }

    public Optional<Cliente> getClient(int clientId) {
        return this.metodosCrud.getCliente(clientId);
    }

    public Cliente save(Cliente client) {
        if (client.getIdClient() == null) {
            return this.metodosCrud.save(client);
        } else {
            Optional<Cliente> e = this.metodosCrud.getCliente(client.getIdClient());
            return e.isEmpty() ? this.metodosCrud.save(client) : client;
        }
    }

    public Cliente update(Cliente client) {
        if (client.getIdClient() != null) {
            Optional<Cliente> e = this.metodosCrud.getCliente(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    ((Cliente)e.get()).setName(client.getName());
                }

                if (client.getAge() != null) {
                    ((Cliente)e.get()).setAge(client.getAge());
                }

                if (client.getPassword() != null) {
                    ((Cliente)e.get()).setPassword(client.getPassword());
                }

                this.metodosCrud.save((Cliente)e.get());
                return (Cliente)e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = (Boolean)this.getClient(clientId).map((client) -> {
            this.metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
