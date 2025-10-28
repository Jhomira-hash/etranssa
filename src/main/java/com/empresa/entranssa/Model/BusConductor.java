package com.empresa.entranssa.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//para evitar el bucle infinito
import com.fasterxml.jackson.annotation.JsonBackReference;

//@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "Bus_Conductor")
public class BusConductor {

    @EmbeddedId
    private BusConductorId id;

    @ManyToOne
    @MapsId("id_bus")
    @JoinColumn(name = "id_bus")
    @JsonBackReference(value = "bus-busConductores")
    private Bus bus;

    @ManyToOne
    @MapsId("id_conductor")
    @JoinColumn(name = "id_conductor")
    @JsonBackReference(value = "conductor-busConductores")
    private Conductor conductor;

    @Temporal(TemporalType.DATE)
    private Date fecha_inicio;

    @Temporal(TemporalType.DATE)
    private Date fecha_fin;



    public BusConductor() {
    }

    public BusConductor(BusConductorId id, Bus bus, Conductor conductor, Date fecha_inicio, Date fecha_fin) {
        this.id = id;
        this.bus = bus;
        this.conductor = conductor;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public BusConductorId getId() {
        return id;
    }

    public void setId(BusConductorId id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}