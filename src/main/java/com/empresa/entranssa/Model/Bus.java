package com.empresa.entranssa.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "Buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_bus;

    @Column(nullable = true, unique = true, length = 15)
    private String placa;

    private Integer capacidad;
    private String horario;

    @ManyToOne
    @JoinColumn(name = "id_ruta", nullable = true)
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = true)
    private TipoEstado estado;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<BusConductor> busConductores;

    public Bus() {
    }

    public Bus(Long id_bus, String placa, Integer capacidad, String horario, Ruta ruta, TipoEstado estado, List<BusConductor> busConductores) {
        this.id_bus = id_bus;
        this.placa = placa;
        this.capacidad = capacidad;
        this.horario = horario;
        this.ruta = ruta;
        this.estado = estado;
        this.busConductores = busConductores;
    }

    public Long getId_bus() {
        return id_bus;
    }

    public void setId_bus(Long id_bus) {
        this.id_bus = id_bus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public List<BusConductor> getBusConductores() {
        return busConductores;
    }

    public void setBusConductores(List<BusConductor> busConductores) {
        this.busConductores = busConductores;
    }
}

