/**
 * 
 */
package cd.java.springdata.relationships.repositories;

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

	// this method retrieves all the songs from the database
	List<License> findAll();
	
	// this method finds songs with artists containing the search string
	List<License> findByPersonFirstNameContainingIgnoreCase(String search);
	
	// this method finds songs with artists containing the search string
	List<License> findByPersonLastNameContainingIgnoreCase(String search);
	
	// this method finds the 10 songs with the highest ratings in descending order
	List<License> findTop10ByOrderByPersonLastNameDesc();
	
	// this method counts how many songs have titles containing the search string
	Long countByStateContaining(String search);
	
	// this method deletes a song that has a title starting with the search string
	Long deleteByExpirationDateStartingWith(String search);
	
}
