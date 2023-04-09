package k23BE.Harkkatyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;

import k23BE.Harkkatyo.domain.KayttajaRepository;

@Controller
public class KayttajaController {
	@Autowired
	KayttajaRepository kayttajaRepository;
	
//	@RequestMapping(value="/login")
//    public String login() {	
//        return "login";
//    }
}
