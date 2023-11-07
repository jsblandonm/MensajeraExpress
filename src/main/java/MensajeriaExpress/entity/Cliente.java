package MensajeriaExpress.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @NotNull
    //@Max(value = 15, message = "El valor maximo para la cedula es de 10 digitos")
    @Column(name = "identificacion_cliente")
    private Integer cedulaCliente;

    @NotNull
    @Size(max = 50)
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @NotNull
    @Size(max = 50)
    @Column(name = "apellido_cliente")
    private String apellidoCliente;

    @NotNull
    @Size(max = 30)
    @Column(name = "celular_cliente")
    private String celularCliente;

    @NotNull
    @Size(max = 50)
    @Column(name = "email_cliente")
    private String emailCliente;

    @NotNull
    @Size(max = 50)
    @Column(name = "direccion_cliente")
    private String direccionResidencia;

    @NotNull
    @Size(max = 100)
    @Column(name = "ciudad_cliente")
    private String ciudad;

    //Relacion base de datos

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Envio> envios;


    public Cliente() {
    }

    public Cliente(Integer cedulaCliente, String nombreCliente, String apellidoCliente, String celularCliente, String emailCliente, String direccionResidencia, String ciudad, List<Envio> envios) {
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.celularCliente = celularCliente;
        this.emailCliente = emailCliente;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
        this.envios = envios;
    }

    public Cliente(Integer cedulaCliente, String nombreCliente, String apellidoCliente, String celularCliente, String emailCliente, String direccionResidencia, String ciudad) {
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.celularCliente = celularCliente;
        this.emailCliente = emailCliente;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
    }
}
