package MensajeriaExpress.Dto;

public class EmpleadoDto {

    private Integer cedulaEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private Integer celularEmpleado;
    private String email;
    private String direccionResidencia;
    private String ciudad;
    private Integer antiguedadEmpresa;
    private String tipoSangre;
    private String tipo;

    public EmpleadoDto() {
    }

    public EmpleadoDto(Integer cedulaEmpleado, String nombreEmpleado, String apellidoEmpleado, Integer celularEmpleado, String email, String direccionResidencia, String ciudad, Integer antiguedadEmpresa, String tipoSangre, String tipo) {
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
    }

    public Integer getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(Integer cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public Integer getCelularEmpleado() {
        return celularEmpleado;
    }

    public void setCelularEmpleado(Integer celularEmpleado) {
        this.celularEmpleado = celularEmpleado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getAntiguedadEmpresa() {
        return antiguedadEmpresa;
    }

    public void setAntiguedadEmpresa(Integer antiguedadEmpresa) {
        this.antiguedadEmpresa = antiguedadEmpresa;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
