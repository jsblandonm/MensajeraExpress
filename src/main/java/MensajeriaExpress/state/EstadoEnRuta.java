package MensajeriaExpress.state;

import MensajeriaExpress.entity.Envio;

public class EstadoEnRuta implements EnvioState{
    @Override
    public EnvioState next(Envio envio) {
        return new EstadoEntregado();
    }

    /*@Override
    public String getEstado(){
        return EN_RUTA;
    }

     */

    /*@Override
    public String cambiarEstado(EnvioEstadoDto envioEstadoDto) {
        envioEstadoDto.setEstado(new EstadoEntregado());
        return EstadoEnvio.ENTREGADO.getEstado();
    }*/
}
