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
import pe.com.megacentimetros.inventario.entity.StockAlmacenEntity;
import pe.com.megacentimetros.inventario.service.StockAlmacenService;

@RestController
@RequestMapping("/api/stockalmacen")
public class StockAlmacenRestController {

	@Autowired
	private StockAlmacenService servicio;

	@GetMapping
	public List<StockAlmacenEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<StockAlmacenEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{codpro}/{codalm}")
	public StockAlmacenEntity findById(@PathVariable Long codpro, @PathVariable Long codalm) {
		return servicio.findById(codpro, codalm);
	}

	@PostMapping
	public StockAlmacenEntity add(@RequestBody StockAlmacenEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{codpro}/{codalm}")
	public StockAlmacenEntity update(@RequestBody StockAlmacenEntity obj, @PathVariable Long codpro, @PathVariable Long codalm) {
		return servicio.update(obj, codpro, codalm);
	}

	@DeleteMapping("/{codpro}/{codalm}")
	public StockAlmacenEntity delete(@PathVariable Long codpro, @PathVariable Long codalm) {
		return servicio.delete(codpro, codalm);
	}

	@PatchMapping("/{codpro}/{codalm}")
	public StockAlmacenEntity enable(@PathVariable Long codpro, @PathVariable Long codalm) {
		return servicio.enable(codpro, codalm);
	}
}
