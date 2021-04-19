/**
 * 
 */
package cd.java.springdata.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cd.java.springdata.relationships.models.Dojo;

/**
 * @author ccomstock
 *
 */
@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {

	// this method retrieves all the dojos from the database
	List<Dojo> findAll();
	
	// this method finds dojos with name containing the search string ignoring case
	List<Dojo> findByNameContainingIgnoringCase(String search);
	
	// this method deletes a dojo that has name matching the search strings
	Long deleteByNameIs(String name);
	
}
