package MensajeriaExpress.service;


import MensajeriaExpress.repository.PaqueteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaqueteService{

    private final PaqueteRepository paqueteRepository;

    @Autowired
    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

}
