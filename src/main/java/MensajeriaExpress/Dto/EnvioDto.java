package MensajeriaExpress.Dto;

import MensajeriaExpress.entity.Envio;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EnvioDto {
    private Integer cedulaEmpleado;
    private Integer cedulaCliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String destinatario;
    private String celularDestinatario;
    private Double peso;
    private Double valorDeclarado;

    public EnvioDto() {
    }

    public EnvioDto(Integer cedulaEmpleado, Integer cedulaCliente, String ciudadOrigen, String ciudadDestino, String direccionDestino, String destinatario, String celularDestinatario, Double peso, Double valorDeclarado) {
        this.cedulaEmpleado = cedulaEmpleado;
        this.cedulaCliente = cedulaCliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.destinatario = destinatario;
        this.celularDestinatario = celularDestinatario;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }
}
