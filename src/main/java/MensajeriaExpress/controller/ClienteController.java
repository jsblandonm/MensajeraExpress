package MensajeriaExpress.controller;

import MensajeriaExpress.Dto.ClienteDto;
import MensajeriaExpress.entity.Cliente;
import MensajeriaExpress.service.ClientService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClientService clienteService;

    @Autowired
    public ClienteController(ClientService clienteService) {
        this.clienteService = clienteService;
    }

    /*@ApiResponse(value = {
            @ApiResponse(code = 200, message = "Su solicitud se ha procesado correctamente"),
            @ApiResponse(code = 404, message = " El servidor no ha podido encontrar el recurso solicitado, intene nuevamente"),
            @ApiResponse(code = 500, message = "Lo sentimos, ha habido un error interno en el servidor, no ha sido posible procesar la solicitud.")
    })*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto addCliente(@Valid @RequestBody ClienteDto cliente) {

        return clienteService.addCliente(cliente);
    }

    @GetMapping
    public List<Cliente> getAllClintes(){
        return  clienteService.getAllClientes();
    }

    @GetMapping("/{cedulaCliente}")
    public ClienteDto findClienteById(@PathVariable Integer cedulaCliente) {

        Cliente cliente = clienteService.findClienteById(cedulaCliente);

        if (cliente == null){
            throw new Error("No existe cliente con id " + cedulaCliente);
        }

        return mapearClienteAClienteDto(cliente);

    }

    @PutMapping("/{cedulaCliente}")
    public ClienteDto updateCliente(@PathVariable Integer cedulaCliente,@Valid @RequestBody ClienteDto clienteDto) {
        if (cedulaCliente == null){
            throw new RuntimeException("El id del cliente es requerido");
        }
        Cliente cliente = mapearClienteDtoACliente(clienteDto);
        cliente = clienteService.updateCliente(cedulaCliente,cliente);
        return mapearClienteAClienteDto(cliente);

    }

    @DeleteMapping("/{cedulaCliente}")
    public void deleteCliente(@PathVariable Integer cedulaCliente) {

        clienteService.deleteCliente(cedulaCliente);
    }

    private Cliente mapearClienteDtoACliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();

        cliente.setCedulaCliente(clienteDto.getCedulaCliente());
        cliente.setNombreCliente(clienteDto.getNombreCliente());
        cliente.setApellidoCliente(clienteDto.getApellidoCliente());
        cliente.setCelularCliente(clienteDto.getCelularCliente());
        cliente.setDireccionResidencia(clienteDto.getDireccionResidencia());
        cliente.setCiudad(clienteDto.getCiudad());
        cliente.setEmailCliente(clienteDto.getEmailCliente());

        return cliente;

    }

    //mapear de cliente a clienteDto
    public  ClienteDto mapearClienteAClienteDto(@Valid Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setCedulaCliente(cliente.getCedulaCliente());
        clienteDto.setNombreCliente(cliente.getNombreCliente());
        clienteDto.setApellidoCliente(cliente.getApellidoCliente());
        clienteDto.setCelularCliente(cliente.getCelularCliente());
        clienteDto.setCiudad(cliente.getCiudad());
        clienteDto.setDireccionResidencia(cliente.getDireccionResidencia());
        clienteDto.setEmailCliente(cliente.getEmailCliente());

        return clienteDto;
    }

}

