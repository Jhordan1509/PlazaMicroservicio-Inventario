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
@Entity(name = "TrasladoAlmacenEntity")
@Table(name = "trasladoalmacen")
public class TrasladoAlmacenEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codtrasl")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "fectrasl", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "esttrasl", length = 20, nullable = false)
    private String estado;

    @Column(name = "codalmori", nullable = false)
    private Long codalmori;

    @Column(name = "codalmdes", nullable = false)
    private Long codalmdes;

    @Column(name = "codemp", nullable = false)
    private Long codemp;

    @Column(name = "usucre", length = 50, nullable = false)
    private String usuarioCreacion;

    @Column(name = "feccre", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuact", length = 50)
    private String usuarioActualizacion;

    @Column(name = "fecact")
    private LocalDateTime fechaActualizacion;

    @Transient
    private Object empleado;
}
