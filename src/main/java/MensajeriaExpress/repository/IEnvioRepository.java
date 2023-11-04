package MensajeriaExpress.repository;

import MensajeriaExpress.entity.Envio;

import java.util.List;

public interface IEnvioRepository {

    List<Envio> getAllEnvios();
    Envio findById(Long numeroGuia);
    Envio addEnvio(Envio envio);
    Envio updateEnvio(Long numeroGuia, Envio envio);
    void deleteEnvio(Long numeroGuia);


}
