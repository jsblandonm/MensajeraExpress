package MensajeriaExpress.state;

import MensajeriaExpress.entity.Envio;

public class EstadoEntregado implements EnvioState{
    @Override
    public EnvioState next(Envio envio) {
        throw new IllegalArgumentException("El envio ya fue entregado");
    }

    /*@Override
    public String cambiarEstado(EnvioEstadoDto envioEstadoDto) {
        return "Error: El paquete ya ha sido entregado";
    }*/
/*
    @Override
    public String getEstado() {
        return ENTREGADO;
    }

 */
}
