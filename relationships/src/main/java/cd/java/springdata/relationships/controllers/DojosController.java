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

import cd.java.springdata.relationships.models.Dojo;
import cd.java.springdata.relationships.services.DojoService;

/**
 * @author ccomstock
 *
 */
@Controller
@RequestMapping("/dojos")
public class DojosController {

	private final DojoService dojoService;
	
	public DojosController(DojoService dojoServ) {
		dojoService = dojoServ;
	}
	
	@GetMapping("/new")
	public String viewNew(@ModelAttribute Dojo dojo, Model model) {
		return "dn/dojos/new.jsp";
	}
	
	@PostMapping
	public String addNew(@Valid @ModelAttribute Dojo dojo, BindingResult result) {
		if(result.hasErrors()) return "dn/dojos/new.jsp";
		dojoService.createOne(dojo);
		return "redirect:/dashboard-dn";
	}
	
	@GetMapping("/{id}")
	public String viewShow(@PathVariable Long id, Model model) {
		Dojo dojo = dojoService.readOne(id);
		if(dojo == null) return "redirect:/dashboard-dn";
		model.addAttribute("dojo", dojo);
		return "dn/dojos/show.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String viewEdit(@PathVariable Long id, Model model) {
		Dojo dojo = dojoService.readOne(id);
		if(dojo == null) return "redirect:/dashboard-dn";
		model.addAttribute("dojo", dojo);
		return "dn/dojos/edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute Dojo dojo, BindingResult result) {
		if(result.hasErrors()) return "dn/dojos/edit.jsp";
		dojoService.updateOne(dojo);
		return "redirect:/dashboard-dn";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		dojoService.destroyOneById(id);
		return "redirect:/dashboard-dn";
	}
	
}
