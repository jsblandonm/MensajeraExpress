package MensajeriaExpress.state;

import MensajeriaExpress.entity.Envio;

public class EstadoRecibido implements EnvioState{
    @Override
    public EnvioState next(Envio envio) {
        return new EstadoEnRuta();
    }


    /*@Override
    public String cambiarEstado(EnvioEstadoDto envioEstadoDto) {
        envioEstadoDto.setEstado(new EstadoEnRuta());
        return EstadoEnvio.EN_RUTA.getEstado();
    }*/
/*
    @Override
    public String getEstado() {
        return RECIBIDO;
    }

 */
}
