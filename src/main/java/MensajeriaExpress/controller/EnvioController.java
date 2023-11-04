package MensajeriaExpress.controller;

import MensajeriaExpress.entity.Envio;
import MensajeriaExpress.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> listarEnvios() {
        return envioService.getAllEnvios();
    }

    @GetMapping("/{id}")
    public Envio obtenerEnvio(@PathVariable Long id) {
        return envioService.findById(id);
    }

    @PostMapping
    public Envio crearEnvio(@RequestBody Envio envio) {
        return envioService.addEnvio(envio);
    }

    @PutMapping("/{id}")
    public Envio actualizarEnvio(@PathVariable Long id, @RequestBody Envio envio) {
        return envioService.updateEnvio(id, envio);
    }

    @DeleteMapping("/{id}")
    public void eliminarEnvio(@PathVariable Long id) {
        envioService.deleteEnvio(id);
    }

}