package MensajeriaExpress.repository;

import MensajeriaExpress.entity.Cliente;
import java.util.List;

public interface IClientRepository {
        List<Cliente> getAllClientes();
        Cliente findClienteById(Integer cedulaCliente);
        Cliente addCliente(Cliente cliente);
        Cliente updateCliente(Integer cedulaCliente, Cliente cliente);
        void deleteCliente(Integer cedulaCliente);

}
