package MensajeriaExpress.repository;

import MensajeriaExpress.entity.Paquete;

import java.util.List;

public interface IPaqueteRepsitory {
    List<Paquete> getAllPaquetes();
    Paquete findPaqueteById(Long codigoPaquete);
    Paquete addPaquete(Paquete paquete);
    Paquete updatePaquete(Long codigoPaquete, Paquete paquete);
    void deletePaquete(Long codigoPaquete);

}
