package com.empresa.entranssa.Model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
@Embeddable
public class BusConductorId implements Serializable {
    private Long id_bus;
    private Long id_conductor;
}