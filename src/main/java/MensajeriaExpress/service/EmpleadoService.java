package MensajeriaExpress.service;


import MensajeriaExpress.Dto.ClienteDto;
import MensajeriaExpress.Dto.EmpleadoDto;
import MensajeriaExpress.User.User;
import MensajeriaExpress.entity.Cliente;
import MensajeriaExpress.entity.Empleado;
import MensajeriaExpress.repository.EmpleadoRepositry;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    public List<Empleado> empleados;
    private final EmpleadoRepositry empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepositry empleadoRepository) {

        this.empleadoRepository = empleadoRepository;
        this.empleados = new ArrayList<>();
    }

    public EmpleadoDto obtenerEmpleado(Integer cedulaEmpleado){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        String role = String.valueOf(user.getRole());

        // Verificar el rol del usuario y realizar operaciones específicas
        if ("ADMIN".equals(role)) {
            // Operaciones permitidas para el rol de ADMIN
            Empleado empleado = empleadoRepository.findById(cedulaEmpleado)
                    .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + cedulaEmpleado));

            // Aquí puedes realizar cualquier operación adicional necesaria antes de devolver el DTO
            return maperaEmpleadoAEmpleadoDto(empleado);
        } else {
            // Otros roles pueden tener lógica de negocio diferente o restricciones
            throw new IllegalArgumentException("Acceso denegado para el usuario con rol: " + role);
        }
    }

    public EmpleadoDto maperaEmpleadoAEmpleadoDto(@Valid Empleado empleado){
        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setCedula(empleado.getCedulaEmpleado());
        empleadoDto.setNombre(empleado.getNombre());
        empleadoDto.setApellido(empleado.getApellido());
        empleadoDto.setCelular(empleado.getCelular());
        empleadoDto.setCiudad(empleado.getCiudad());
        empleadoDto.setDireccionResidencia(empleado.getDireccionResidencia());
        empleadoDto.setEmail(empleado.getEmail());


        return empleadoDto;
    }


    public EmpleadoDto addEmpleado(EmpleadoDto empleadoDto) {

        if (empleadoDto == null){
            throw new IllegalArgumentException("El empleado no puede ser nulo ");
        }
        if (empleadoDto.getCedula() == null || empleadoDto.getNombre() == null || empleadoDto.getApellido() == null) {
            throw new IllegalArgumentException("la cedula, el apellido o el nombre son invalidos");
        }

        Empleado empleado = new Empleado(
            empleadoDto.getCedula(),
            empleadoDto.getNombre(),
            empleadoDto.getApellido(),
            empleadoDto.getCelular(),
                empleadoDto.getEmail(),
                empleadoDto.getDireccionResidencia(),
                empleadoDto.getCiudad(),
                empleadoDto.getAntiguedadEmpresa(),
                empleadoDto.getTipoSangre(),
                empleadoDto.getTipo()
        );
        empleadoRepository.save(empleado);
        return empleadoDto;
    }

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado findEmpleadoById(Integer cedulaEmpleado) {

        return empleadoRepository.findById(cedulaEmpleado)
                .orElseThrow(() -> new IllegalArgumentException("No se encontro el empleado"));
        /*
        Optional<Empleado> employable = empleadoRepository.findById(cedulaEmpleado);
        return employable.orElse(null);
         */
    }

    @Transactional
    public Empleado updateEmpleado(Integer cedulaEmpleado, Empleado empleado) {
        if (empleado == null){
            throw new IllegalArgumentException("El cliente no debe ser nulo");
        }

        if (!empleadoRepository.existsById(cedulaEmpleado)) {
            throw new IllegalArgumentException("No existe el cliente con id " + cedulaEmpleado);
        }

        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(Integer cedulaEmpleado) {
        if (cedulaEmpleado == null){
            throw new IllegalArgumentException("La cedula  no debe ser nulo");
        }
        Optional<Empleado> empleado = this.empleadoRepository.findById(cedulaEmpleado);
        if (empleado.isEmpty()){
            throw new IllegalArgumentException("El empleado con la cedula  " + cedulaEmpleado + "no existe");
        }
        Empleado empleadoEncontrado = empleado.get();
        empleadoRepository.delete(empleado.get());
    }
}

