package MensajeriaExpress.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnvioDetalleDto {

    private final Integer numeroGuia;
    private final Integer cedulaCliente;
    private final String nombreCliente;
    private final String ciudadOrigen;
    private final String ciudadDestino;
    private final String direccionDestino;
    private final String destinatario;
    private final String celularDestinatario;
    private final double valorDeclarado;
    private final double peso;
    private final double valorEnvio;

    public EnvioDetalleDto(Integer numeroGuia, @NotNull @Size(max = 30) Integer cedulaCliente, String nombreCliente, String ciudadOrigen, String ciudadDestino, String direccionDestino, @NotNull @Size(max = 50) String destinatario, @NotNull @Size(max = 50) String celularDestinatario, double valorDeclarado, double peso, @NotNull @Size(max = 50) double valorEnvio) {
        this.numeroGuia = numeroGuia;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.destinatario = String.valueOf(destinatario);
        this.celularDestinatario = String.valueOf(celularDestinatario);
        this.valorDeclarado = valorDeclarado;
        this.peso = peso;
        this.valorEnvio = Double.parseDouble(String.valueOf(valorEnvio));
    }
}
