package pe.com.megacentimetros.inventario.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.inventario.entity.DetalleTrasladoEntity;
import pe.com.megacentimetros.inventario.service.DetalleTrasladoService;

@RestController
@RequestMapping("/api/detalletraslado")
public class DetalleTrasladoRestController {

	@Autowired
	private DetalleTrasladoService servicio;

	@GetMapping
	public List<DetalleTrasladoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<DetalleTrasladoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public DetalleTrasladoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public DetalleTrasladoEntity add(@RequestBody DetalleTrasladoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public DetalleTrasladoEntity update(@RequestBody DetalleTrasladoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public DetalleTrasladoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public DetalleTrasladoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
