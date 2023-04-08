package k23BE.Harkkatyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AutoRepository extends CrudRepository<Auto, Long> {
	List<Auto> findByMalli(String malli);
}