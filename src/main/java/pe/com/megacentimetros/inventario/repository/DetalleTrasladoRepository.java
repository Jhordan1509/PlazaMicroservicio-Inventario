package pe.com.megacentimetros.inventario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.inventario.entity.DetalleTrasladoEntity;

public interface DetalleTrasladoRepository extends JpaRepository<DetalleTrasladoEntity, Long> {

	@Query("select d from DetalleTrasladoEntity d where d.estado = true")
	List<DetalleTrasladoEntity> findAllCustom();
}
