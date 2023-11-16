package MensajeriaExpress.service;

import MensajeriaExpress.entity.Cliente;

import MensajeriaExpress.repository.ClienteRepository;
import jakarta.validation.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.annotation.Rollback;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Rollback
class ClientServiceTest {

    @Mock
    private ClienteRepository clienteRepository;
    private Validator validator;

    @BeforeEach
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testCrearClienteConValoresValidos() {
        // Arrange
        Integer cedulaCliente = 123456789;
        String nombreCliente = "Nombre";
        String apellidoCliente = "Apellido";
        String celularCliente = "1234567890";
        String emailCliente = "correo@dominio.com";
        String direccionResidencia = "Dirección";
        String ciudad = "Ciudad";

        // Act
        Cliente cliente = new Cliente(cedulaCliente, nombreCliente, apellidoCliente, celularCliente,
                emailCliente, direccionResidencia, ciudad);

        // Assert
        assertNotNull(cliente);
        assertEquals(cedulaCliente, cliente.getCedulaCliente());
        assertEquals(nombreCliente, cliente.getNombre());
        assertEquals(apellidoCliente, cliente.getApellido());
        assertEquals(celularCliente, cliente.getCelular());
        assertEquals(emailCliente, cliente.getEmail());
        assertEquals(direccionResidencia, cliente.getDireccionResidencia());
        assertEquals(ciudad, cliente.getCiudad());
    }

    @Test
    void testCrearClienteConValoresInvalidos() {
        // Arrange
        Integer cedulaCliente = 123; // Valor inválido
        String nombreCliente = "Nombre";
        String apellidoCliente = "Apellido";
        String celularCliente = "1234567890";
        String emailCliente = "correo@dominio.com";
        String direccionResidencia = "Dirección";
        String ciudad = "Ciudad";

        // Act y Assert
        assertThrows(ConstraintViolationException.class, () -> {
            Cliente cliente = new Cliente(cedulaCliente, nombreCliente, apellidoCliente, celularCliente,
                    emailCliente, direccionResidencia, ciudad);
            validarCliente(cliente);
        });
    }

    private void validarCliente(Cliente cliente) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);

        if (!violations.isEmpty()){
            for (ConstraintViolation<Cliente> violation : violations) {
                System.out.println("Error de validación: " + violation.getMessage());
            }
            throw new ConstraintViolationException("La entidad no cumple con las restricciones de validación", violations);
        }

    }
}
