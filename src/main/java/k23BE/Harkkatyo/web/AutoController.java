package k23BE.Harkkatyo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	// veloster
	@RequestMapping(value = "/veloster")
	public String velosterInfo(Model model) {
		model.addAttribute("velo", autoRepository.findByMalli("Veloster"));
		return "veloster";
	}
	
	// hellcat
	@RequestMapping(value = "/hellcat")
	public String hellcatInfo(Model model) {
		model.addAttribute("cat", autoRepository.findByMalli("Challenger Hellcat"));
		return "hellcat";
	}
	
	// kaikkien autojen listaus
	@RequestMapping(value = "/autot")
	public String autoList(Model model) {
		model.addAttribute("autos", autoRepository.findAll());
		return "autot";
	}
	
	// uusien autojen lisääminen
	@RequestMapping(value = "/addAuto")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addAuto(Model model) {
		model.addAttribute("uusiAuto", new Auto());
		return "addauto";
	}
	
	// tallennus ja vähän validointia
	@RequestMapping(value = "/saveAuto", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
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
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editAuto(@PathVariable("autoid") Long autoid, Model model) {
		model.addAttribute("editAuto", autoRepository.findById(autoid));
		return "editAuto";
	}
	
}
