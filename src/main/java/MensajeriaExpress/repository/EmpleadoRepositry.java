package MensajeriaExpress.repository;

import MensajeriaExpress.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositry extends JpaRepository<Empleado, Integer> {
}
