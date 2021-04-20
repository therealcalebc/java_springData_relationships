/**
 * 
 */
package cd.java.springdata.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cd.java.springdata.relationships.models.Dojo;
import cd.java.springdata.relationships.repositories.DojoRepository;

/**
 * @author ccomstock
 *
 */
@Service
public class DojoService {

	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepo) {
		dojoRepository = dojoRepo;
	}
	
	/**
	 * @param l the new Dojo to create in the db
	 * @return the newly created person
	 */
	public Dojo createOne(Dojo d) {
		return dojoRepository.save(d);
	}
	
	/**
	 * @return list of all the Dojos in the db
	 */
	public List<Dojo> readAll() {
		return dojoRepository.findAll();
	}
	
	/**
	 * @param search the name to search for dojos by
	 * @return list of the dojos in the db with name containing the search string
	 */
	public List<Dojo> readManyByName(String search) {
		return dojoRepository.findByNameContainingIgnoringCase(search);
	}
	
	/**
	 * @param id the id of the Dojo to retrieve from the db
	 * @return the Dojo that was retrieved
	 */
	public Dojo readOne(Long id) {
		Optional<Dojo> optDojo = dojoRepository.findById(id);
		if(optDojo.isPresent())
			return optDojo.get();
		else
			return null;
	}
	
	/**
	 * @param d the Dojo to update in the db
	 * @return the updated Dojo
	 */
	public Dojo updateOne(Dojo d) {
		return dojoRepository.save(d);
	}
	
	/**
	 * @param id the id of the Dojo to delete from the db
	 */
	public void destroyOneById(Long id) {
		if(dojoRepository.existsById(id)) {
			dojoRepository.deleteById(id);
		}
	}
	
	/**
	 * 
	 * 
	 */
	public void destroyByName(String name) {
		dojoRepository.deleteByNameIs(name);
	}
	
}
