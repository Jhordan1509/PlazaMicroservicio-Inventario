package pe.com.megacentimetros.inventario.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.inventario.client.PersonaFeignClient;
import pe.com.megacentimetros.inventario.entity.TrasladoAlmacenEntity;
import pe.com.megacentimetros.inventario.repository.TrasladoAlmacenRepository;
import pe.com.megacentimetros.inventario.service.TrasladoAlmacenService;

@Service
public class TrasladoAlmacenServiceImpl implements TrasladoAlmacenService {

	private TrasladoAlmacenRepository repositorio;
	private PersonaFeignClient personaFeignClient;

	public TrasladoAlmacenServiceImpl(TrasladoAlmacenRepository repositorio,
			PersonaFeignClient personaFeignClient) {
		this.repositorio = repositorio;
		this.personaFeignClient = personaFeignClient;
	}

	@Override
	public List<TrasladoAlmacenEntity> findAll() {
		List<TrasladoAlmacenEntity> lista = repositorio.findAll();
		for (TrasladoAlmacenEntity trasladoAlmacen : lista) {
			trasladoAlmacen.setEmpleado(personaFeignClient.getEmpleado(trasladoAlmacen.getCodemp()));
		}
		return lista;
	}
	@Override
	public List<TrasladoAlmacenEntity> findAllCustom() {
		List<TrasladoAlmacenEntity> lista = repositorio.findAllCustom();
		for (TrasladoAlmacenEntity trasladoAlmacen : lista) {
			trasladoAlmacen.setEmpleado(personaFeignClient.getEmpleado(trasladoAlmacen.getCodemp()));
		}
		return lista;
	}
	@Override
	public TrasladoAlmacenEntity findById(Long id) {
		TrasladoAlmacenEntity trasladoAlmacen = repositorio.findById(id).get();
		trasladoAlmacen.setEmpleado(personaFeignClient.getEmpleado(trasladoAlmacen.getCodemp()));
		return trasladoAlmacen;
	}
	@Override
	public TrasladoAlmacenEntity add(TrasladoAlmacenEntity obj) {
		if (obj.getEstado() == null) {
			obj.setEstado("PENDIENTE");
		}
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}
	@Override
	public TrasladoAlmacenEntity update(TrasladoAlmacenEntity obj, Long id) {
		TrasladoAlmacenEntity objtra = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objtra, "codigo", "fechaCreacion", "usuarioCreacion");
		objtra.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objtra);
	}
	@Override
	public TrasladoAlmacenEntity delete(Long id) {
		TrasladoAlmacenEntity objtra = repositorio.findById(id).get();
		objtra.setEstado("ANULADO");
		objtra.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objtra);
	}
}
