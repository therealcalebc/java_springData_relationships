/**
 * 
 */
package cd.java.springdata.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cd.java.springdata.relationships.models.Dojo;
import cd.java.springdata.relationships.models.Ninja;
import cd.java.springdata.relationships.services.DojoService;
import cd.java.springdata.relationships.services.NinjaService;

/**
 * @author ccomstock
 *
 */
@Controller
@RequestMapping("/ninjas")
public class NinjasController {

	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjasController(NinjaService ninjaServ, DojoService dojoServ) {
		ninjaService = ninjaServ;
		dojoService = dojoServ;
	}
	
	@GetMapping("/new")
	public String viewNew(@ModelAttribute Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.readAll();
		model.addAttribute("dojos", dojos);
		return "DN/ninjas/new.jsp";
	}
	
	@PostMapping
	public String addNew(@Valid @ModelAttribute Ninja ninja, BindingResult result) {
		if(result.hasErrors()) return "DN/ninjas/new.jsp";
		ninjaService.createOne(ninja);
		return "redirect:/DN/dashboard";
	}
	
	@GetMapping("/{id}")
	public String viewShow(@PathVariable Long id, Model model) {
		Ninja ninja = ninjaService.readOne(id);
		if(ninja == null) return "redirect:/DN/dashboard";
		model.addAttribute("ninja", ninja);
		return "DN/ninjas/show.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String viewEdit(@PathVariable Long id, Model model) {
		Ninja ninja = ninjaService.readOne(id);
		if(ninja == null) return "redirect:/DN/dashboard";
		model.addAttribute("ninja", ninja);
		List<Dojo> dojos = dojoService.readAll();
		model.addAttribute("dojos", dojos);
		return "DN/ninjas/edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute Ninja ninja, BindingResult result) {
		if(result.hasErrors()) return "DN/ninjas/edit.jsp";
		ninjaService.updateOne(ninja);
		return "redirect:/DN/dashboard";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		ninjaService.destroyOneById(id);
		return "redirect:/DN/dashboard";
	}
	
}
