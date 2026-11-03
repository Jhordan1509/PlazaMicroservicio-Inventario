package pe.com.megacentimetros.inventario.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-catalogo", url = "http://localhost:9091/megacentimetros/api/")
public interface CatalogoFeignClient {
	@GetMapping("/distrito/{id}")
	Object getDistrito(@PathVariable("id") Long id);

	@GetMapping("/tipoalmacen/{id}")
	Object getTipoAlmacen(@PathVariable("id") Long id);

	@GetMapping("/estadooperativo/{id}")
	Object getEstadoOperativo(@PathVariable("id") Long id);

	@GetMapping("/categoriaproducto/{id}")
	Object getCategoriaProducto(@PathVariable("id") Long id);

	@GetMapping("/marcaproducto/{id}")
	Object getMarcaProducto(@PathVariable("id") Long id);

	@GetMapping("/tipoempaque/{id}")
	Object getTipoEmpaque(@PathVariable("id") Long id);

	@GetMapping("/unidadmedida/{id}")
	Object getUnidadMedida(@PathVariable("id") Long id);

	@GetMapping("/tipomovimiento/{id}")
	Object getTipoMovimiento(@PathVariable("id") Long id);
}
