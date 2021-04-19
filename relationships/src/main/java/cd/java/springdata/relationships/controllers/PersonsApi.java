/**
 * 
 */
package cd.java.springdata.relationships.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cd.java.springdata.relationships.models.Person;
import cd.java.springdata.relationships.services.PersonService;

/**
 * @author ccomstock
 *
 */
@RestController
public class PersonsApi {

	private final PersonService personService;
	
	public PersonsApi(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping("/api/persons")
	public List<Person> readAll() {
		return personService.readAll();
	}
	
	@PostMapping("/api/persons")
	public Person create(@RequestParam String firstName, @RequestParam String lastName) {
		Person person = new Person(firstName, lastName);
		return personService.createOne(person);
	}
	
	@GetMapping("/api/persons/{id}")
	public Person readOne(@PathVariable Long id) {
		Person person = personService.readOne(id);
		return person;
	}
	
	@PutMapping("/api/persons/{id}")
	public Person update(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName) {
		Person person = personService.readOne(id);
		if(person != null) {
			person.setFirstName(firstName);
			person.setLastName(lastName);
		}
		return personService.updateOne(person);
	}
	
	@DeleteMapping("/api/persons/{id}")
	public void destroy(@PathVariable Long id) {
		personService.destroyOneById(id);
	}
	
}
