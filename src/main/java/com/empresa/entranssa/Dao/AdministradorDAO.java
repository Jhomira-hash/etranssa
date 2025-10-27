package com.empresa.entranssa.Dao;

import com.empresa.entranssa.Model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorDAO extends JpaRepository<Administrador, Long> {

    Administrador findByCorreoAndContrasena(String correo, String contrasena);

}
