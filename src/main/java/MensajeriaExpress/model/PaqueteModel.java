package MensajeriaExpress.model;


import lombok.Getter;

@Getter
public class PaqueteModel {

    private  final String tipo;
    private final double peso;
    private final double valorDeclarado;


    public PaqueteModel(double peso, double valorDeclarado) {
        this.tipo = asignarTipoPaquete(peso);
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "tipo='" + tipo + '\'' +
                ", peso=" + peso +
                ", valorDeclarado=" + valorDeclarado +
                '}';
    }

    public String asignarTipoPaquete(Double peso){
        if (peso < 2.0){
            return "LIVIANO";
        } else if (peso > 5) {
            return "GRANDE";
        }else {
            return "MEDIANO";
        }
    }

    public String getTipo(){
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }
}
