package com.empresa.entranssa.Controller;

import com.empresa.entranssa.Model.Administrador;
import com.empresa.entranssa.Service.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/administrador")
@CrossOrigin(origins = "*")
public class AdministradorController {

    private final AdministradorService administradorService;


    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    // LISTAR TODOS
    @GetMapping
    public List<Administrador> listar() {
        return administradorService.listarTodos();
    }

    // REGISTRAR (CORREGIDO)
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestParam Long idCreador,
                                       @RequestBody Administrador nuevoAdmin) {
        try {
            Administrador admin = administradorService.registrar(nuevoAdmin, idCreador);
            return ResponseEntity.ok(admin);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "No se pudo registrar el administrador", "detalle", e.getMessage())
            );
        }
    }


    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Administrador admin) {
        Administrador administrador = administradorService.login(admin.getCorreo(), admin.getContrasena());

        if (administrador != null) {
            return ResponseEntity.ok(administrador);
        }
        return ResponseEntity.status(401).body(Map.of("error", "Credenciales incorrectas"));
    }

    // BUSCAR POR ID
    @GetMapping("/id/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Administrador admin = administradorService.buscarPorId(id);
        if (admin != null) return ResponseEntity.ok(admin);
        return ResponseEntity.status(404).body(Map.of("error", "Administrador no encontrado"));
    }

    // ACTUALIZAR ADMINISTRADOR
    @PutMapping("/id/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id,
                                        @RequestBody Administrador adminActualizado) {
        try {
            Administrador actualizado = administradorService.actualizar(id, adminActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(Map.of(
                    "error", "No se pudo actualizar el administrador",
                    "detalle", e.getMessage()
            ));
        }
    }

    // ELIMINAR
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            administradorService.eliminar(id);
            return ResponseEntity.ok(Map.of("mensaje", "Administrador eliminado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(Map.of("error", "No se encontró el administrador"));
        }
    }
}
