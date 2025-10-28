package com.empresa.entranssa.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Rutas")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ruta;

    @Column(nullable = false, length = 100)
    private String nombre_ruta;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String inicio_ruta;
    private String fin_ruta;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "ruta-paraderos")
    private List<Paradero> paraderos;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "ruta-buses")
    private List<Bus> buses;

    // ✅ Constructores, getters y setters
    public Ruta() {
    }

    public Ruta(Long id_ruta, String nombre_ruta, String descripcion, String inicio_ruta, String fin_ruta,
                List<Paradero> paraderos, List<Bus> buses) {
        this.id_ruta = id_ruta;
        this.nombre_ruta = nombre_ruta;
        this.descripcion = descripcion;
        this.inicio_ruta = inicio_ruta;
        this.fin_ruta = fin_ruta;
        this.paraderos = paraderos;
        this.buses = buses;
    }

    public Long getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(Long id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getNombre_ruta() {
        return nombre_ruta;
    }

    public void setNombre_ruta(String nombre_ruta) {
        this.nombre_ruta = nombre_ruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInicio_ruta() {
        return inicio_ruta;
    }

    public void setInicio_ruta(String inicio_ruta) {
        this.inicio_ruta = inicio_ruta;
    }

    public String getFin_ruta() {
        return fin_ruta;
    }

    public void setFin_ruta(String fin_ruta) {
        this.fin_ruta = fin_ruta;
    }

    public List<Paradero> getParaderos() {
        return paraderos;
    }

    public void setParaderos(List<Paradero> paraderos) {
        this.paraderos = paraderos;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}
