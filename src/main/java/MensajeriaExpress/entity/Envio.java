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
        private Integer numeroGuia;


        /*
        @Column(name = "ClienteId_envio")
        private Integer clienteId;

         */

        @NotNull

        @Column(name = "ciudadOrigen_envio")
        private String ciudadOrigen;

        @NotNull

        @Column(name = "ciudadDestino_envio")
        private String ciudadDestino;

        @NotNull

        @Column(name = "direccionDestino_envio")
        private String direccionDestino;

        @NotNull

        @Column(name = "destinatario_envio")
        private String destinatario;

        @NotNull
        @Column(name = "celularDestinatario_envio")
        private String celularDestinatario;

        @NotNull

        @Column(name = "horaEntrega_envio")
        private String horaEntrega;

        @NotNull
        @Column(name = "estado-Envio")
        private String estado;

        @NotNull

        @Column(name = "costo_envio")
        private Double valorEnvio;

        /*

        @Column(name = "id_Paquete")
        private Integer id_Paquete;

         */

        //Relaciones base de datos

        @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinColumn(name = "cedulaCliente")
        @JsonBackReference
        private Cliente cliente;

        @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinColumn(name = "cedualEmpleado")
        @JsonBackReference
        private Empleado empleado;

        @OneToMany(mappedBy = "envio")
        @JsonIgnore
        private List<Paquete> paquetes;




        public Envio() {
        }

        public Envio(Integer numeroGuia, String ciudadOrigen, String ciudadDestino, String direccionDestino, String destinatario, String celularDestinatario, String horaEntrega, String estado, Double valorEnvio, Cliente cliente, Empleado empleado, List<Paquete> paquetes) {
            this.numeroGuia = numeroGuia;
            this.ciudadOrigen = ciudadOrigen;
            this.ciudadDestino = ciudadDestino;
            this.direccionDestino = direccionDestino;
            this.destinatario = destinatario;
            this.celularDestinatario = celularDestinatario;
            this.horaEntrega = horaEntrega;
            this.estado = estado;
            this.valorEnvio = valorEnvio;
            this.cliente = cliente;
            this.empleado = empleado;
            this.paquetes = paquetes;
        }

        public Envio( String ciudadOrigen, String ciudadDestino, String direccionDestino, String destinatario, String celularDestinatario, String horaEntrega, String estado, Double valorEnvio, Cliente cliente, Empleado empleado) {
            this.ciudadOrigen = ciudadOrigen;
            this.ciudadDestino = ciudadDestino;
            this.direccionDestino = direccionDestino;
            this.destinatario = destinatario;
            this.celularDestinatario = celularDestinatario;
            this.horaEntrega = horaEntrega;
            this.estado = estado;
            this.valorEnvio = valorEnvio;
            this.cliente = cliente;
            this.empleado = empleado;
        }

    }
