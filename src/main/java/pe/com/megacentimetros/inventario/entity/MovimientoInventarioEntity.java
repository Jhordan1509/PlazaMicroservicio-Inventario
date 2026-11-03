package pe.com.megacentimetros.inventario.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "MovimientoInventarioEntity")
@Table(name = "movimientoinventario")
public class MovimientoInventarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codminv")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "fecminv")
    private LocalDateTime fecha;

    @Column(name = "canminv", nullable = false)
    private Integer cantidad;

    @Column(name = "refminv", length = 50)
    private String referencia;

    @Column(name = "codpro", nullable = false)
    private Long codpro;

    @Column(name = "codalm", nullable = false)
    private Long codalm;

    @Column(name = "codtmov", nullable = false)
    private Long codtmov;

    @Column(name = "codemp")
    private Long codemp;

    @Column(name = "estminv", nullable = false)
    private Boolean estado;

    @Column(name = "usucre", length = 50, nullable = false)
    private String usuarioCreacion;

    @Column(name = "feccre", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuact", length = 50)
    private String usuarioActualizacion;

    @Column(name = "fecact")
    private LocalDateTime fechaActualizacion;

    @Transient
    private Object tipomovimiento;

    @Transient
    private Object empleado;
}
