/**
 * 
 */
package cd.java.springdata.relationships.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cd.java.springdata.relationships.models.License;

/**
 * @author ccomstock
 *
 */
@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

	// this method retrieves all the licenses from the database
	List<License> findAll();
	
	// this method finds licenses associated with persons with first name containing the search string
	List<License> findByPersonFirstNameContainingIgnoreCase(String search);
	
	// this method finds licenses associated with persons with last name containing the search string
	List<License> findByPersonLastNameContainingIgnoreCase(String search);
	
	// this method counts how many licenses have state containing the search string
	Long countByStateContaining(String search);
	
	// this method deletes a license that has a expiration date before the given date
	Long deleteByExpirationDateBefore(Date date);
	
}
