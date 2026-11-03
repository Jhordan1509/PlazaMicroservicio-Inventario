package pe.com.megacentimetros.inventario.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "StockAlmacenEntity")
@Table(name = "stockalmacen")
@IdClass(StockAlmacenId.class)
public class StockAlmacenEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codpro")
    private Long codpro;

    @Id
    @Column(name = "codalm")
    private Long codalm;

    @Column(name = "cansalm", nullable = false)
    private Integer cantidad;

    @Column(name = "minsalm", nullable = false)
    private Integer stockMinimo;

    @Column(name = "fecsalm")
    private LocalDateTime fechaStock;

    @Column(name = "estsalm", nullable = false)
    private Boolean estado;

    @Column(name = "usucre", length = 50, nullable = false)
    private String usuarioCreacion;

    @Column(name = "feccre", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuact", length = 50)
    private String usuarioActualizacion;

    @Column(name = "fecact")
    private LocalDateTime fechaActualizacion;
}
