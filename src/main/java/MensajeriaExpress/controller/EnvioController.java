
package MensajeriaExpress.controller;

import MensajeriaExpress.Dto.EnvioCambiarEstadoDto;
import MensajeriaExpress.Dto.EnvioCreadoDto;
import MensajeriaExpress.Dto.EnvioDetalleDto;
import MensajeriaExpress.Dto.EnvioDto;
import MensajeriaExpress.entity.Envio;
import MensajeriaExpress.service.EnvioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    private final EnvioService envioService;
    @Autowired
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnvioCreadoDto create(@Valid @RequestBody EnvioDto envioDto) {
        return envioService.create(envioDto);
    }

    @PutMapping("/{numeroGuia}")
    public EnvioCreadoDto changeState(@PathVariable Integer numeroGuia,@RequestBody EnvioCambiarEstadoDto envioCambiarEstadoDto) {
        if (numeroGuia == null){
            throw  new IllegalArgumentException("El numero de la guia es requerido");
        }
        return envioService.changeState(envioCambiarEstadoDto);
    }

    @GetMapping("/detalle/{numeroGuia}")
    public EnvioDetalleDto search(@PathVariable Integer numeroGuia) {
        EnvioDetalleDto envioDetalleDto = envioService.search(numeroGuia);
        if (envioDetalleDto != null) {
            return envioDetalleDto;
            //return ResponseEntity.ok(envioDetalleDto);
        } else {
            return null;
            //return ResponseEntity.notFound().build();
        }

        //return envioService.search(numeroGuia);
    }

    @GetMapping("/filtro/{estado}")
    public List<Envio> filter(@PathVariable ("estado") String estado) {

        List<Envio> envios = envioService.filter(estado);

        if (!envios.isEmpty()) {
            return envios;
            //return ResponseEntity.ok(envios);
        } else {
            return  null;
            //return ResponseEntity.noContent().build();
        }

        //return envioService.filter(estado);
    }

}


