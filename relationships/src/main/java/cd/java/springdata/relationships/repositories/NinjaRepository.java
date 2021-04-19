/**
 * 
 */
package cd.java.springdata.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cd.java.springdata.relationships.models.Ninja;

/**
 * @author ccomstock
 *
 */
@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	// this method retrieves all the ninjas from the database
	List<Ninja> findAll();
	
	// this method finds ninjas with first name containing the search string
	List<Ninja> findByFirstNameContainingIgnoreCase(String search);
	
	// this method finds ninjas with last name containing the search string
	List<Ninja> findByLastNameContainingIgnoreCase(String search);
	
	// this method finds the 10 ninjas with the lowest age in ascending order
	List<Ninja> findFirst10ByOrderByAgeAsc();
	
	// this method finds the 10 ninjas with the highest age in descending order
	List<Ninja> findFirst10ByOrderByAgeDesc();
	
	// this method deletes a ninja by matching firstName and lastName
	Long deleteByFirstNameAndLastNameIgnoringCase(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
}
