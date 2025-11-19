package com.empresa.entranssa.Service;

import com.empresa.entranssa.Dao.AdministradorDAO;
import com.empresa.entranssa.Model.Administrador;
import com.empresa.entranssa.Model.Rol;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class AdministradorService {
    private final AdministradorDAO administradorDAO;

    public AdministradorService(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    public List<Administrador> listarTodos() {
        return administradorDAO.findAll();
    }


    public Administrador registrar(Administrador nuevo, Long idCreador) {

        Administrador creador = administradorDAO.findById(idCreador)
                .orElseThrow(() -> new RuntimeException("Creador no encontrado."));

        if (creador.getRol() != Rol.ADMIN) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No tienes permisos para registrar administradores.");
        }

        List<String> errores = validarContrasenaSegura(nuevo.getContrasena());

        if (!errores.isEmpty()) {
            throw new IllegalArgumentException("Contraseña no segura: " + String.join(", ", errores));
        }

        if (nuevo.getRol() == null) {
            throw new RuntimeException("Debes especificar un rol para el nuevo administrador.");
        }

        return administradorDAO.save(nuevo);
    }

    public List<String> validarContrasenaSegura(String contrasena) {
        List<String> errores = new ArrayList<>();

        if (contrasena.length() < 8) {
            errores.add("Debe tener mínimo 8 caracteres/n");
        }
        if (!contrasena.matches(".*[A-Z].*")) {
            errores.add("Debe contener al menos una letra mayúscula/n");
        }
        if (!contrasena.matches(".*[a-z].*")) {
            errores.add("Debe contener al menos una letra minúscula/n");
        }
        if (!contrasena.matches(".*\\d.*")) {
            errores.add("Debe contener al menos un número/n");
        }
        if (!contrasena.matches(".*[!@#$%^&*().,;:<>/?_-].*")) {
            errores.add("Debe contener al menos un carácter especial/n");
        }

        return errores;
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