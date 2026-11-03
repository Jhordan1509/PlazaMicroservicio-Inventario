package pe.com.megacentimetros.inventario.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.inventario.client.CatalogoFeignClient;
import pe.com.megacentimetros.inventario.client.PersonaFeignClient;
import pe.com.megacentimetros.inventario.entity.MovimientoInventarioEntity;
import pe.com.megacentimetros.inventario.repository.MovimientoInventarioRepository;
import pe.com.megacentimetros.inventario.service.MovimientoInventarioService;

@Service
public class MovimientoInventarioServiceImpl implements MovimientoInventarioService {

	private MovimientoInventarioRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;
	private PersonaFeignClient personaFeignClient;

	public MovimientoInventarioServiceImpl(MovimientoInventarioRepository repositorio,
			CatalogoFeignClient catalogoFeignClient,
			PersonaFeignClient personaFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
		this.personaFeignClient = personaFeignClient;
	}

	@Override
	public List<MovimientoInventarioEntity> findAll() {
		List<MovimientoInventarioEntity> lista = repositorio.findAll();
		for (MovimientoInventarioEntity movimientoInventario : lista) {
			movimientoInventario.setTipomovimiento(catalogoFeignClient.getTipoMovimiento(movimientoInventario.getCodtmov()));
			if (movimientoInventario.getCodemp() != null) {
				movimientoInventario.setEmpleado(personaFeignClient.getEmpleado(movimientoInventario.getCodemp()));
			}
		}
		return lista;
	}
	@Override
	public List<MovimientoInventarioEntity> findAllCustom() {
		List<MovimientoInventarioEntity> lista = repositorio.findAllCustom();
		for (MovimientoInventarioEntity movimientoInventario : lista) {
			movimientoInventario.setTipomovimiento(catalogoFeignClient.getTipoMovimiento(movimientoInventario.getCodtmov()));
			if (movimientoInventario.getCodemp() != null) {
				movimientoInventario.setEmpleado(personaFeignClient.getEmpleado(movimientoInventario.getCodemp()));
			}
		}
		return lista;
	}
	@Override
	public MovimientoInventarioEntity findById(Long id) {
		MovimientoInventarioEntity movimientoInventario = repositorio.findById(id).get();
		movimientoInventario.setTipomovimiento(catalogoFeignClient.getTipoMovimiento(movimientoInventario.getCodtmov()));
		if (movimientoInventario.getCodemp() != null) {
			movimientoInventario.setEmpleado(personaFeignClient.getEmpleado(movimientoInventario.getCodemp()));
		}
		return movimientoInventario;
	}
	@Override
	public MovimientoInventarioEntity add(MovimientoInventarioEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		if (obj.getFecha() == null) {
			obj.setFecha(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public MovimientoInventarioEntity update(MovimientoInventarioEntity obj, Long id) {
		MovimientoInventarioEntity objmov = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objmov, "codigo", "fechaCreacion", "usuarioCreacion");
		objmov.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objmov);
	}
	@Override
	public MovimientoInventarioEntity delete(Long id) {
		MovimientoInventarioEntity objmov = repositorio.findById(id).get();
		objmov.setEstado(false);
		objmov.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objmov);
	}
	@Override
	public MovimientoInventarioEntity enable(Long id) {
		MovimientoInventarioEntity objmov = repositorio.findById(id).get();
		objmov.setEstado(true);
		objmov.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objmov);
	}
}
