/**
 * 
 */
package cd.java.springdata.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cd.java.springdata.relationships.models.Person;

/**
 * @author ccomstock
 *
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	// this method retrieves all the songs from the database
	List<Person> findAll();
	
	// this method finds songs with artists containing the search string
	List<Person> findByFirstNameContainingIgnoreCase(String search);
	
	// this method finds songs with artists containing the search string
	List<Person> findByLastNameContainingIgnoreCase(String search);
	
	// this method finds the 10 songs with the highest ratings in descending order
	List<Person> findTop10ByOrderByLicenseDesc();
	
	// this method counts how many songs have titles containing the search string
	Long countByLicenseStateContaining(String search);
	
	// this method deletes a song that has a title starting with the search string
	Long deleteByLicenseExpirationDateStartingWith(String search);
	
}
