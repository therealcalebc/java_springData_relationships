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

import cd.java.springdata.relationships.models.Person;
import cd.java.springdata.relationships.services.PersonService;

/**
 * @author ccomstock
 *
 */
@Controller
@RequestMapping("/persons")
public class PersonsController {

	private final PersonService personService;
	
	public PersonsController(PersonService personServ) {
		personService = personServ;
	}
	
	@GetMapping("/new")
	public String viewNew(@ModelAttribute Person person) {
		return "PL/persons/new.jsp";
	}
	
	@PostMapping
	public String addNew(@Valid @ModelAttribute Person person, BindingResult result) {
		if(result.hasErrors()) return "PL/persons/new.jsp";
		personService.createOne(person);
		return "redirect:/PL/dashboard";
	}
	
	@GetMapping("/{id}")
	public String viewShow(@PathVariable Long id, Model model) {
		Person person = personService.readOne(id);
		if(person == null) return "redirect:/PL/dashboard";
		model.addAttribute("person", person);
		return "PL/persons/show.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String viewEdit(@PathVariable Long id, Model model) {
		Person person = personService.readOne(id);
		if(person == null) return "redirect:/PL/dashboard";
		model.addAttribute("person", person);
		return "PL/persons/edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute Person person, BindingResult result) {
		if(result.hasErrors()) return "PL/persons/edit.jsp";
		personService.updateOne(person);
		return "redirect:/PL/dashboard";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		personService.destroyOneById(id);
		return "redirect:/PL/dashboard";
	}
	
}
