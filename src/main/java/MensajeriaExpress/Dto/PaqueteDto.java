package MensajeriaExpress.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaqueteDto {

    private Integer codigoPaquete;

    enum TipoPaquete {
        LIVIANO,
        MEDIANO,
        PESADO
    }

    private TipoPaquete tipo;
    private Double peso;
    private Double valorDeclarado;

    public PaqueteDto() {
    }

    public PaqueteDto(Integer codigoPaquete, TipoPaquete tipo, Double peso, Double valorDeclarado) {
        this.codigoPaquete = codigoPaquete;
        this.tipo = tipo;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }
}
