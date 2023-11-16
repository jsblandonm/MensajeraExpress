package MensajeriaExpress.controller;

import MensajeriaExpress.Dto.ClienteDto;
import MensajeriaExpress.entity.Cliente;

import MensajeriaExpress.repository.ClienteRepository;
import MensajeriaExpress.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClientService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClientService clienteService) {

        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto addCliente(@Valid @RequestBody ClienteDto cliente) {

        return clienteService.addCliente(cliente);
    }

    @PreAuthorize("hasRole('USER')")
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

        cliente.setCedulaCliente(clienteDto.getCedula());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setCelular(clienteDto.getCelular());
        cliente.setDireccionResidencia(clienteDto.getDireccionResidencia());
        cliente.setCiudad(clienteDto.getCiudad());
        cliente.setEmail(clienteDto.getEmail());


        return cliente;

    }

    //mapear de cliente a clienteDto
    public  ClienteDto mapearClienteAClienteDto(@Valid Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setCedula(cliente.getCedulaCliente());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setApellido(cliente.getApellido());
        clienteDto.setCelular(cliente.getCelular());
        clienteDto.setCiudad(cliente.getCiudad());
        clienteDto.setDireccionResidencia(cliente.getDireccionResidencia());
        clienteDto.setEmail(cliente.getEmail());


        return clienteDto;
    }

}

