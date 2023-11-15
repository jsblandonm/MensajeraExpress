package MensajeriaExpress.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Integer cedula;
    private String nombre;
    private String apellido;
    private String celular;
    @Email
    @NotBlank
    private String email;
    private String direccionResidencia;
    private String ciudad;

    /*
    //Security

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    private Set<String> roles;
    */



}


