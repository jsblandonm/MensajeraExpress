package MensajeriaExpress.service;


import MensajeriaExpress.entity.Empleado;
import MensajeriaExpress.repository.EmployableRepository;
import MensajeriaExpress.repository.IEmployableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployableService implements IEmployableRepository {
    private final EmployableRepository empleadoRepository;

    @Autowired
    public EmployableService(EmployableRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado findEmpleadoById(Integer id) {
        Optional<Empleado> employable = empleadoRepository.findById(id);
        return employable.orElse(null);
    }

    @Override
    public Empleado addEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpleado(Integer id, Empleado empleado) {

        if (empleadoRepository.existsById(id)) {
            empleado.setCedulaEmpleado(id);
            return empleadoRepository.save(empleado);
        }
        return null;
    }

    @Override
    public void deleteEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
