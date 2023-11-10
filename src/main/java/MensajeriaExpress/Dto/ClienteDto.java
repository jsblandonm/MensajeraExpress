package MensajeriaExpress.Dto;

public class ClienteDto {

    private Integer cedulaCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String celularCliente;
    private String emailCliente;

    private String direccionResidencia;
    private String ciudad;

    public ClienteDto() {
    }

    public ClienteDto(Integer cedulaCliente, String nombreCliente, String apellidoCliente, String celularCliente, String emailCliente, String direccionResidencia, String ciudad) {
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.celularCliente = celularCliente;
        this.emailCliente = emailCliente;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
    }

    public Integer getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Integer cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
