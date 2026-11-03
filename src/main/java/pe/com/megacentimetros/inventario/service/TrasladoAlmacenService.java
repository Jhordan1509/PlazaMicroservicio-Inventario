package pe.com.megacentimetros.inventario.service;

import java.util.List;
import pe.com.megacentimetros.inventario.entity.TrasladoAlmacenEntity;

public interface TrasladoAlmacenService {

	List<TrasladoAlmacenEntity> findAll();

	List<TrasladoAlmacenEntity> findAllCustom();

	TrasladoAlmacenEntity findById(Long id);

	TrasladoAlmacenEntity add(TrasladoAlmacenEntity obj);

	TrasladoAlmacenEntity update(TrasladoAlmacenEntity obj, Long id);

	TrasladoAlmacenEntity delete(Long id);
}
