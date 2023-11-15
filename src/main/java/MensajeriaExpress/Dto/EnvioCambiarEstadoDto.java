package MensajeriaExpress.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnvioCambiarEstadoDto {

    private Integer numeroGuia;
    private String estado;
    private Integer cedulaEmpleado;

    public EnvioCambiarEstadoDto() {
    }

    public EnvioCambiarEstadoDto(Integer numeroGuia, String estado, Integer cedulaEmpleado) {
        this.numeroGuia = numeroGuia;
        this.estado = estado;
        this.cedulaEmpleado = cedulaEmpleado;
    }

}
