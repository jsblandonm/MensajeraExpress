package MensajeriaExpress.service;

import MensajeriaExpress.entity.Empleado;
import MensajeriaExpress.entity.Envio;
import jakarta.transaction.Transactional;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;



@Transactional
@Rollback
class EmpleadoServiceTest {

    private Validator validator;

    @BeforeEach
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    void testCrearEmpleadoConValoresValidos() {
        // Arrange
        Integer cedulaEmpleado = 123456789;
        String nombreEmpleado = "Nombre";
        String apellidoEmpleado = "Apellido";
        String celularEmpleado = "1234567890";
        String email = "correo@dominio.com";
        String direccionResidencia = "Dirección";
        String ciudad = "Ciudad";
        Integer antiguedadEmpresa = 2;
        String tipoSangre = "O+";
        String tipo = "COORDINADOR";
        List<Envio> envios = Arrays.asList(new Envio(), new Envio());

        // Act
        Empleado empleado = new Empleado(
                cedulaEmpleado, nombreEmpleado, apellidoEmpleado, celularEmpleado,
                email, direccionResidencia, ciudad, antiguedadEmpresa,
                tipoSangre, tipo, envios
        );

        // Assert
        assertNotNull(empleado);
        assertEquals(cedulaEmpleado, empleado.getCedulaEmpleado());
        assertEquals(nombreEmpleado, empleado.getNombre());
        assertEquals(apellidoEmpleado, empleado.getApellido());
        assertEquals(celularEmpleado, empleado.getCelular());
        assertEquals(email, empleado.getEmail());
        assertEquals(direccionResidencia, empleado.getDireccionResidencia());
        assertEquals(ciudad, empleado.getCiudad());
        assertEquals(antiguedadEmpresa, empleado.getAntiguedadEmpresa());
        assertEquals(tipoSangre, empleado.getTipoSangre());
        assertEquals(tipo, empleado.getTipo());
        assertEquals(envios, empleado.getEnvios());
    }

    @Test
    void testEquals() {
        // Arrange
        Empleado empleado1 = new Empleado(1, "Nombre", "Apellido", "1234567890", "correo@dominio.com", "Dirección", "Ciudad", 2, "O+", "COORDINADOR", Arrays.asList(new Envio(), new Envio()));
        Empleado empleado2 = new Empleado(1, "Nombre", "Apellido", "1234567890", "correo@dominio.com", "Dirección", "Ciudad", 2, "O+", "COORDINADOR", Arrays.asList(new Envio(), new Envio()));
        Empleado empleado3 = new Empleado(2, "OtroNombre", "OtroApellido", "9876543210", "otro@dominio.com", "OtraDirección", "OtraCiudad", 3, "A-", "REPARTIDOR", Arrays.asList(new Envio(), new Envio()));

        // Assert
        assertEquals(empleado1, empleado2);
        assertNotEquals(empleado1, empleado3);
    }

    @Test
    void testHashCode() {
        // Arrange
        Empleado empleado1 = new Empleado(1, "Nombre", "Apellido", "1234567890", "correo@dominio.com", "Dirección", "Ciudad", 2, "O+", "COORDINADOR", Arrays.asList(new Envio(), new Envio()));
        Empleado empleado2 = new Empleado(1, "Nombre", "Apellido", "1234567890", "correo@dominio.com", "Dirección", "Ciudad", 2, "O+", "COORDINADOR", Arrays.asList(new Envio(), new Envio()));
        Empleado empleado3 = new Empleado(2, "OtroNombre", "OtroApellido", "9876543210", "otro@dominio.com", "OtraDirección", "OtraCiudad", 3, "A-", "REPARTIDOR", Arrays.asList(new Envio(), new Envio()));

        // Assert
        assertEquals(empleado1.hashCode(), empleado2.hashCode());
        assertNotEquals(empleado1.hashCode(), empleado3.hashCode());
    }

    @Test
    void testCrearEmpleadoConValoresInvalidos() {
        // Arrange
        Integer cedulaEmpleado = 123; // Valor inválido
        String nombreEmpleado = "Nombre";
        String apellidoEmpleado = "Apellido";
        String celularEmpleado = "1234567890";
        String email = "correo@dominio.com";
        String direccionResidencia = "Dirección";
        String ciudad = "Ciudad";
        Integer antiguedadEmpresa = 2;
        String tipoSangre = "O+";
        String tipo = "COORDINADOR";
        List<Envio> envios = Arrays.asList(new Envio(), new Envio());

        // Act y Assert
        assertThrows(ConstraintViolationException.class, () -> {
            Empleado empleado = new Empleado(
                    cedulaEmpleado, nombreEmpleado, apellidoEmpleado, celularEmpleado,
                    email, direccionResidencia, ciudad, antiguedadEmpresa,
                    tipoSangre, tipo, envios
            );
            validarEmpleado(empleado);
        });
    }

    private void validarEmpleado(Empleado empleado) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Empleado>> violations = validator.validate(empleado);
        //validator.validate(empleado);

        if (!violations.isEmpty()){
            for (ConstraintViolation<Empleado> violation : violations) {
                System.out.println("Error de validación: " + violation.getMessage());
            }
            throw new ConstraintViolationException("La entidad no cumple con las restricciones de validación", violations);
        }
    }
}