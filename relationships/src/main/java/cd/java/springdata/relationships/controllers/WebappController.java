/**
 * 
 */
package cd.java.springdata.relationships.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cd.java.springdata.relationships.models.License;
import cd.java.springdata.relationships.models.Person;
import cd.java.springdata.relationships.services.LicenseService;
import cd.java.springdata.relationships.services.PersonService;

/**
 * @author ccomstock
 *
 */
@Controller
public class WebappController {

	private final PersonService personService;
	private final LicenseService licenseService;
	
	public WebappController(PersonService personServ, LicenseService licenseServ) {
		personService = personServ;
		licenseService = licenseServ;
	}
	
	@GetMapping("/dashboard")
	public String viewDashboard(Model model) {
		List<Person> personList = personService.readAll();
		List<License> licenseList = licenseService.readAll();
		model.addAttribute("persons", personList);
		model.addAttribute("licenses", licenseList);
		return "dashboard/index.jsp";
	}
	
}
