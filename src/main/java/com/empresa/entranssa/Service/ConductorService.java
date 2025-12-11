package com.empresa.entranssa.Service;

import com.empresa.entranssa.Dao.ConductorDAO;
import com.empresa.entranssa.Model.Administrador;
import com.empresa.entranssa.Model.Conductor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConductorService {

    private final ConductorDAO conductorDAO;

    public ConductorService(ConductorDAO conductorDAO) {
        this.conductorDAO = conductorDAO;
    }

    public List<Conductor> listarTodos() {
        return conductorDAO.findAll();
    }

    // NUEVO: método solo para crear
    //public Conductor crear(Conductor conductor) {
    //    conductor.setId_conductor(null); // garantizar creación, no actualización
      //  return conductorDAO.save(conductor);
    //  }

// REGISTRAR CONDUCTOR OFICIAL
    public Conductor registrar(Conductor conductor) {

        // Validar correo único
        if (conductorDAO.findByCorreo(conductor.getCorreo()) != null) {
            throw new RuntimeException("El correo ya está registrado");
        }

        return conductorDAO.save(conductor);
    }

    public void eliminar(Long id) {
        conductorDAO.deleteById(id);
    }

    public Conductor buscarPorId(Long id) {
        return conductorDAO.findById(id).orElse(null);
    }

    public Conductor login(String correo, String contrasena) {
        return conductorDAO.findByCorreoAndContrasena(correo, contrasena);
    }
}
