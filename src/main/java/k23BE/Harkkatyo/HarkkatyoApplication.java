package k23BE.Harkkatyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k23BE.Harkkatyo.domain.Auto;
import k23BE.Harkkatyo.domain.AutoRepository;
import k23BE.Harkkatyo.domain.Kayttaja;
import k23BE.Harkkatyo.domain.KayttajaRepository;
import k23BE.Harkkatyo.domain.Projekti;
import k23BE.Harkkatyo.domain.ProjektiRepository;
import k23BE.Harkkatyo.domain.Tila;
import k23BE.Harkkatyo.domain.TilaRepository;

@SpringBootApplication
public class HarkkatyoApplication {
	
//	private static final Logger log = LoggerFactory.getLogger(HarkkatyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarkkatyoApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner demo(ProjektiRepository projektiRepository, AutoRepository autoRepository, TilaRepository tilaRepository, KayttajaRepository kayttajaRepository) {
//		return (args) -> {
//			
//			log.info("tallennetaan pari käyttäjää");
//			// admin/admin ja user/user
//			kayttajaRepository.save(new Kayttaja("Minna", "USER", "user", "$2a$10$pRGLapVsL1uKwMxLOCb16eOdN7YDlOZU3zPISEaViCGRm2cMIcypa"));
//			kayttajaRepository.save(new Kayttaja("Elia", "ADMIN", "admin", "$2a$10$bMFMIA5G2G8xQIHn76g/ReT3Tg2D8TaxwYIhhAtbS6UBRz7p7wNbC"));
//			
//			log.info("get kaikki käyttäjät");
//			for (Kayttaja kayttaja : kayttajaRepository.findAll()) {
//				log.info(kayttaja.toString());
//			}
//
//			log.info("tallennetaan autot:");
//			autoRepository.save(new Auto("HYundai", "Veloster", 2013, "XOS-797", "1.6l turbo", 0.0, "kuva"));
//			autoRepository.save(new Auto("Nissan", "240sx", 1988, "SOS-999", "vapari", 0.0, "kuva"));
//			autoRepository.save(new Auto("bmw", "x1", 1959, "KOP-111", "Tiedot", 0.0, "kuva"));
//	
//			log.info("get kaikki autot");
//			for (Auto auto : autoRepository.findAll()) {
//				log.info(auto.toString());
//			}
//			
//			log.info("tallennetaan tilat:");
//			tilaRepository.save(new Tila("Valmis"));
//			tilaRepository.save(new Tila("Kesken"));
//			
//			log.info("get kaikki tilat");
//			for (Tila tila : tilaRepository.findAll()) {
//				log.info(tila.toString());
//			}
//			
//			log.info("tallennetaan pari demo prokkista");
//			projektiRepository.save(new Projekti("Teippausta", "Inozek Vampire Red teippiä", "Teipataan auton etulippa, sivut, takapaneeli ja peilit", 500.00, autoRepository.findByMalli("Veloster").get(0), tilaRepository.findByNimike("Valmis").get(0)));
//			projektiRepository.save(new Projekti("Vanteet", "vanteet", "Teipataan auton etulippa, sivut, takapaneeli ja peilit", 500.00, autoRepository.findByMalli("x1").get(0), tilaRepository.findByNimike("Kesken").get(0) ));
//		
//			log.info("get kaikki projektit:");
//			for (Projekti projekti : projektiRepository.findAll()) {
//				log.info(projekti.toString());
//			}
//		};
//	}

}
