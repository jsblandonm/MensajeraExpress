package MensajeriaExpress.service;

import MensajeriaExpress.Dto.ClienteDto;
import MensajeriaExpress.entity.Cliente;

import MensajeriaExpress.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    public List<Cliente> clientes;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClientService(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
        this.clientes = new ArrayList<>();
    }

    public ClienteDto addCliente(ClienteDto clienteDTO) {

        if (clienteDTO == null) {
            throw new Error("El cliente no puede ser nulo ");
        }
        if (clienteDTO.getCedulaCliente() == null || clienteDTO.getApellidoCliente() == null || clienteDTO.getNombreCliente() == null) {
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
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findClienteById(Integer cedulaCliente) {
        Optional<Cliente> client = clienteRepository.findById(cedulaCliente);
        return client.orElse(null);
    }

    @Transactional
    public Cliente updateCliente(Integer cedulaCliente, Cliente cliente) {
        if (cliente == null){
            throw new IllegalArgumentException("El cliente no debe ser nulo");
        }
        if (!clienteRepository.existsById(cedulaCliente)) {
            throw new IllegalArgumentException("No existe el cliente con id "+cedulaCliente);
        }


        return clienteRepository.save(cliente);

    }

    public void deleteCliente(Integer cedulaCliente) {
        if (cedulaCliente == null){
            throw new IllegalArgumentException("la ceudña no debe ser nula");
        }
        Optional<Cliente> cliente = this.clienteRepository.findById(cedulaCliente);

        if (cliente.isEmpty()){
            throw new IllegalArgumentException("el cliente con la cedula" + cedulaCliente + "no existe");
        }

        Cliente clienteEncontrado = cliente.get();
        clienteRepository.delete(cliente.get());
    }
}

