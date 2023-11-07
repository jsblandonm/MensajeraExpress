package MensajeriaExpress.Dto;

public class PaqueteDto {

    private Long codigoPaquete;
    private String tipo;

    private Double peso;
    private Double valorDeclarado;

    public PaqueteDto() {
    }

    public PaqueteDto(Long codigoPaquete, String tipo, Double peso, Double valorDeclarado) {
        this.codigoPaquete = codigoPaquete;
        this.tipo = tipo;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }

    public Long getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(Long codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(Double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }
}
