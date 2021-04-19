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
import cd.java.springdata.relationships.services.DojoService;

/**
 * @author ccomstock
 *
 */
@RestController
public class DojosApi {

	private final DojoService dojoService;
	
	public DojosApi(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@GetMapping("/api/dojos")
	public List<Dojo> readAll() {
		return dojoService.readAll();
	}
	
	@PostMapping("/api/dojos")
	public Dojo create(@RequestParam String name) {
		Dojo dojo = new Dojo(name);
		return dojoService.createOne(dojo);
	}
	
	@GetMapping("/api/dojos/{id}")
	public Dojo readOne(@PathVariable Long id) {
		Dojo dojo = dojoService.readOne(id);
		return dojo;
	}
	
	@PutMapping("/api/dojos/{id}")
	public Dojo update(@PathVariable Long id, @RequestParam String name) {
		Dojo dojo = dojoService.readOne(id);
		if(dojo != null) {
			dojo.setName(name);
		}
		return dojoService.updateOne(dojo);
	}
	
	@DeleteMapping("/api/dojos/{id}")
	public void destroy(@PathVariable Long id) {
		dojoService.destroyOneById(id);
	}
	
}
