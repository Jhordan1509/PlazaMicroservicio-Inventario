package pe.com.megacentimetros.inventario.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "DetalleTrasladoEntity")
@Table(name = "detalletraslado")
public class DetalleTrasladoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "coddtrasl")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "candtrasl", nullable = false)
    private Integer cantidad;

    @Column(name = "codpro", nullable = false)
    private Long codpro;

    @Column(name = "codtrasl", nullable = false)
    private Long codtrasl;

    @Column(name = "estdtrasl", nullable = false)
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
