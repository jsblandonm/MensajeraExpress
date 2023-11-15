package MensajeriaExpress.model;

import MensajeriaExpress.entity.Paquete;

import java.time.LocalDate;

public class EnvioModel {
    private String numeroGuia;
    private Cliente cliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String destinatario;
    private String celularDestinatario;
    private LocalDate horaEntrega;
    private String estado;
    private double valorEnvio;
    private Paquete paquete;

    public EnvioModel() {
    }

    public EnvioModel(String numeroGuia, Cliente cliente, String ciudadOrigen, String ciudadDestino, String direccionDestino, String destinatario, String celularDestinatario, LocalDate horaEntrega, String estado, double valorEnvio, Paquete paquete) {
        this.numeroGuia = numeroGuia;
        this.cliente = cliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.destinatario = destinatario;
        this.celularDestinatario = celularDestinatario;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
        this.valorEnvio = valorEnvio;
        this.paquete = paquete;
    }

    public EnvioModel(Cliente cliente, String ciudadOrigen, String ciudadDestino, String direccionDestino, String destinatario, String celularDestinatario, double valorEnvio, Paquete paquete) {
        this.cliente = cliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.destinatario = destinatario;
        this.celularDestinatario = celularDestinatario;
        this.valorEnvio = valorEnvio;
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "numeroGuia='" + numeroGuia + '\'' +
                ", cliente=" + cliente +
                ", ciudadOrigen='" + ciudadOrigen + '\'' +
                ", ciudadDestino='" + ciudadDestino + '\'' +
                ", direccionDestino='" + direccionDestino + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", celularDestinatario='" + celularDestinatario + '\'' +
                ", horaEntrega=" + horaEntrega +
                ", estado='" + estado + '\'' +
                ", valorEnvio=" + valorEnvio +
                ", paquete=" + paquete +
                '}';
    }

    public double calcularValorEnvio(String tipo){
        if (tipo.equals("LIVIANO")){
            return 30000;
        } else if (tipo.equals("MEDIANO")) {
            return 40000;
        } else if (tipo.equals("GRANDE")) {
            return 50000;
        }else {
            throw new IllegalArgumentException("El valor ingresad no pertenece a un tamaño de paquete");
        }
    }
}
