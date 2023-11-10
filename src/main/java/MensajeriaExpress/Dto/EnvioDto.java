package MensajeriaExpress.Dto;

import MensajeriaExpress.entity.Envio;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class EnvioDto {

    private Long numeroGuia;
    private  Integer clienteId;
    private String  ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String destinatario;
    private String celularDestinatario;
    private String horaEntrega;
    private String estado;
    private Double valorEnvio;
    private Integer idPaquete;

    public EnvioDto() {
    }

    public EnvioDto(Long numeroGuia, Integer clienteId, String ciudadOrigen, String ciudadDestino, String direccionDestino, String destinatario, String celularDestinatario, String horaEntrega, String estado, Double valorEnvio, Integer idPaquete) {
        this.numeroGuia = numeroGuia;
        this.clienteId = clienteId;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.destinatario = destinatario;
        this.celularDestinatario = celularDestinatario;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
        this.valorEnvio = valorEnvio;
        this.idPaquete = idPaquete;
    }

    public Long getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(Long numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCelularDestinatario() {
        return celularDestinatario;
    }

    public void setCelularDestinatario(String celularDestinatario) {
        this.celularDestinatario = celularDestinatario;
    }

    public @NotNull @Size(max = 50) LocalDate getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Envio.@NotNull estadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(Double valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }
}
