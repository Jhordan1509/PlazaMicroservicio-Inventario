package pe.com.megacentimetros.inventario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.inventario.entity.StockAlmacenEntity;
import pe.com.megacentimetros.inventario.entity.StockAlmacenId;

public interface StockAlmacenRepository extends JpaRepository<StockAlmacenEntity, StockAlmacenId> {

	@Query("select d from StockAlmacenEntity d where d.estado = true")
	List<StockAlmacenEntity> findAllCustom();
}
