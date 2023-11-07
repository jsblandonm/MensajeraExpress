package MensajeriaExpress.service;

import MensajeriaExpress.Dto.ClienteDto;
import MensajeriaExpress.entity.Cliente;

import MensajeriaExpress.repository.ClienteRepository;
import MensajeriaExpress.repository.IClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientRepository {



    private final ClienteRepository clienteRepository;
    @Autowired
    public ClientService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /*public ClienteDto addCliente(ClienteDto clienteDTO){

        if(clienteDTO == null){
            throw new Error("El cliente no puede ser nulo ");
        }
        if(clienteDTO.getCedulaCliente() == null || clienteDTO.getApellidoCliente() == null || clienteDTO.getNombreCliente() == null){
            throw new Error("la cedula, el apellido o el nombre son invalidos");
        }

        Cliente cliente = new Cliente(
                clienteDTO.getCedulaCliente(),
                clienteDTO.getNombreCliente(),
                clienteDTO.getApellidoCliente(),
                clienteDTO.getCelularCliente(),
                clienteDTO.getEmailCliente(),
                clienteDTO.getDireccionResidencia(),
                clienteDTO.getCiudad()
        );

        clienteRepository.save(cliente);
        return clienteDTO;
    }*/


    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findClienteById(Integer cedulaCliente) {
        Optional<Cliente> client = clienteRepository.findById(cedulaCliente);
        return client.orElse(null);
    }

    public Cliente addCliente(@Valid Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer cedulaCliente, Cliente cliente) {
        if (clienteRepository.existsById(cedulaCliente)) {
            cliente.setCedulaCliente(cedulaCliente);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);

    }
}
