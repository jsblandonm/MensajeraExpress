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
    @Column(name = "identificacion_empleado")
    private Integer cedulaEmpleado;

    @NotNull
    @Size(max = 30)
    @Column(name = "nombre_empleado")
    private String nombre;

    @NotNull
    @Size(max = 30)
    @Column(name = "apellido_empleado")
    private String apellido;

    @NotNull
    @Size(max = 50)
    @Column(name = "celular_empleado")
    private String celular;

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

    @Column(name = "tipo-Empleado")
    private String tipo;


/*
    @Column(name="tipo_empleado")
    @Enumerated(EnumType.STRING)
    private TipoEmpleado tipoEmpleado;

    public enum TipoEmpleado {
        CONDUCTOR,
        REPARTIDOR,
        COORDINADOR
    }


 */

        //Relaciones base de datos

    @OneToMany(mappedBy = "empleado")
    @JsonIgnore
    private List<Envio> envios;


    public Empleado() {

    }

    public Empleado(Integer cedulaEmpleado, String nombre, String apellido, String celular, String email, String direccionResidencia, String ciudad, Integer antiguedadEmpresa, String tipoSangre, String tipo, List<Envio> envios) {
        this.cedulaEmpleado = cedulaEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
        this.antiguedadEmpresa = antiguedadEmpresa;
        this.tipoSangre = tipoSangre;
        this.tipo = tipo;
        this.envios = envios;
    }

    public Empleado(Integer cedulaEmpleado, String nombre, String apellido, String celular, String email, String direccionResidencia, String ciudad, Integer antiguedadEmpresa, String tipoSangre, String tipo) {
        this.cedulaEmpleado = cedulaEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
        this.antiguedadEmpresa = antiguedadEmpresa;
        this.tipoSangre = tipoSangre;
        this.tipo = tipo;
    }
}
