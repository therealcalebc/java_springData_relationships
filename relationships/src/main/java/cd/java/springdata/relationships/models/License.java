/**
 * 
 */
package cd.java.springdata.relationships.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ccomstock
 *
 */
@Entity
@Table(name="licenses")
public class License implements java.io.Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6834461966200727291L;
//	private static int licenseCounter = 0;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Date expirationDate;
    private String state;
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp updatedAt;
	@JsonIgnore
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    
    public License() {
    	expirationDate = defaultExpirationDate();
    }
    
    public License(Date expirationDate, String state, Person person) {
    	this.expirationDate = expirationDate;
    	this.state = state;
    	this.person = person;
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
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the createdAt
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * @return the updatedAt
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	

	@JsonProperty("personName")
	public String getPersonName() {
		return String.format("%s %s", person.getFirstName(), person.getLastName());
	}

	@PrePersist
	protected void onCreate() {
//    	License.licenseCounter++;
//    	number = String.format("%06d", License.licenseCounter);
		this.createdAt = Timestamp.valueOf(LocalDateTime.now());
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
	}
	
	public static Date defaultExpirationDate() {
		return Date.valueOf(LocalDate.now().plusYears(5));
	}
	
}
