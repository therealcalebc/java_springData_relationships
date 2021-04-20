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

import cd.java.springdata.relationships.models.Dojo;
import cd.java.springdata.relationships.models.Ninja;
import cd.java.springdata.relationships.services.DojoService;
import cd.java.springdata.relationships.services.NinjaService;

/**
 * @author ccomstock
 *
 */
@RestController
public class NinjasApi {

	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjasApi(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@GetMapping("/api/ninjas")
	public List<Ninja> readAll() {
		return ninjaService.readAll();
	}
	
	@PostMapping("/api/ninjas")
	public Ninja create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age, @RequestParam Long dojoId) {
		Dojo dojo = dojoService.readOne(dojoId);
		Ninja ninja = new Ninja(firstName, lastName, age, dojo);
		return ninjaService.createOne(ninja);
	}
	
	@GetMapping("/api/ninjas/{id}")
	public Ninja readOne(@PathVariable Long id) {
		Ninja ninja = ninjaService.readOne(id);
		return ninja;
	}
	
	@PutMapping("/api/ninjas/{id}")
	public Ninja update(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age, @RequestParam Long dojoId) {
		Ninja ninja = ninjaService.readOne(id);
		Dojo dojo = dojoService.readOne(dojoId);
		if(ninja != null && dojo != null) {
			ninja.setFirstName(firstName);
			ninja.setLastName(lastName);
			ninja.setAge(age);
			ninja.setDojo(dojo);
		}
		return ninjaService.updateOne(ninja);
	}
	
	@DeleteMapping("/api/ninjas/{id}")
	public void destroy(@PathVariable Long id) {
		ninjaService.destroyOneById(id);
	}
	
}
