/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3_Final.Reto_3;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
    name = "doctor"
)
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String name;
    private String department;
    private Integer year;
    private String description;
    @ManyToOne
    @JoinColumn(
        name = "specialtyId"
    )
    @JsonIgnoreProperties({"doctor"})
    private Especialidad specialty;
    @OneToMany(
        cascade = {CascadeType.PERSIST},
        mappedBy = "doctor"
    )
    @JsonIgnoreProperties({"doctor", "client"})
    private List<Mensaje> messages;
    @OneToMany(
        cascade = {CascadeType.PERSIST},
        mappedBy = "doctor"
    )
    @JsonIgnoreProperties({"doctor", "client"})
    private List<Reservaciones> reservations;

    public Doctor() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Especialidad getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(Especialidad specialty) {
        this.specialty = specialty;
    }

    public List<Mensaje> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservaciones> getReservations() {
        return this.reservations;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
}
