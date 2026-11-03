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
@Entity(name = "AlmacenEntity")
@Table(name = "almacen")
public class AlmacenEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codalm")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomalm", length = 100, nullable = false, unique = true)
    private String nombre;

    @Column(name = "diralm", length = 200, nullable = false)
    private String direccion;

    @Column(name = "capalm", nullable = false)
    private Integer capacidad;

    @Column(name = "desalm", length = 300)
    private String descripcion;

    @Column(name = "coddis", nullable = false)
    private Long coddis;

    @Column(name = "codtalm", nullable = false)
    private Long codtalm;

    @Column(name = "codsuc", nullable = false)
    private Long codsuc;

    @Column(name = "codeope", nullable = false)
    private Long codeope;

    @Column(name = "estalm", nullable = false)
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
    private Object distrito;

    @Transient
    private Object tipoalmacen;

    @Transient
    private Object sucursal;

    @Transient
    private Object estadooperativo;
}
