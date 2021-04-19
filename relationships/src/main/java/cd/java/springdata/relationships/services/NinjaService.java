/**
 * 
 */
package cd.java.springdata.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cd.java.springdata.relationships.models.Ninja;
import cd.java.springdata.relationships.repositories.NinjaRepository;

/**
 * @author ccomstock
 *
 */
@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		ninjaRepository = ninjaRepo;
	}
	
	/**
	 * @param l the new Ninja to create in the db
	 * @return the newly created ninja
	 */
	public Ninja createOne(Ninja p) {
		return ninjaRepository.save(p);
	}
	
	/**
	 * @return list of all the Ninjas in the db
	 */
	public List<Ninja> readAll() {
		return ninjaRepository.findAll();
	}
	
	/**
	 * @param search the first name to search for ninjas by
	 * @return list of the ninjas in the db containing the first name
	 */
	public List<Ninja> readManyByFirstName(String search) {
		return ninjaRepository.findByFirstNameContainingIgnoreCase(search);
	}
	
	/**
	 * @param search the last name to search for ninjas by
	 * @return list of the ninjas in the db containing the last name
	 */
	public List<Ninja> readManyByLastName(String search) {
		return ninjaRepository.findByLastNameContainingIgnoreCase(search);
	}
	
	/**
	 * @param id the id of the Ninja to retrieve from the db
	 * @return the Ninja that was retrieved
	 */
	public Ninja readOne(Long id) {
		Optional<Ninja> optLang = ninjaRepository.findById(id);
		if(optLang.isPresent())
			return optLang.get();
		else
			return null;
	}
	
	/**
	 * @param p the Ninja to update in the db
	 * @return the updated ninja
	 */
	public Ninja updateOne(Ninja p) {
		return ninjaRepository.save(p);
	}
	
	/**
	 * @param id the id of the Ninja to delete from the db
	 */
	public void destroyOneById(Long id) {
		if(ninjaRepository.existsById(id)) {
			ninjaRepository.deleteById(id);
		}
	}
	
	/**
	 * @param first the first name of the Ninja to delete from the db
	 * @param last the last name of the Ninja to delete from the db
	 */
	public void destroyOneByFirstAndLastName(String first, String last) {
		ninjaRepository.deleteByFirstNameAndLastNameIgnoringCase(first, last);
	}
	
}
