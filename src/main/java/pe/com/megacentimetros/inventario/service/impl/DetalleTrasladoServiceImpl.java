package pe.com.megacentimetros.inventario.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.inventario.entity.DetalleTrasladoEntity;
import pe.com.megacentimetros.inventario.repository.DetalleTrasladoRepository;
import pe.com.megacentimetros.inventario.service.DetalleTrasladoService;

@Service
public class DetalleTrasladoServiceImpl implements DetalleTrasladoService {

	private DetalleTrasladoRepository repositorio;

	public DetalleTrasladoServiceImpl(DetalleTrasladoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<DetalleTrasladoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<DetalleTrasladoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public DetalleTrasladoEntity findById(Long id) {
		DetalleTrasladoEntity detalleTraslado = repositorio.findById(id).get();
		return detalleTraslado;
	}
	@Override
	public DetalleTrasladoEntity add(DetalleTrasladoEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}
	@Override
	public DetalleTrasladoEntity update(DetalleTrasladoEntity obj, Long id) {
		DetalleTrasladoEntity objdet = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdet, "codigo", "fechaCreacion", "usuarioCreacion");
		objdet.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objdet);
	}
	@Override
	public DetalleTrasladoEntity delete(Long id) {
		DetalleTrasladoEntity objdet = repositorio.findById(id).get();
		objdet.setEstado(false);
		objdet.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objdet);
	}
	@Override
	public DetalleTrasladoEntity enable(Long id) {
		DetalleTrasladoEntity objdet = repositorio.findById(id).get();
		objdet.setEstado(true);
		objdet.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objdet);
	}
}
