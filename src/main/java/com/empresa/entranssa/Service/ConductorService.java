package com.empresa.entranssa.Service;

import com.empresa.entranssa.Dao.ConductorDAO;
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

    public Conductor guardar(Conductor conductor) {
        return conductorDAO.save(conductor);
    }

    public void eliminar(Long id) {
        conductorDAO.deleteById(id);
    }

    public Conductor buscarPorId(Long id) {
        return conductorDAO.findById(id).orElse(null);
    }
}