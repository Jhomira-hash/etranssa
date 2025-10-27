package com.empresa.entranssa.Controller;

import com.empresa.entranssa.Model.Bus;
import com.empresa.entranssa.Service.BusService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/buses")
@CrossOrigin(origins = "http://localhost:4200")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public List<Bus> listar() {
        return busService.listarTodos();
    }

    @PostMapping("/guardar")
    public Bus registrar(@RequestBody Bus bus) {
        return busService.guardar(bus);
    }

    @GetMapping("/{id}")
    public Bus buscar(@PathVariable Long id) {
        return busService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        busService.eliminar(id);
    }
}
