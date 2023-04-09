package k23BE.Harkkatyo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import k23BE.Harkkatyo.domain.Auto;
import k23BE.Harkkatyo.domain.AutoRepository;

@Controller
public class AutoController {
	@Autowired
	AutoRepository autoRepository;
	
	// autojen listaus
	@RequestMapping(value = "/autot")
	public String autoList(Model model) {
		model.addAttribute("autos", autoRepository.findAll());
		return "autot";
	}
	
	// uusien autojen lisääminen
	@RequestMapping(value = "/addAuto")
	public String addAuto(Model model) {
		model.addAttribute("uusiAuto", new Auto());
		return "addauto";
	}
	
	// tallennus ja vähän validointia
	@RequestMapping(value = "/saveAuto", method = RequestMethod.POST)
	public String saveAuto(@Valid Auto auto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("jotain meni pieleen");
			return "addAuto";
		}
		autoRepository.save(auto);
		return "redirect:autolist";
	}
	
	// autojen muokkaaminen
	@RequestMapping(value = "/editAuto/{autoid}", method = RequestMethod.GET)
	public String editAuto(@PathVariable("autoid") Long autoid, Model model) {
		model.addAttribute("editAuto", autoRepository.findById(autoid));
		return "editAuto";
	}
	
}
