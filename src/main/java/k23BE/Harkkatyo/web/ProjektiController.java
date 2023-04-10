package k23BE.Harkkatyo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import k23BE.Harkkatyo.domain.Projekti;
import k23BE.Harkkatyo.domain.Auto;
import k23BE.Harkkatyo.domain.AutoRepository;
import k23BE.Harkkatyo.domain.ProjektiRepository;
import k23BE.Harkkatyo.domain.TilaRepository;

@Controller
public class ProjektiController {
	@Autowired
	private ProjektiRepository projektiRepository;
	@Autowired
	private AutoRepository autoRepository;
	@Autowired
	private TilaRepository tilaRepository;
	
	// etusivu
	@RequestMapping(value = { "/", "/index" })
	public String index() {
		return "index";
	}
	
	// projektien listaus
	@RequestMapping(value = "/projectlist")
	public String projectList(Model model) {
		model.addAttribute("projektit", projektiRepository.findAll());
		return "projectlist";
	}
	
	// REST projekti by auto
    @RequestMapping(value="/project/{auto}", method = RequestMethod.GET)
    public @ResponseBody List<Projekti> findProjektiRest(@PathVariable("auto") Auto malli) {	
    	return projektiRepository.findByAuto(malli);
    }
	
	// uusien projektien lisääminen
	@RequestMapping(value = "/addProject")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String add(Model model) {
		model.addAttribute("uusiProjekti", new Projekti());
		model.addAttribute("autot", autoRepository.findAll());
		model.addAttribute("tilat", tilaRepository.findAll());
		return "addproject";
	}
	
	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveProject(@Valid Projekti projekti, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("jotain meni pieleen");
			return "addProject";
		}
		projektiRepository.save(projekti);
		return "redirect:projectlist";
	}
	
	// projektien muokkaaminen
	@RequestMapping(value = "/editProject/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editProject(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editProject", projektiRepository.findById(id));
		model.addAttribute("autot", autoRepository.findAll());
		model.addAttribute("tilat", tilaRepository.findAll());
		return "editproject";
	}
	
	// projektien poistaminen
	@RequestMapping(value = "/deleteProject/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteProject(@PathVariable("id") Long id, Model model) {
		projektiRepository.deleteById(id);
		return "redirect:../projectlist";
	}
	
	
}
