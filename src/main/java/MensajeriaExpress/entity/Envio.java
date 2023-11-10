package MensajeriaExpress.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="envios")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroGuia_envio")
    private Long numeroGuia;

    @NotNull
    @Column(name = "ClienteId_envio")
    private Integer clienteId;

    @NotNull
    @Size(max = 30)
    @Column(name = "ciudadOrigen_envio")
    private String ciudadOrigen;

    @NotNull
    @Size(max = 30)
    @Column(name = "ciudadDestino_envio")
    private String ciudadDestino;

    @NotNull
    @Size(max = 30)
    @Column(name = "direccionDestino_envio")
    private String direccionDestino;

    @NotNull
    @Size(max = 50)
    @Column(name = "destinatario_envio")
    private String destinatario;

    @NotNull
    @Size(max = 50)
    @Column(name = "celularDestinatario_envio")
    private String celularDestinatario;

    @NotNull
    @Size(max = 50)
    @Column(name = "horaEntrega_envio")
    private LocalDate horaEntrega;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado-Envio")
    private  estadoEnvio estado;
    public enum estadoEnvio{
        RECIBIDO, ENRUTA, ENTREGADO
    }

    @NotNull
    @Size(max = 50)
    @Column(name = "costo_envio")
    private Double valorEnvio;

    @NotNull
    @Column(name = "id_Paquete")
    private Integer idPaquete;

    //Relaciones base de datos

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cedulaCliente")
    @JsonBackReference
    private Cliente cliente;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cedulaEmpleado")
    @JsonBackReference
    private Empleado empleado;


    @OneToMany(mappedBy = "envio")
    @JsonIgnore
    private List<Paquete> paquetes;


    public Envio() {
    }

    public Envio(Long numeroGuia, Integer clienteId, String ciudadOrigen, String ciudadDestino, String direccionDestino, String destinatario, String celularDestinatario, LocalDate horaEntrega, estadoEnvio estado, Double valorEnvio, Integer idPaquete, Cliente cliente, Empleado empleado) {
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
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public Envio(Long numeroGuia, Integer clienteId, String ciudadOrigen, String ciudadDestino, String direccionDestino, String destinatario, String celularDestinatario, LocalDate horaEntrega, estadoEnvio estado, Double valorEnvio, Integer idPaquete) {
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
}
