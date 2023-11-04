package MensajeriaExpress.service;

import MensajeriaExpress.entity.Cliente;

import MensajeriaExpress.repository.ClienteRepository;
import MensajeriaExpress.repository.IClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientRepository {

    private final ClienteRepository clienteRepository;
    @Autowired
    public ClientService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

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
