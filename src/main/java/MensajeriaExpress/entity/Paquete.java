package MensajeriaExpress.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "paquetes")
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoPaquete;

    @NotNull
    @Column(name = "tipo-Paquete")
    private String tipo;

    @NotNull
    @Column(name = "peso_paquete")
    private Double peso;

    @NotNull
    @Column(name = "valor_decarado")
    private Double valorDeclarado;

    //Relaciones base de datos

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "numeroGuia")
    @JsonBackReference
    private Envio envio;

    public Paquete() {
    }

    public Paquete(String tipo, Double peso, Double valorDeclarado) {
        this.tipo = tipo;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }

}
