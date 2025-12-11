package com.empresa.entranssa.Controller;

import com.empresa.entranssa.Model.Bus;
import com.empresa.entranssa.Service.BusService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/buses")
@CrossOrigin(origins = "*")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public List<Bus> listar() {
        return busService.listarTodos();
    }

    @PostMapping
    public Bus crear(@RequestBody Bus bus) {
        bus.setId_bus(null);
        return busService.guardar(bus);
    }

    @PutMapping("/{id}")
    public Bus actualizar(@PathVariable Long id, @RequestBody Bus bus) {
        Bus existente = busService.buscarPorId(id);

        if (existente == null) {
            throw new RuntimeException("No existe bus con id " + id);
        }

        bus.setId_bus(id);
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

