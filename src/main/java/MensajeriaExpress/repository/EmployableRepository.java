package MensajeriaExpress.repository;

import MensajeriaExpress.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployableRepository extends JpaRepository<Empleado, Integer> {
}
