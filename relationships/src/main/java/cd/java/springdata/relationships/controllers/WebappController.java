/**
 * 
 */
package cd.java.springdata.relationships.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cd.java.springdata.relationships.models.Dojo;
import cd.java.springdata.relationships.models.License;
import cd.java.springdata.relationships.models.Ninja;
import cd.java.springdata.relationships.models.Person;
import cd.java.springdata.relationships.services.DojoService;
import cd.java.springdata.relationships.services.LicenseService;
import cd.java.springdata.relationships.services.NinjaService;
import cd.java.springdata.relationships.services.PersonService;

/**
 * @author ccomstock
 *
 */
@Controller
public class WebappController {

	private final PersonService personService;
	private final LicenseService licenseService;
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public WebappController(PersonService personServ, LicenseService licenseServ, DojoService dojoServ, NinjaService ninjaServ) {
		personService = personServ;
		licenseService = licenseServ;
		dojoService = dojoServ;
		ninjaService = ninjaServ;
	}
	
	@GetMapping("/dashboardPL")
	public String viewDashboardPL(Model model) {
		List<Person> personList = personService.readAll();
		List<License> licenseList = licenseService.readAll();
		model.addAttribute("persons", personList);
		model.addAttribute("licenses", licenseList);
		return "dashboard/indexPL.jsp";
	}
	
	@GetMapping("/dashboardDN")
	public String viewDashboardDN(Model model) {
		List<Dojo> dojoList = dojoService.readAll();
		List<Ninja> ninjaList = ninjaService.readAll();
		model.addAttribute("dojos", dojoList);
		model.addAttribute("ninjas", ninjaList);
		return "dashboard/indexDN.jsp";
	}
	
}
