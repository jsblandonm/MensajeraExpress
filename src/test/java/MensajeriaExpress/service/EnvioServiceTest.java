/*
package MensajeriaExpress.service;

import MensajeriaExpress.Dto.EnvioCreadoDto;
import MensajeriaExpress.Dto.EnvioDto;
import MensajeriaExpress.entity.Cliente;
import MensajeriaExpress.entity.Empleado;
import MensajeriaExpress.entity.Envio;
import MensajeriaExpress.entity.Paquete;
import MensajeriaExpress.repository.ClienteRepository;
import MensajeriaExpress.repository.EmpleadoRepositry;
import MensajeriaExpress.repository.EnvioRepository;
import MensajeriaExpress.repository.PaqueteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnvioServiceTest {

    @Mock
    private EnvioRepository envioRepo;

    @Mock
    private ClienteRepository clienteRepo;

    @Mock
    private EmpleadoRepositry empleadoRepo;

    @Mock
    private PaqueteRepository paqueteRepo;

    @InjectMocks
    private EnvioService envioService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        envioService = new EnvioService(envioRepo, clienteRepo, empleadoRepo, paqueteRepo);
    }

    @Test
    void cuandoEnvioEsValido_crearEnvioExitoso() {
        // Mocks
        Cliente cliente = new Cliente();
        when(clienteRepo.findById(1)).thenReturn(Optional.of(cliente));

        Empleado empleado = new Empleado();
        when(empleadoRepo.findById(2)).thenReturn(Optional.of(empleado));

        Paquete paquete = new Paquete();
        when(paqueteRepo.save(any())).thenReturn(paquete);

        EnvioDto dto = new EnvioDto();
        // Set up dto

        // Ejecutar
        EnvioCreadoDto resultado = envioService.create(dto);

        // Validar
        assertEquals(1, resultado.getNumeroGuia());
        assertEquals("RECIBIDO", resultado.getEstado());
    }

    @Test
    void cuandoClienteNoExiste_lanzarExcepcion(){

        when(clienteRepo.findById(1)).thenReturn(Optional.empty());

        EnvioDto dto = new EnvioDto();
        // Set up dto

        Assertions.assertThrows(ClienteNoEncontradoException.class, () -> {
            envioService.create(dto);
        });

    }

    @Test
    void cuandoCambioEstadoValido_actualizarExitoso(){

        Envio envio = new Envio();
        when(envioRepo.findById(1)).thenReturn(Optional.of(envio));

        Empleado empleado = new Empleado();
        when(empleadoRepo.findById(1)).thenReturn(Optional.of(empleado));

        var dto = new EnvioCambiarEstadoDto();
        dto.setEstado(EstadoEnvio.EN_RUTA);

        EnvioCreadoDto resultado = envioService.cambiarEstado(dto);

        assertEquals(EstadoEnvio.EN_RUTA.getEstado(), resultado.getEstado());
        assertEquals(EstadoEnvio.EN_RUTA.getEstado(), envio.getEstado());

    }

    // Más casos de prueba...

}


 */
