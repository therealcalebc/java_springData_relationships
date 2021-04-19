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

import cd.java.springdata.relationships.models.Ninja;
import cd.java.springdata.relationships.services.NinjaService;

/**
 * @author ccomstock
 *
 */
@RestController
public class NinjasApi {

	private final NinjaService ninjaService;
	
	public NinjasApi(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("/api/ninjas")
	public List<Ninja> readAll() {
		return ninjaService.readAll();
	}
	
	@PostMapping("/api/ninjas")
	public Ninja create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age) {
		Ninja ninja = new Ninja(firstName, lastName, age);
		return ninjaService.createOne(ninja);
	}
	
	@GetMapping("/api/ninjas/{id}")
	public Ninja readOne(@PathVariable Long id) {
		Ninja ninja = ninjaService.readOne(id);
		return ninja;
	}
	
	@PutMapping("/api/ninjas/{id}")
	public Ninja update(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age) {
		Ninja ninja = ninjaService.readOne(id);
		if(ninja != null) {
			ninja.setFirstName(firstName);
			ninja.setLastName(lastName);
			ninja.setAge(age);
		}
		return ninjaService.updateOne(ninja);
	}
	
	@DeleteMapping("/api/ninjas/{id}")
	public void destroy(@PathVariable Long id) {
		ninjaService.destroyOneById(id);
	}
	
}
