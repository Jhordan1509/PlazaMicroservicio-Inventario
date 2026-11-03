package pe.com.megacentimetros.inventario.service;

import java.util.List;
import pe.com.megacentimetros.inventario.entity.StockAlmacenEntity;

public interface StockAlmacenService {

	List<StockAlmacenEntity> findAll();

	List<StockAlmacenEntity> findAllCustom();

	StockAlmacenEntity findById(Long codpro, Long codalm);

	StockAlmacenEntity add(StockAlmacenEntity obj);

	StockAlmacenEntity update(StockAlmacenEntity obj, Long codpro, Long codalm);

	StockAlmacenEntity delete(Long codpro, Long codalm);

	StockAlmacenEntity enable(Long codpro, Long codalm);
}
