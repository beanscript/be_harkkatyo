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

import k23BE.Harkkatyo.domain.Tila;
import k23BE.Harkkatyo.domain.TilaRepository;


@Controller
public class TilaController {
	@Autowired
	TilaRepository tilaRepository;
	
	// tilojen listaus
	@RequestMapping(value = "/tilat")
	public String tilaList(Model model) {
		model.addAttribute("tilas", tilaRepository.findAll());
		return "tilat";
	}
	
	// uusien tilojen lisääminen
	@RequestMapping(value = "/addTila")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addTila(Model model) {
		model.addAttribute("uusiTila", new Tila());
		return "addtila";
	}
	
	// tallennus ja vähän validointia
	@RequestMapping(value = "/saveTila", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveTila(@Valid Tila tila, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("jotain meni pieleen");
			return "addTila";
		}
		tilaRepository.save(tila);
		return "redirect:tilalist";
	}
	
	// tilojen muokkaaminen
	@RequestMapping(value = "/editTila/{tilaid}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editTila(@PathVariable("tilaid") Long tilaid, Model model) {
		model.addAttribute("editTila", tilaRepository.findById(tilaid));
		return "editTila";
	}
}
