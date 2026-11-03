package pe.com.megacentimetros.inventario.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockAlmacenId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long codpro;
    private Long codalm;
}
