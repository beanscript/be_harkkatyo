package k23BE.Harkkatyo.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import k23BE.Harkkatyo.domain.Kayttaja;
import k23BE.Harkkatyo.domain.KayttajaRepository;

@Controller
public class KayttajaController {
	@Autowired
	KayttajaRepository kayttajaRepository;
	
	// käyttäjän tietojen listaus
//		@RequestMapping(value = "/kayttaja")
//		public String userList(Model model) {
//			model.addAttribute("user", kayttajaRepository.findByKayttajaid(null));
//			return "projectlist";
//		}
		
		// REST projekti by auto
	    @RequestMapping(value="/kayttaja/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Kayttaja> findKayttajaRest(@PathVariable("id") Long kayttajaid) {	
	    	return kayttajaRepository.findById(kayttajaid);
	    }
}
