package MensajeriaExpress.repository;

import MensajeriaExpress.entity.Empleado;

import java.util.List;

public interface IEmployableRepository {
    List<Empleado> getAllEmpleados();
    Empleado findEmpleadoById(Integer cedulaEmpleado);
    Empleado addEmpleado(Empleado empleado);
    Empleado updateEmpleado(Integer cedulaEmpleado, Empleado empleado);
    void deleteEmpleado(Integer cedulaEmpleado);

}
