package MensajeriaExpress.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    @Column(name = "identificacion_cliente")
    @Max(value = 10, message = "La cédula debe ser de 10")
    private Integer cedulaCliente;

    @NotNull
    @Size(max = 50)
    @Column(name = "nombre_cliente")
    private String nombre;

    @NotNull
    @Size(max = 50)
    @Column(name = "apellido_cliente")
    private String apellido;

    @NotNull
    @Size(max = 30)
    @Column(name = "celular_cliente")
    private String celular;

    @NotNull
    @Size(max = 50)
    @Column(name = "email_cliente")
    private String email;

    @NotNull
    @Size(max = 50)
    @Column(name = "direccion_cliente")
    private String direccionResidencia;

    @NotNull
    @Size(max = 100)
    @Column(name = "ciudad_cliente")
    private String ciudad;

    /*
    //Security
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns =  @JoinColumn(name = "role_id"))
    private Set<Role> roles;

     */


    //Relacion base de datos

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Envio> envios;


    public Cliente(Integer cedulaCliente, String nombre, String apellido, String celular, String email, String direccionResidencia, String ciudad) {
        this.cedulaCliente = cedulaCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
    }

}
