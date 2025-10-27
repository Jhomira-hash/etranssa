package com.empresa.entranssa.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "Conductores")
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conductor;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;

    private String telefono;

    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL)
    private List<BusConductor> busConductores;

    public Conductor() {
    }

    public Conductor(Long id_conductor, String nombre, String apellido, Date fecha_nacimiento, String telefono, List<BusConductor> busConductores) {
        this.id_conductor = id_conductor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.busConductores = busConductores;
    }

    public Long getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(Long id_conductor) {
        this.id_conductor = id_conductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<BusConductor> getBusConductores() {
        return busConductores;
    }

    public void setBusConductores(List<BusConductor> busConductores) {
        this.busConductores = busConductores;
    }
}