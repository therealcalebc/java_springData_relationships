/**
 * 
 */
package cd.java.springdata.relationships.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cd.java.springdata.relationships.models.License;
import cd.java.springdata.relationships.repositories.LicenseRepository;

/**
 * @author ccomstock
 *
 */
@Service
public class LicenseService {

	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepo) {
		licenseRepository = licenseRepo;
	}
	
	/**
	 * @param l the new License to create in the db
	 * @return the newly created person
	 */
	public License createOne(License p) {
		int last = Integer.parseUnsignedInt(licenseRepository.findFirstByOrderByNumberDesc().getNumber());
    	p.setNumber(String.format("%06d", last + 1));
		return licenseRepository.save(p);
	}
	
	/**
	 * @return list of all the Licenses in the db
	 */
	public List<License> readAll() {
		return licenseRepository.findAll();
	}
	
	/**
	 * @param search the first name to search for persons by
	 * @return list of the persons in the db containing the first name
	 */
	public List<License> readManyByFirstName(String search) {
		return licenseRepository.findByPersonFirstNameContainingIgnoreCase(search);
	}
	
	/**
	 * @param search the last name to search for persons by
	 * @return list of the persons in the db containing the last name
	 */
	public List<License> readManyByLastName(String search) {
		return licenseRepository.findByPersonLastNameContainingIgnoreCase(search);
	}
	
	/**
	 * @param id the id of the License to retrieve from the db
	 * @return the License that was retrieved
	 */
	public License readOne(Long id) {
		Optional<License> optLicense = licenseRepository.findById(id);
		if(optLicense.isPresent())
			return optLicense.get();
		else
			return null;
	}
	
	/**
	 * @param p the License to update in the db
	 * @return the updated person
	 */
	public License updateOne(License p) {
		return licenseRepository.save(p);
	}
	
	/**
	 * @param id the id of the License to delete from the db
	 */
	public void destroyOneById(Long id) {
		if(licenseRepository.existsById(id)) {
			licenseRepository.deleteById(id);
		}
	}
	
	/**
	 * 
	 * 
	 */
	public void destroyManyExpired() {
		licenseRepository.deleteByExpirationDateBefore(new Date());
	}
	
}
