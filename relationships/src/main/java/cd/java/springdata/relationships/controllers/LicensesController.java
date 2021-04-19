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

import cd.java.springdata.relationships.models.License;
import cd.java.springdata.relationships.models.Person;
import cd.java.springdata.relationships.services.LicenseService;
import cd.java.springdata.relationships.services.PersonService;

/**
 * @author ccomstock
 *
 */
@Controller
@RequestMapping("/licenses")
public class LicensesController {

	private final PersonService personService;
	private final LicenseService licenseService;
	
	public LicensesController(PersonService personServ, LicenseService licenseServ) {
		personService = personServ;
		licenseService = licenseServ;
	}
	
	@GetMapping("/new")
	public String viewNew(@ModelAttribute License license, Model model) {
		List<Person> personList = personService.readAll();
		model.addAttribute("persons", personList);
		return "licenses/new.jsp";
	}
	
	@PostMapping
	public String addNew(@Valid @ModelAttribute License license, BindingResult result) {
		if(result.hasErrors()) return "licenses/new.jsp";
		licenseService.createOne(license);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{id}")
	public String viewShow(@PathVariable Long id, Model model) {
		License license = licenseService.readOne(id);
		if(license == null) return "redirect:/dashboard";
		model.addAttribute("license", license);
		return "licenses/show.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String viewEdit(@PathVariable Long id, Model model) {
		License license = licenseService.readOne(id);
		if(license == null) return "redirect:/dashboard";
		model.addAttribute("license", license);
		List<Person> personList = personService.readAll();
		model.addAttribute("persons", personList);
		return "licenses/edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute License license, BindingResult result) {
		if(result.hasErrors()) return "licenses/edit.jsp";
		licenseService.updateOne(license);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		licenseService.destroyOneById(id);
		return "redirect:/dashboard";
	}
	
}
