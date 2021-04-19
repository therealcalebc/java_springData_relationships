/**
 * 
 */
package cd.java.springdata.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cd.java.springdata.relationships.models.Person;

/**
 * @author ccomstock
 *
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	// this method retrieves all the persons from the database
	List<Person> findAll();
	
	// this method finds persons with first name containing the search string
	List<Person> findByFirstNameContainingIgnoreCase(String search);
	
	// this method finds persons with last name containing the search string
	List<Person> findByLastNameContainingIgnoreCase(String search);
	
	// this method finds the 10 persons with the lowest license number in descending order
	List<Person> findFirst10ByOrderByLicenseNumberAsc();
	
	// this method finds the 10 persons with the highest license number in descending order
	List<Person> findFirst10ByOrderByLicenseNumberDesc();
	
	// this method counts how many persons have a license with state containing the search string
	Long countByLicenseStateContaining(String search);
	
	// this method deletes a person by matching firstName and lastName
	Long deleteByFirstNameAndLastNameIgnoringCase(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
}
