package MensajeriaExpress.service;

import MensajeriaExpress.Dto.EnvioDto;
import MensajeriaExpress.entity.Envio;
import MensajeriaExpress.repository.EnvioRepository;
import MensajeriaExpress.repository.IEnvioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnvioService{
    private List<Envio> envios;

    private final EnvioRepository envioRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
        this.envios = new ArrayList<>();
    }

    public EnvioDto addEnvio(EnvioDto envioDto){
        if (envioDto == null){
            throw new IllegalArgumentException("El envio no pude ser nulo");
        }
        Envio envio = new Envio(
                envioDto.getNumeroGuia(),
                envioDto.getClienteId(),
                envioDto.getCiudadOrigen(),
                envioDto.getCiudadDestino(),
                envioDto.getDireccionDestino(),
                envioDto.getDestinatario(),
                envioDto.getCelularDestinatario(),
                envioDto.getHoraEntrega(),
                envioDto.getEstado(),
                envioDto.getValorEnvio(),
                envioDto.getIdPaquete(),
                envioDto.getCliente,
                envioDto.getEmpleado()
        );

        envioRepository.save(envio);
        return envioDto;
    }

    public List<Envio> getAllEnvios() {
        return null;
    }

    public Envio findById(Long numeroGuia) {
        Optional<Envio> envio = envioRepository.findById(Math.toIntExact(numeroGuia));
        return envio.orElse(null);
    }

    public Envio updateEnvio(Long numeroGuia, Envio envio) {
        if (!envioRepository.existsById(Math.toIntExact(numeroGuia))){
            throw new IllegalArgumentException("no existe envio con ese  numero de guia " + numeroGuia);
        }

        return envioRepository.save(envio);
    }

    public void deleteEnvio(Long numeroGuia) {
        if (numeroGuia == null){
            throw new IllegalArgumentException("EL numero de guia no puede ser nulo");
        }
        Optional<Envio> envio = this.envioRepository.findById(Math.toIntExact(numeroGuia));
        if (Envio.isEmpity()){
            throw new IllegalArgumentException("El envio con numero de guia " + numeroGuia + "Fue borrado exitosamente");
        }

        Envio envioEncontrado = envio.get();
        envioRepository.delete(envio.get());
    }


}

