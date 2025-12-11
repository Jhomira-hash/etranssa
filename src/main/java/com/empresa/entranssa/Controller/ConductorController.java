package com.empresa.entranssa.Controller;

import com.empresa.entranssa.Model.Conductor;
import com.empresa.entranssa.Service.ConductorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/conductor")
@CrossOrigin(origins = "*")
public class ConductorController {


        private final ConductorService conductorService;

        public ConductorController(ConductorService conductorService) {
            this.conductorService = conductorService;
        }

        @GetMapping
        public List<Conductor> listar() {
            return conductorService.listarTodos();
        }

        @PostMapping("/guardar")
        public Conductor registrar(@RequestBody Conductor conductor) {
            return conductorService.guardar(conductor);
        }

    @PostMapping("/crear")
    public Conductor crearConductor(@RequestBody Conductor conductor) {
        return conductorService.crear(conductor);
    }


    @GetMapping("/{id}")
        public Conductor conductor(@PathVariable Long id) {
            return conductorService.buscarPorId(id);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Long id) {
            conductorService.eliminar(id);
        }
    }
