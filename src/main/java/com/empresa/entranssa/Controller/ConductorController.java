    package com.empresa.entranssa.Controller;

    import com.empresa.entranssa.Model.Administrador;
    import com.empresa.entranssa.Model.Conductor;
    import com.empresa.entranssa.Service.ConductorService;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Map;

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


       // @PostMapping("/crear")
        //public Conductor crearConductor(@RequestBody Conductor conductor) {
          //  return conductorService.crear(conductor);
        //}


        @GetMapping("/id/{id}")
        public Conductor conductor(@PathVariable Long id) {
            return conductorService.buscarPorId(id);
        }

        @DeleteMapping("/id/{id}")
        public void eliminar(@PathVariable Long id) {
            conductorService.eliminar(id);
        }
        @PostMapping("/registrar")
        public ResponseEntity<?> registrar(@RequestBody Conductor nuevo) {

            try {
                Conductor conductor = conductorService.registrar(nuevo);
                conductor.setContrasena(null); // No enviamos la contraseña
                return ResponseEntity.ok(conductor);

            } catch (Exception e) {
                return ResponseEntity.badRequest().body(
                        Map.of("error", e.getMessage())
                );
            }
        }
        // LOGIN
        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody Map<String, String> datos) {

            String correo = datos.get("correo");
            String contrasena = datos.get("contrasena");

            if (correo == null || contrasena == null) {
                return ResponseEntity.badRequest().body(
                        Map.of("error", "Faltan campos: correo y contrasena")
                );
            }

            Conductor conductor = conductorService.login(correo, contrasena);

            if (conductor != null) {
                conductor.setContrasena(null);
                return ResponseEntity.ok(conductor);
            }

            return ResponseEntity.status(401).body(
                    Map.of("error", "Credenciales incorrectas")
            );
        }


    }
