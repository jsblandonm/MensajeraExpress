package MensajeriaExpress.service;

import MensajeriaExpress.Dto.ClienteDto;
import MensajeriaExpress.entity.Cliente;

import MensajeriaExpress.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClientService {

    public List<Cliente> clientes;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClientService(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
        this.clientes = new ArrayList<>();
    }

    public ClienteDto addCliente(@Valid @RequestBody ClienteDto clienteDTO) {

        if (clienteDTO == null) {
            throw new Error("El cliente no puede ser nulo ");
        }
        if (clienteDTO.getCedula() == null || clienteDTO.getApellido() == null || clienteDTO.getNombre() == null) {
            throw new Error("la cedula, el apellido o el nombre son invalidos");
        }



        Cliente cliente = new Cliente(
                clienteDTO.getCedula(),
                clienteDTO.getNombre(),
                clienteDTO.getApellido(),
                clienteDTO.getCelular(),
                clienteDTO.getEmail(),
                clienteDTO.getDireccionResidencia(),
                clienteDTO.getCiudad()
        );



        clienteRepository.save(cliente);
        //clienteRepository.save(cl);

        //return ResponseEntity.ok(clienteDTO);
       return clienteDTO;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findClienteById(Integer cedula) {
        Optional<Cliente> client = clienteRepository.findById(cedula);
        return client.orElse(null);
    }

    @Transactional
    public Cliente updateCliente(Integer cedula, Cliente cliente) {
        if (cliente == null){
            throw new IllegalArgumentException("El cliente no debe ser nulo");
        }
        if (!clienteRepository.existsById(cedula)) {
            throw new IllegalArgumentException("No existe el cliente con id "+ cedula);
        }


        return clienteRepository.save(cliente);

    }

    public void deleteCliente(Integer cedula) {
        if (cedula == null){
            throw new IllegalArgumentException("la ceudña no debe ser nula");
        }
        Optional<Cliente> cliente = this.clienteRepository.findById(cedula);

        if (cliente.isEmpty()){
            throw new IllegalArgumentException("el cliente con la cedula" + cedula + "no existe");
        }

        Cliente clienteEncontrado = cliente.get();
        clienteRepository.delete(cliente.get());
    }
}

