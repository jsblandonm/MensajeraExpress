package MensajeriaExpress.Dto;

import MensajeriaExpress.User.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoDto {

    private Integer cedula;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String direccionResidencia;
    private String ciudad;
    private Integer antiguedadEmpresa;
    private String tipoSangre;
    private String tipo;
    private Role role;

    public EmpleadoDto() {
    }

    public EmpleadoDto(Role role,Integer cedula, String nombre, String apellido, String celular, String email, String direccionResidencia, String ciudad, Integer antiguedadEmpresa, String tipoSangre, String tipo) {
        this.cedula = cedula;
        this.role = role;
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
