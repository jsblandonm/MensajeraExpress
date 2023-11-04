package MensajeriaExpress.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "empleados")
public class Empleado{

    @Id
    @NotNull
    @Column(name = "identificacion_empleado")
    private Integer cedulaEmpleado;

    @NotNull
    @Size(max = 30)
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;

    @NotNull
    @Size(max = 30)
    @Column(name = "apellido_empleado")
    private String apellidoEmpleado;

    @NotNull
    @Size(max = 50)
    @Column(name = "celular_empleado")
    private String celularEmpleado;

    @NotNull
    @Size(max = 100)
    @Column(name = "email_empleado")
    private String email;

    @NotNull
    @Size(max = 50)
    @Column(name = "direccion_empleado")
    private String direccionResidencia;

    @NotNull
    @Size(max = 100)
    @Column(name = "ciudad_empleado")
    private String ciudad;

    @NotNull
    @Column(name = "antiguedadEmpresa_empleado")
    private Integer antiguedadEmpresa;

    @NotNull
    @Size(max = 5)
    @Column(name = "tipoSangre_empleado")
    private String tipoSangre;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo-Empleado")
    private tipoEmpleado tipo;
    public enum tipoEmpleado{
        CONDUCTOR, REPARTIDOR, COORDINADOR
    }

    //Relaciones base de datos

    @OneToMany(mappedBy = "empleado")
    @JsonIgnore
    private List<Envio> envios;


    public Empleado() {

    }

    public Empleado(Integer cedulaEmpleado, String nombreEmpleado, String apellidoEmpleado, String  celularEmpleado, String email, String direccionResidencia, String ciudad, Integer antiguedadEmpresa, String tipoSangre, tipoEmpleado tipo, List<Envio> envios) {
        this.cedulaEmpleado = cedulaEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.celularEmpleado = celularEmpleado;
        this.email = email;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
        this.antiguedadEmpresa = antiguedadEmpresa;
        this.tipoSangre = tipoSangre;
        this.tipo = tipo;
        this.envios = envios;
    }
}
