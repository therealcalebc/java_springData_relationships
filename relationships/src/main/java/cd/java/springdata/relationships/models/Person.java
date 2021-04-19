/**
 * 
 */
package cd.java.springdata.relationships.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
//import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ccomstock
 *
 */
@Entity
@Table(name="persons")
public class Person implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5706341114030719016L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private License license;
    
    public Person() {
    	this("", "");
    }
    
    public Person(String fn, String ln) {
    	firstName = fn;
    	lastName = ln;
    }
    
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the license
	 */
//	@JsonProperty
	public License getLicense() {
		return license;
	}

	/**
	 * @param license the license to set
	 */
//	@JsonIgnore
	public void setLicense(License license) {
		this.license = license;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = Timestamp.valueOf(LocalDateTime.now());
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
	}
    
}
