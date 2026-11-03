package pe.com.megacentimetros.inventario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.inventario.entity.TrasladoAlmacenEntity;

public interface TrasladoAlmacenRepository extends JpaRepository<TrasladoAlmacenEntity, Long> {

	@Query("select d from TrasladoAlmacenEntity d where d.estado <> 'ANULADO'")
	List<TrasladoAlmacenEntity> findAllCustom();
}
