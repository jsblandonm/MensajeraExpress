package MensajeriaExpress.controller;

import MensajeriaExpress.entity.Paquete;
import MensajeriaExpress.service.PaqueteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

    private final PaqueteService paqueteService;

    @Autowired
    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }


    @GetMapping
    public List<Paquete> listarPaquetes() {
        return paqueteService.getAllPaquetes();
    }

    @GetMapping("/{id}")
    public Paquete obtenerPaquete(@PathVariable Long id) {
        return paqueteService.findPaqueteById(id);
    }

    @PostMapping
    public Paquete crearPaquete(@Valid @RequestBody Paquete paquete) {
        return paqueteService.addPaquete(paquete);
    }

    @PutMapping("/{id}")
    public Paquete actualizarPaquete(@PathVariable Long id, @RequestBody Paquete paquete) {
        return paqueteService.updatePaquete(id, paquete);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaquete(@PathVariable Long id) {
        paqueteService.deletePaquete(id);
    }

}
