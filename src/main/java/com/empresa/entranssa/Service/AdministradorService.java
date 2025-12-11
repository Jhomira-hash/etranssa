package com.empresa.entranssa.Service;

import com.empresa.entranssa.Dao.AdministradorDAO;
import com.empresa.entranssa.Model.Administrador;
import com.empresa.entranssa.Model.Rol;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministradorService {

    private final AdministradorDAO administradorDAO;

    public AdministradorService(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    // LISTAR
    public List<Administrador> listarTodos() {
        return administradorDAO.findAll();
    }

    // REGISTRAR
    public Administrador registrar(Administrador nuevo, Long idCreador) {

        Administrador creador = administradorDAO.findById(idCreador)
                .orElseThrow(() -> new RuntimeException("Creador no encontrado."));

        if (creador.getRol() != Rol.ADMIN) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                    "No tienes permisos para registrar administradores.");
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

    // VALIDACIÓN DE CONTRASEÑA
    public List<String> validarContrasenaSegura(String contrasena) {
        List<String> errores = new ArrayList<>();

        if (contrasena.length() < 8) errores.add("Debe tener mínimo 8 caracteres");
        if (!contrasena.matches(".*[A-Z].*")) errores.add("Debe contener al menos una letra mayúscula");
        if (!contrasena.matches(".*[a-z].*")) errores.add("Debe contener al menos una letra minúscula");
        if (!contrasena.matches(".*\\d.*")) errores.add("Debe contener al menos un número");
        if (!contrasena.matches(".*[!@#$%^&*().,;:<>/?_-].*"))
            errores.add("Debe contener al menos un carácter especial");

        return errores;
    }

    // LOGIN
    public Administrador login(String correo, String contrasena) {
        return administradorDAO.findByCorreoAndContrasena(correo, contrasena);
    }

    // BUSCAR POR ID
    public Administrador buscarPorId(Long id) {
        return administradorDAO.findById(id).orElse(null);
    }

    // ACTUALIZAR
    public Administrador actualizar(Long id, Administrador datos) {

        Administrador admin = buscarPorId(id);

        if (admin == null) {
            throw new RuntimeException("Administrador no encontrado");
        }

        admin.setNombre(datos.getNombre());
        admin.setApellido(datos.getApellido());
        admin.setCorreo(datos.getCorreo());
        admin.setContrasena(datos.getContrasena());
        admin.setTelefono(datos.getTelefono());
        admin.setRol(datos.getRol());
        admin.setDni(datos.getDni());

        return administradorDAO.save(admin);
    }

    // ELIMINAR
    public void eliminar(Long id) {
        administradorDAO.deleteById(id);
    }
}
