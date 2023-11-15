package MensajeriaExpress.model;

public class Empleado extends Usuario{
    private double antiguedad;
    private String tipoSangre;
    private String tipo;

    public Empleado(Integer cedula, String nombre, String apellido, String celular, String email, String direccionResidencia, String ciudad, double antiguedad, String tipoSangre, String tipo) {
        super(cedula, nombre, apellido, celular, email, direccionResidencia, ciudad);
        this.antiguedad = antiguedad;
        this.tipoSangre = tipoSangre;
        this.tipo = tipo;
    }
}
