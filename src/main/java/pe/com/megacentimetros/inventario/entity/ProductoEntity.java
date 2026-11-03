package pe.com.megacentimetros.inventario.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
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
@Entity(name = "ProductoEntity")
@Table(name = "producto")
public class ProductoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codpro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "skupro", length = 30, nullable = false, unique = true)
    private String sku;

    @Column(name = "nompro", length = 100, nullable = false)
    private String nombre;

    @Column(name = "despro", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecpro")
    private LocalDateTime fechaRegistro;

    @Column(name = "prepro", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "cospro", nullable = false, precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(name = "codcat", nullable = false)
    private Long codcat;

    @Column(name = "codmar", nullable = false)
    private Long codmar;

    @Column(name = "codtemp", nullable = false)
    private Long codtemp;

    @Column(name = "codumed", nullable = false)
    private Long codumed;

    @Column(name = "estpro", nullable = false)
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
    private Object categoriaproducto;

    @Transient
    private Object marcaproducto;

    @Transient
    private Object tipoempaque;

    @Transient
    private Object unidadmedida;
}
