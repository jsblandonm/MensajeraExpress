
package MensajeriaExpress.controller;

import MensajeriaExpress.Dto.EnvioDto;
import MensajeriaExpress.entity.Envio;
import MensajeriaExpress.service.EnvioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public EnvioDto crearEnvio(@Valid @RequestBody EnvioDto envioDto) {
        return envioService.addEnvio(envioDto);
    }

    @GetMapping
    public List<Envio> listarEnvios() {
        return envioService.getAllEnvios();
    }

    @GetMapping("/{numeroGuia}")
    public EnvioDto obtenerEnvio(@PathVariable Long numeroGuia) {
        Envio envio = envioService.findById(numeroGuia);

        if (envio == null){
            throw new Error("No existe envio con el nuero de guia " + numeroGuia);
        }

        return mapearEnvioAEnvioDto(numeroGuia);
    }


    @PutMapping("/{numeroGuia}")
    public EnvioDto actualizarEnvio(@PathVariable Long numeroGuia, @RequestBody EnvioDto envioDto) {
        if (numeroGuia == null){
            throw  new IllegalArgumentException("El numero de la guia es requerido");
        }
        Envio envio = mapearEnvioDtoAEnvio(envioDto);
        envio = envioService.updateEnvio(numeroGuia,envio);
        return mapearEnvioAEnvioDto(envio);
    }

    @DeleteMapping("/{numeroGuia}")
    public void eliminarEnvio(@PathVariable Long numeroGuia) {

        envioService.deleteEnvio(numeroGuia);
    }

    private Envio mapearEnvioDtoAEnvio(EnvioDto envioDto){
        Envio envio = new Envio();

        envio.setNumeroGuia(envioDto.getNumeroGuia());
        envio.setClienteId(envioDto.getClienteId());
        envio.setCiudadDestino(envioDto.getCiudadDestino());
        envio.setCiudadOrigen(envioDto.getCiudadOrigen());
        envio.setDireccionDestino(envioDto.getDireccionDestino());
        envio.setDestinatario(envioDto.getDestinatario());
        envio.setCelularDestinatario(envioDto.getCelularDestinatario());
        envio.setHoraEntrega(envioDto.getHoraEntrega());
        envio.setEstado(envioDto.getEstado());
        envio.setValorEnvio(envioDto.getValorEnvio());
        envio.setIdPaquete(envioDto.getIdPaquete());
        //envio.setCliente(envioDto.getCliente());
        //envio.setEmpleado(envioDto.getEmpleado());

        return envio;
    }

    private EnvioDto mapearEnvioAEnvioDto(Envio envio){
        EnvioDto envioDto = new EnvioDto();

        envioDto.setNumeroGuia(envio.getNumeroGuia());
        envioDto.setClienteId(envio.getClienteId());
        envioDto.setCiudadDestino(envio.getCiudadDestino());
        envioDto.setCiudadOrigen(envio.getCiudadOrigen());
        envioDto.setDireccionDestino(envio.getDireccionDestino());
        envioDto.setDestinatario(envio.getDestinatario());
        envioDto.setCelularDestinatario(envio.getCelularDestinatario());
        envioDto.setHoraEntrega(String.valueOf(envio.getHoraEntrega()));
        envioDto.setEstado(String.valueOf(Envio.estadoEnvio.ENRUTA));
        envioDto.setValorEnvio(envio.getValorEnvio());
        envioDto.setIdPaquete(envio.getIdPaquete());
        //envioDto.setCliente(envio.getCliente());
        //envioDto.setEmpleado(envio.getEmpleado());

        return envioDto;
    }

}
