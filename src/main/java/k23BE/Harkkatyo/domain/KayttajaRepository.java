package k23BE.Harkkatyo.domain;


import org.springframework.data.repository.CrudRepository;

public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> {
	Kayttaja findByTunnus(String tunnus);
}