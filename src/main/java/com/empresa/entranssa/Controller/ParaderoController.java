package com.empresa.entranssa.Controller;

import com.empresa.entranssa.Model.Paradero;
import com.empresa.entranssa.Service.ParaderoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/paraderos")
@CrossOrigin(origins = "http://localhost:4200")
public class ParaderoController {

        private final ParaderoService paraderoService;

        public ParaderoController(ParaderoService paraderoService) {
            this.paraderoService = paraderoService;
        }

        @GetMapping
        public List<Paradero> listar() {
            return paraderoService.listarTodos();
        }

        @PostMapping
        public Paradero registrar(@RequestBody Paradero paradero) {
            return paraderoService.guardar(paradero);
        }

        @GetMapping("/{id}")
        public Paradero buscar(@PathVariable Long id) {
            return paraderoService.buscarPorId(id);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Long id) {
            paraderoService.eliminar(id);
        }
    }

