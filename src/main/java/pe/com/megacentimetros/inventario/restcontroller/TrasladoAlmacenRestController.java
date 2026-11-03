package pe.com.megacentimetros.inventario.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.inventario.entity.TrasladoAlmacenEntity;
import pe.com.megacentimetros.inventario.service.TrasladoAlmacenService;

@RestController
@RequestMapping("/api/trasladoalmacen")
public class TrasladoAlmacenRestController {

	@Autowired
	private TrasladoAlmacenService servicio;

	@GetMapping
	public List<TrasladoAlmacenEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<TrasladoAlmacenEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public TrasladoAlmacenEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public TrasladoAlmacenEntity add(@RequestBody TrasladoAlmacenEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public TrasladoAlmacenEntity update(@RequestBody TrasladoAlmacenEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public TrasladoAlmacenEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
}
