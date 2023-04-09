package k23BE.Harkkatyo.domain;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {
	Kayttaja findByUsername(String username);
	//Optional<Kayttaja> findByUsername(String username);
}