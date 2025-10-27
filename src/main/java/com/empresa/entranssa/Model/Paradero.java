package com.empresa.entranssa.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "Paraderos")
public class Paradero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paradero;

    @Column(nullable = false, length = 100)
    private String nombre_paradero;

    private String ubicacion;

    private Double latitud;
    private Double longitud;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name = "id_tipoEntidad")
    private TipoEntidad tipoEntidad;

    public Paradero() {
    }

    public Paradero(Long id_paradero, String nombre_paradero, String ubicacion, Double latitud, Double longitud, Ruta ruta, TipoEntidad tipoEntidad) {
        this.id_paradero = id_paradero;
        this.nombre_paradero = nombre_paradero;
        this.ubicacion = ubicacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.ruta = ruta;
        this.tipoEntidad = tipoEntidad;
    }

    public Long getId_paradero() {
        return id_paradero;
    }

    public void setId_paradero(Long id_paradero) {
        this.id_paradero = id_paradero;
    }

    public String getNombre_paradero() {
        return nombre_paradero;
    }

    public void setNombre_paradero(String nombre_paradero) {
        this.nombre_paradero = nombre_paradero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public TipoEntidad getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(TipoEntidad tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }
}