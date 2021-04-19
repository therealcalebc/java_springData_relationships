/**
 * 
 */
package cd.java.springdata.relationships.controllers;

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

import cd.java.springdata.relationships.models.Ninja;
import cd.java.springdata.relationships.services.NinjaService;

/**
 * @author ccomstock
 *
 */
@Controller
@RequestMapping("/ninjas")
public class NinjasController {

	private final NinjaService ninjaService;
	
	public NinjasController(NinjaService ninjaServ) {
		ninjaService = ninjaServ;
	}
	
	@GetMapping("/new")
	public String viewNew(@ModelAttribute Ninja ninja) {
		return "ninjas/new.jsp";
	}
	
	@PostMapping
	public String addNew(@Valid @ModelAttribute Ninja ninja, BindingResult result) {
		if(result.hasErrors()) return "ninjas/new.jsp";
		ninjaService.createOne(ninja);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{id}")
	public String viewShow(@PathVariable Long id, Model model) {
		Ninja ninja = ninjaService.readOne(id);
		if(ninja == null) return "redirect:/dashboard";
		model.addAttribute("ninja", ninja);
		return "ninjas/show.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String viewEdit(@PathVariable Long id, Model model) {
		Ninja ninja = ninjaService.readOne(id);
		if(ninja == null) return "redirect:/dashboard";
		model.addAttribute("ninja", ninja);
		return "ninjas/edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute Ninja ninja, BindingResult result) {
		if(result.hasErrors()) return "ninjas/edit.jsp";
		ninjaService.updateOne(ninja);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		ninjaService.destroyOneById(id);
		return "redirect:/dashboard";
	}
	
}
