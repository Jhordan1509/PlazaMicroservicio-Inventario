package pe.com.megacentimetros.inventario.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.inventario.entity.StockAlmacenId;
import pe.com.megacentimetros.inventario.entity.StockAlmacenEntity;
import pe.com.megacentimetros.inventario.repository.StockAlmacenRepository;
import pe.com.megacentimetros.inventario.service.StockAlmacenService;

@Service
public class StockAlmacenServiceImpl implements StockAlmacenService {

	private StockAlmacenRepository repositorio;

	public StockAlmacenServiceImpl(StockAlmacenRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<StockAlmacenEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<StockAlmacenEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public StockAlmacenEntity findById(Long codpro, Long codalm) {
		StockAlmacenEntity stockAlmacen = repositorio.findById(new StockAlmacenId(codpro, codalm)).get();
		return stockAlmacen;
	}
	@Override
	public StockAlmacenEntity add(StockAlmacenEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		if (obj.getCantidad() == null) {
			obj.setCantidad(0);
		}
		if (obj.getStockMinimo() == null) {
			obj.setStockMinimo(0);
		}
		obj.setFechaStock(LocalDateTime.now());
		return repositorio.save(obj);
	}
	@Override
	public StockAlmacenEntity update(StockAlmacenEntity obj, Long codpro, Long codalm) {
		StockAlmacenEntity objsto = repositorio.findById(new StockAlmacenId(codpro, codalm)).get();
		BeanUtils.copyProperties(obj, objsto, "codpro", "codalm", "fechaCreacion", "usuarioCreacion");
		objsto.setFechaActualizacion(LocalDateTime.now());
		objsto.setFechaStock(LocalDateTime.now());
		return repositorio.save(objsto);
	}
	@Override
	public StockAlmacenEntity delete(Long codpro, Long codalm) {
		StockAlmacenEntity objsto = repositorio.findById(new StockAlmacenId(codpro, codalm)).get();
		objsto.setEstado(false);
		objsto.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objsto);
	}
	@Override
	public StockAlmacenEntity enable(Long codpro, Long codalm) {
		StockAlmacenEntity objsto = repositorio.findById(new StockAlmacenId(codpro, codalm)).get();
		objsto.setEstado(true);
		objsto.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objsto);
	}
}
