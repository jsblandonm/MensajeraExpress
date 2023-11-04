package MensajeriaExpress.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "paquete")
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoPaquete;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo-Paquete")
    private tipoPaquete tipo;
    public enum tipoPaquete{
        LIVIANO, MEDIANO, GRANDE
    }

    @NotNull
    @Column(name = "peso_paquete")
    @Size(max = 10)
    private Double peso;

    @NotNull
    @Size(max = 50)
    @Column(name = "valor_decarado")
    private Double valorDeclarado;

    //Relaciones base de datos

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "idPaquete")
    @JsonBackReference
    private Envio envio;



    public Paquete() {
    }

    public Paquete(Long codigoPaquete, tipoPaquete tipo, Double peso, Double valorDeclarado, Envio envio) {
        this.codigoPaquete = codigoPaquete;
        this.tipo = tipo;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.envio = envio;
    }
}
