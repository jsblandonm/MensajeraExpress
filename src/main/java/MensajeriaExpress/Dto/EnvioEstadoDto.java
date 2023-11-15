package MensajeriaExpress.Dto;


import MensajeriaExpress.service.EstadoEnvio;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
public class EnvioEstadoDto {

    public EstadoEnvio estadoEnvio;

    public EnvioEstadoDto(EstadoEnvio estadoEnvio){
        this.estadoEnvio = estadoEnvio;
    }
}
