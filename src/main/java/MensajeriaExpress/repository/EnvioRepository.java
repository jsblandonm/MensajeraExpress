package MensajeriaExpress.repository;

import MensajeriaExpress.entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends JpaRepository<Envio , Integer> {

    @Query(value = "select * from envio where estado =: estado", nativeQuery = true)
    List<Envio> filtrarPorEstado(@Param("esrado") String tipo);
}
