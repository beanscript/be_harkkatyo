package k23BE.Harkkatyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import k23BE.Harkkatyo.domain.Projekti;
import k23BE.Harkkatyo.domain.AutoRepository;
import k23BE.Harkkatyo.domain.ProjektiRepository;
import k23BE.Harkkatyo.domain.TilaRepository;

@Controller
public class ProjektiController {
	@Autowired
	ProjektiRepository projektiRepository;
	@Autowired
	private AutoRepository autoRepository;
	@Autowired
	private TilaRepository tilaRepository;
	
	// projektien listaus
	@RequestMapping(value = { "/", "/projectlist" })
	public String projectList(Model model) {
		model.addAttribute("projektit", projektiRepository.findAll());
		return "projectlist";
	}
	
	// uusien projektien lisääminen
	@RequestMapping(value = "/addProject")
	public String add(Model model) {
		model.addAttribute("uusiProjekti", new Projekti());
		model.addAttribute("autot", autoRepository.findAll());
		model.addAttribute("tilat", tilaRepository.findAll());
		return "addproject";
	}
	
	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public String saveProject(Projekti projekti) {
		projektiRepository.save(projekti);
		return "redirect:projectlist";
	}
	
	// projektien muokkaaminen
	@RequestMapping(value = "/editProject/{id}", method = RequestMethod.GET)
	public String editProject(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editProject", projektiRepository.findById(id));
		model.addAttribute("autot", autoRepository.findAll());
		model.addAttribute("tilat", tilaRepository.findAll());
		return "editproject";
	}
	
	// projektien poistaminen
	@RequestMapping(value = "/deleteProject/{id}", method = RequestMethod.DELETE)
	public String deleteProject(@PathVariable("id") Long id, Model model) {
		projektiRepository.deleteById(id);
		return "redirect:../projectlist";
	}
	
	
}
