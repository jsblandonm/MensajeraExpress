package MensajeriaExpress.service;


import MensajeriaExpress.Dto.EmpleadoDto;
import MensajeriaExpress.entity.Empleado;
import MensajeriaExpress.repository.EmployableRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployableService{

    public List<Empleado> empleados;
    private final EmployableRepository empleadoRepository;

    @Autowired
    public EmployableService(EmployableRepository empleadoRepository) {

        this.empleadoRepository = empleadoRepository;
        this.empleados = new ArrayList<>();
    }

    public EmpleadoDto addEmpleado(EmpleadoDto empleadoDto) {

        if (empleadoDto == null){
            throw new Error("El empleado no puede ser nulo ");
        }
        if (empleadoDto.getCedulaEmpleado() == null || empleadoDto.getApellidoEmpleado() == null || empleadoDto.getNombreEmpleado() == null) {
            throw new Error("la cedula, el apellido o el nombre son invalidos");
        }

        Empleado empleado = new Empleado(
            empleadoDto.getCedulaEmpleado(),
            empleadoDto.getNombreEmpleado(),
            empleadoDto.getApellidoEmpleado(),
            empleadoDto.getCelularEmpleado(),
                empleadoDto.getEmail(),
                empleadoDto.getDireccionResidencia(),
                empleadoDto.getCiudad(),
                empleadoDto.getAntiguedadEmpresa(),
                empleadoDto.getTipoSangre(),
                Empleado.tipoEmpleado.COORDINADOR
        );
        empleadoRepository.save(empleado);
        return empleadoDto;
    }

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado findEmpleadoById(Integer cedulaEmpleado) {
        Optional<Empleado> employable = empleadoRepository.findById(cedulaEmpleado);
        return employable.orElse(null);
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

