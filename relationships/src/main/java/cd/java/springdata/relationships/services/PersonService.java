/**
 * 
 */
package cd.java.springdata.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cd.java.springdata.relationships.models.Person;
import cd.java.springdata.relationships.repositories.PersonRepository;

/**
 * @author ccomstock
 *
 */
@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepo) {
		personRepository = personRepo;
	}
	
	/**
	 * @param l the new Person to create in the db
	 * @return the newly created person
	 */
	public Person createOne(Person p) {
		return personRepository.save(p);
	}
	
	/**
	 * @return list of all the Persons in the db
	 */
	public List<Person> readAll() {
		return personRepository.findAll();
	}
	
	/**
	 * @param search the first name to search for persons by
	 * @return list of the persons in the db containing the first name
	 */
	public List<Person> readManyByFirstName(String search) {
		return personRepository.findByFirstNameContainingIgnoreCase(search);
	}
	
	/**
	 * @param search the last name to search for persons by
	 * @return list of the persons in the db containing the last name
	 */
	public List<Person> readManyByLastName(String search) {
		return personRepository.findByLastNameContainingIgnoreCase(search);
	}
	
	/**
	 * @param id the id of the Person to retrieve from the db
	 * @return the Person that was retrieved
	 */
	public Person readOne(Long id) {
		Optional<Person> optLang = personRepository.findById(id);
		if(optLang.isPresent())
			return optLang.get();
		else
			return null;
	}
	
	/**
	 * @param p the Person to update in the db
	 * @return the updated person
	 */
	public Person updateOne(Person p) {
		return personRepository.save(p);
	}
	
	/**
	 * @param id the id of the Person to delete from the db
	 */
	public void destroyOneById(Long id) {
		if(personRepository.existsById(id)) {
			personRepository.deleteById(id);
		}
	}
	
	/**
	 * @param first the first name of the Person to delete from the db
	 * @param last the last name of the Person to delete from the db
	 */
	public void destroyOneByFirstAndLastName(String first, String last) {
		personRepository.deleteByFirstNameAndLastNameIgnoringCase(first, last);
	}
	
}
