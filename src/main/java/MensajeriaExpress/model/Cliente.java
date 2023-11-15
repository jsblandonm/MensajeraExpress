package MensajeriaExpress.model;

public class Cliente extends Usuario{
    public Cliente(Integer cedula, String nombre, String apellido, String celular, String email, String direccionResidencia, String ciudad) {
        super(cedula, nombre, apellido, celular, email, direccionResidencia, ciudad);
    }
}
