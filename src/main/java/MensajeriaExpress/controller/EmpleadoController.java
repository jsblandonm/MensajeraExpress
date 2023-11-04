package MensajeriaExpress.controller;

import MensajeriaExpress.entity.Empleado;
import MensajeriaExpress.service.EmployableService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmployableService empleadoService;

    @Autowired
    public EmpleadoController(EmployableService empleadoService) {
        this.empleadoService = empleadoService;
    }


    @GetMapping
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getAllEmpleados();
    }
    @GetMapping("/{cedulaEmpleado}")
    public Empleado findEmpleadoById(@PathVariable  Integer cedulaEmpleado){
        if(cedulaEmpleado == null) {
            throw new RuntimeException("El id del empleado es requerido");
        }
        Empleado empleado = empleadoService.findEmpleadoById(cedulaEmpleado);
        if (empleado == null){
            throw new RuntimeException("No existe empleado con id "+ cedulaEmpleado);
        }
        return empleado;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado addEmpleado(@Valid @RequestBody Empleado empleado){
        return empleadoService.addEmpleado(empleado);
    }


    @PutMapping("/{cedulaEmpleado}")
    public Empleado updateEmpleado(@PathVariable Integer cedulaEmpleado, @RequestBody Empleado empleado){
        return empleadoService.updateEmpleado(cedulaEmpleado, empleado);
    }
    @DeleteMapping("/{cedulaEmpleado}")
    public  void deleteEmpleado(@PathVariable Integer cedulaEmpleado){
        empleadoService.deleteEmpleado(cedulaEmpleado);
    }
}
