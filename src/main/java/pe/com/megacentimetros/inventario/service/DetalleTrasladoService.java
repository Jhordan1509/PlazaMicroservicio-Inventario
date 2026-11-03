package pe.com.megacentimetros.inventario.service;

import java.util.List;
import pe.com.megacentimetros.inventario.entity.DetalleTrasladoEntity;

public interface DetalleTrasladoService {

	List<DetalleTrasladoEntity> findAll();

	List<DetalleTrasladoEntity> findAllCustom();

	DetalleTrasladoEntity findById(Long id);

	DetalleTrasladoEntity add(DetalleTrasladoEntity obj);

	DetalleTrasladoEntity update(DetalleTrasladoEntity obj, Long id);

	DetalleTrasladoEntity delete(Long id);

	DetalleTrasladoEntity enable(Long id);
}
