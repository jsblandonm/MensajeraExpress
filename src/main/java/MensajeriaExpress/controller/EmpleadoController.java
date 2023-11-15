package MensajeriaExpress.controller;

import MensajeriaExpress.Dto.EmpleadoDto;
import MensajeriaExpress.entity.Empleado;
import MensajeriaExpress.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoDto addEmpleado(@Valid @RequestBody EmpleadoDto empleadoDto){
        return empleadoService.addEmpleado(empleadoDto);
    }

    @GetMapping
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/{cedulaEmpleado}")
    public EmpleadoDto findEmpleadoById(@PathVariable  Integer cedulaEmpleado){
        Empleado empleado = empleadoService.findEmpleadoById(cedulaEmpleado);

        if(empleado == null) {
            throw new Error("No existe el empleado con id " + cedulaEmpleado);
        }

        return maperaEmpleadoAEmpleadoDto(empleado);
    }

    @PutMapping("/{cedulaEmpleado}")
    public EmpleadoDto updateEmpleado(@PathVariable Integer cedulaEmpleado, @Valid @ RequestBody EmpleadoDto empleadoDto){
        if (empleadoDto == null){
            throw  new Error("el id del empleado es requerido");
        }
        Empleado empleado = maperaEmpleadoDtoAEmpleado(empleadoDto);
        empleado = empleadoService.updateEmpleado(cedulaEmpleado,empleado);
        return maperaEmpleadoAEmpleadoDto(empleado);
    }


    @DeleteMapping("/{cedulaEmpleado}")
    public  void deleteEmpleado(@PathVariable Integer cedulaEmpleado) {
        empleadoService.deleteEmpleado(cedulaEmpleado);
    }



    public Empleado maperaEmpleadoDtoAEmpleado(@Valid EmpleadoDto empleadoDto){
        Empleado empleado = new Empleado();

        empleado.setCedulaEmpleado(empleadoDto.getCedula());
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setApellido(empleadoDto.getApellido());
        empleado.setCelular(empleadoDto.getCelular());
        empleado.setEmail(empleadoDto.getEmail());
        empleado.setAntiguedadEmpresa(empleadoDto.getAntiguedadEmpresa());
        empleado.setCiudad(empleadoDto.getCiudad());
        empleado.setDireccionResidencia(empleadoDto.getDireccionResidencia());
        empleado.setTipoSangre(empleadoDto.getTipoSangre());
        empleado.setTipo(empleadoDto.getTipo());
        return empleado;
    }

   public EmpleadoDto maperaEmpleadoAEmpleadoDto(@Valid Empleado empleado){
        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setCedula(empleado.getCedulaEmpleado());
       empleadoDto.setNombre(empleado.getNombre());
       empleadoDto.setApellido(empleado.getApellido());
       empleadoDto.setCelular(empleado.getCelular());
       empleadoDto.setEmail(empleado.getEmail());
       empleadoDto.setAntiguedadEmpresa(empleado.getAntiguedadEmpresa());
       empleadoDto.setCiudad(empleado.getCiudad());
       empleadoDto.setDireccionResidencia(empleado.getDireccionResidencia());
       empleadoDto.setTipoSangre(empleado.getTipoSangre());
       empleadoDto.setTipo(empleadoDto.getTipo());

        return empleadoDto;
    }

}

