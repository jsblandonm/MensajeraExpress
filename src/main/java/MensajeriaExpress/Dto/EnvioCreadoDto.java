package MensajeriaExpress.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnvioCreadoDto {
    private Integer numeroGuia;
    private String estado = "ENTREGADO";

    public EnvioCreadoDto() {
    }

    public EnvioCreadoDto(Integer numeroGuia, String estado) {
        this.numeroGuia = numeroGuia;
        this.estado = estado;
    }

}
