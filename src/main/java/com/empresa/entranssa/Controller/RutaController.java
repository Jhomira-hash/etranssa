package com.empresa.entranssa.Controller;
import com.empresa.entranssa.Model.Ruta;
import com.empresa.entranssa.Service.RutaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/ruta")
@CrossOrigin(origins = "http://localhost:4200")
public class RutaController {



        private final RutaService rutaService;

        public RutaController(RutaService rutaService) {
            this.rutaService = rutaService;
        }

        @GetMapping
        public List<Ruta> listar() {
            return rutaService.listarTodos();
        }

        @PostMapping
        public Ruta registrar(@RequestBody Ruta ruta) {
            return rutaService.guardar(ruta);
        }

        @GetMapping("/{id}")
        public Ruta buscar(@PathVariable Long id) {
            return rutaService.buscarPorId(id);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Long id) {
            rutaService.eliminar(id);
        }
    }