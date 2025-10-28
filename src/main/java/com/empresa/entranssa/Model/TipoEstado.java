package com.empresa.entranssa.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tipo_Estado")
public class TipoEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado;

    @Column(nullable = false, length = 50)
    private String nombre_estado;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    @JsonBackReference(value = "estado-buses")
    private List<Bus> buses;

}