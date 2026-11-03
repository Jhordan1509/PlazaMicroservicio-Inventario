package pe.com.megacentimetros.inventario.service;

import java.util.List;
import pe.com.megacentimetros.inventario.entity.MovimientoInventarioEntity;

public interface MovimientoInventarioService {

	List<MovimientoInventarioEntity> findAll();

	List<MovimientoInventarioEntity> findAllCustom();

	MovimientoInventarioEntity findById(Long id);

	MovimientoInventarioEntity add(MovimientoInventarioEntity obj);

	MovimientoInventarioEntity update(MovimientoInventarioEntity obj, Long id);

	MovimientoInventarioEntity delete(Long id);

	MovimientoInventarioEntity enable(Long id);
}
