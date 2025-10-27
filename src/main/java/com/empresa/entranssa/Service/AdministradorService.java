package com.empresa.entranssa.Service;

import com.empresa.entranssa.Dao.AdministradorDAO;
import com.empresa.entranssa.Model.Administrador;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministradorService {
    private final AdministradorDAO administradorDAO;

    public AdministradorService(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    public List<Administrador> listarTodos() {
        return administradorDAO.findAll();
    }

    public Administrador registrar(Administrador administrador) {
        return administradorDAO.save(administrador);
    }

    public Administrador login(String correo, String contrasena) {
        return administradorDAO.findByCorreoAndContrasena(correo, contrasena);
    }

    public void eliminar(Long id) {
        administradorDAO.deleteById(id);
    }

    public Administrador buscarPorId(Long id) {
        return administradorDAO.findById(id).orElse(null);
    }
}