package MensajeriaExpress.service;

import MensajeriaExpress.entity.Paquete;
import MensajeriaExpress.repository.IPaqueteRepsitory;
import MensajeriaExpress.repository.PaqueteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaqueteService implements IPaqueteRepsitory {

    private final PaqueteRepository paqueteRepository;

    @Autowired
    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    @Override
    public List<Paquete> getAllPaquetes() {
        return paqueteRepository.findAll();
    }

    @Override
    public Paquete findPaqueteById(Long codigoPaquete) {
        Optional<Paquete> paquete = paqueteRepository.findById(codigoPaquete);
        return paquete.orElse(null);
    }

    @Override
    public Paquete addPaquete(@Valid Paquete paquete) {
        return paqueteRepository.save(paquete);
    }

    @Override
    public Paquete updatePaquete(Long codigoPaquete, Paquete paquete) {
        return null;
    }

    @Override
    public void deletePaquete(Long codigoPaquete) {

    }
}
