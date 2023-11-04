package MensajeriaExpress.service;

import MensajeriaExpress.entity.Envio;
import MensajeriaExpress.repository.EnvioRepository;
import MensajeriaExpress.repository.IEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService implements IEnvioRepository {

    private final EnvioRepository envioRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }


    @Override
    public List<Envio> getAllEnvios() {
        return null;
    }

    @Override
    public Envio findById(Long numeroGuia) {
        return null;
    }

    @Override
    public Envio addEnvio(Envio envio) {
        return null;
    }

    @Override
    public Envio updateEnvio(Long numeroGuia, Envio envio) {
        return null;
    }

    @Override
    public void deleteEnvio(Long numeroGuia) {

    }
}