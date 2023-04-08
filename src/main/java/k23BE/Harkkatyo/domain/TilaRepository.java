package k23BE.Harkkatyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TilaRepository extends CrudRepository<Tila, Long> {
	List<Tila> findByNimike(String nimike);
}