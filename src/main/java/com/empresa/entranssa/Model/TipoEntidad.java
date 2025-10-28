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
@Table(name = "Tipo_Entidad")
public class TipoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoEntidad;

    @Column(nullable = false, length = 100)
    private String nombre_entidad;

    @OneToMany(mappedBy = "tipoEntidad", cascade = CascadeType.ALL)
    @JsonBackReference(value = "tipoEntidad-paraderos")
    private List<Paradero> paraderos;
}
