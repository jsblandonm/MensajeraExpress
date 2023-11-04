package MensajeriaExpress.controller;

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

    @GetMapping
    public List<Cliente> getAllClintes(){
        return  clienteService.getAllClientes();
    }

    @GetMapping("/{cedulaCliente}")
    public Cliente findClienteById(@PathVariable Integer cedulaCliente) {
        try {
            Cliente cliente = clienteService.findClienteById(cedulaCliente);
            if (cliente == null){
                throw new ClientAbortException("No existe cliente con id " + cedulaCliente);
            }
            return cliente;
        } catch (ClientAbortException e) {
            throw new ResponseStatusException(HttpStatus .NOT_FOUND,e.getMessage(),e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente addCliente(@Valid @RequestBody Cliente cliente) {

        return clienteService.addCliente(cliente);
    }

    @PutMapping("/{cedulaCliente}")
    public Cliente updateCliente(@PathVariable Integer cedulaCliente,@Valid @RequestBody Cliente cliente) {
        if (cedulaCliente == null){
            throw new RuntimeException("El id del cliente es requerido");
        }
        return clienteService.updateCliente(cedulaCliente, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Integer cedulaCliente) {
        clienteService.deleteCliente(cedulaCliente);
    }
}
