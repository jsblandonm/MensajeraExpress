package MensajeriaExpress.state;

import MensajeriaExpress.entity.Envio;
import org.springframework.stereotype.Component;


public interface EnvioState {

    EnvioState next(Envio envio );

/*
    String RECIBIDO = "RECIBIDO";
    String EN_RUTA = "EN_RUTA";
    String ENTREGADO = "ENTREGADO";

    String getEstado();

 */
}
