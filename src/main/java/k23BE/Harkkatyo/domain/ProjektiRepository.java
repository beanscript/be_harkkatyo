package k23BE.Harkkatyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjektiRepository extends CrudRepository<Projekti, Long> {
	List<Projekti> findByNimiIgnoreCase(String nimi);
	List<Projekti> findByAuto(Auto malli);
	List<Projekti> findByTila(Tila nimike);
}