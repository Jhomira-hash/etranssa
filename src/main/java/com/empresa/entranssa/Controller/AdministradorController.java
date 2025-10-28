package com.empresa.entranssa.Controller;

import com.empresa.entranssa.Model.Administrador;
import com.empresa.entranssa.Service.AdministradorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrador")
@CrossOrigin(origins = "*")
public class AdministradorController {


    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping
    public List<Administrador> listar() {
        return administradorService.listarTodos();
    }

    @PostMapping("/registrar")
    public Administrador registrar(@RequestBody Administrador administrador) {
        return administradorService.registrar(administrador);
    }

    @PostMapping("/login")
    public String login(@RequestBody Administrador admin) {
        Administrador administrador = administradorService.login(admin.getCorreo(), admin.getContrasena());

        if (administrador != null) {
            return "✅ Login exitoso. Bienvenido, " + administrador.getNombre() + " " + administrador.getApellido();
        } else {
            return "❌ Credenciales incorrectas. Verifique su correo o contraseña.";
        }
    }

    @GetMapping("/{id}")
    public Administrador buscar(@PathVariable Long id) {
        return administradorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        administradorService.eliminar(id);
    }
}
