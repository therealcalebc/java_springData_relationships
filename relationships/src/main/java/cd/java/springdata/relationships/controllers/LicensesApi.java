/**
 * 
 */
package cd.java.springdata.relationships.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cd.java.springdata.relationships.models.License;
import cd.java.springdata.relationships.services.LicenseService;
import cd.java.springdata.relationships.services.PersonService;

/**
 * @author ccomstock
 *
 */
@RestController
public class LicensesApi {

	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicensesApi(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@GetMapping("/api/licenses")
	public List<License> readAll() {
		return licenseService.readAll();
	}
	
	@PostMapping("/api/licenses")
	public License create(@RequestParam Date expDate, @RequestParam String state, @RequestParam Long personId) {
		License license = new License(expDate, state, personService.readOne(personId));
		return licenseService.createOne(license);
	}
	
	@GetMapping("/api/licenses/{id}")
	public License readOne(@PathVariable Long id) {
		License license = licenseService.readOne(id);
		return license;
	}
	
	@PutMapping("/api/licenses/{id}")
	public License update(@PathVariable Long id, @RequestParam Date expDate, @RequestParam String state, @RequestParam Long personId) {
		License license = licenseService.readOne(id);
		if(license != null) {
			license.setExpirationDate(expDate);
			license.setState(state);
			license.setPerson(personService.readOne(personId));
		}
		return licenseService.updateOne(license);
	}
	
	@DeleteMapping("/api/licenses/{id}")
	public void destroy(@PathVariable Long id) {
		licenseService.destroyOneById(id);
	}
	
}
