package pe.com.megacentimetros.inventario.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.inventario.client.CatalogoFeignClient;
import pe.com.megacentimetros.inventario.client.PersonaFeignClient;
import pe.com.megacentimetros.inventario.entity.AlmacenEntity;
import pe.com.megacentimetros.inventario.repository.AlmacenRepository;
import pe.com.megacentimetros.inventario.service.AlmacenService;

@Service
public class AlmacenServiceImpl implements AlmacenService {

	private AlmacenRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;
	private PersonaFeignClient personaFeignClient;

	public AlmacenServiceImpl(AlmacenRepository repositorio,
			CatalogoFeignClient catalogoFeignClient,
			PersonaFeignClient personaFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
		this.personaFeignClient = personaFeignClient;
	}

	@Override
	public List<AlmacenEntity> findAll() {
		List<AlmacenEntity> lista = repositorio.findAll();
		for (AlmacenEntity almacen : lista) {
			almacen.setDistrito(catalogoFeignClient.getDistrito(almacen.getCoddis()));
			almacen.setTipoalmacen(catalogoFeignClient.getTipoAlmacen(almacen.getCodtalm()));
			almacen.setSucursal(personaFeignClient.getSucursal(almacen.getCodsuc()));
			almacen.setEstadooperativo(catalogoFeignClient.getEstadoOperativo(almacen.getCodeope()));
		}
		return lista;
	}
	@Override
	public List<AlmacenEntity> findAllCustom() {
		List<AlmacenEntity> lista = repositorio.findAllCustom();
		for (AlmacenEntity almacen : lista) {
			almacen.setDistrito(catalogoFeignClient.getDistrito(almacen.getCoddis()));
			almacen.setTipoalmacen(catalogoFeignClient.getTipoAlmacen(almacen.getCodtalm()));
			almacen.setSucursal(personaFeignClient.getSucursal(almacen.getCodsuc()));
			almacen.setEstadooperativo(catalogoFeignClient.getEstadoOperativo(almacen.getCodeope()));
		}
		return lista;
	}
	@Override
	public AlmacenEntity findById(Long id) {
		AlmacenEntity almacen = repositorio.findById(id).get();
		almacen.setDistrito(catalogoFeignClient.getDistrito(almacen.getCoddis()));
		almacen.setTipoalmacen(catalogoFeignClient.getTipoAlmacen(almacen.getCodtalm()));
		almacen.setSucursal(personaFeignClient.getSucursal(almacen.getCodsuc()));
		almacen.setEstadooperativo(catalogoFeignClient.getEstadoOperativo(almacen.getCodeope()));
		return almacen;
	}
	@Override
	public AlmacenEntity add(AlmacenEntity obj) {
		obj.setEstado(true);
		if (obj.getUsuarioCreacion() == null) {
			obj.setUsuarioCreacion("SYSTEM");
		}
		obj.setFechaCreacion(LocalDateTime.now());
		return repositorio.save(obj);
	}
	@Override
	public AlmacenEntity update(AlmacenEntity obj, Long id) {
		AlmacenEntity objalm = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objalm, "codigo", "fechaCreacion", "usuarioCreacion");
		objalm.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objalm);
	}
	@Override
	public AlmacenEntity delete(Long id) {
		AlmacenEntity objalm = repositorio.findById(id).get();
		objalm.setEstado(false);
		objalm.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objalm);
	}
	@Override
	public AlmacenEntity enable(Long id) {
		AlmacenEntity objalm = repositorio.findById(id).get();
		objalm.setEstado(true);
		objalm.setFechaActualizacion(LocalDateTime.now());
		return repositorio.save(objalm);
	}
}
