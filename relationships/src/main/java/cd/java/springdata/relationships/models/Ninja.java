/**
 * 
 */
package cd.java.springdata.relationships.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="ninjas")
public class Ninja implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2542080832142145362L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private LocalDateTime createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private LocalDateTime updatedAt;
	@JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
    public Ninja() {}
    
    public Ninja(String fn, String ln, Integer age, Dojo dojo) {
    	firstName = fn;
    	lastName = ln;
    	this.age = age;
    	this.dojo = dojo;
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
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the Dojo
	 */
	public Dojo getDojo() {
		return dojo;
	}

	/**
	 * @param dojo the Dojo to set
	 */
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}

	@JsonProperty("dojoName")
	public String getDojoName() {
		return dojo.getName();
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
    
}
