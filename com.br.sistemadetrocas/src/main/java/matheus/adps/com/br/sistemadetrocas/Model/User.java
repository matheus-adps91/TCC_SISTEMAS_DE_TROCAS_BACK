package matheus.adps.com.br.sistemadetrocas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table( name = "user_entity", schema = "public" )
public class User 
{
	@Id
	@SequenceGenerator( name = "gen_user_seq", sequenceName = "user_seq", allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "gen_user_seq")
	private Integer id;
	
	@NotNull
	@Column
	private String email;
	
	@NotNull
	@Column
	private String password;
	
	@NotNull
	@Column
	private String fullName;
	 
	@NotNull
	@Column
	private String gender;
	
	@NotNull
	@Column
	private String address;
	
	@Column
	private String houseNumber;
	
	@Column
	private String state;
	
	@NotNull
	@Column
	private String city;
	
	@NotNull
	@Column
	private int zipCode;
	
	@NotNull
	@Column
	private boolean compliance;

	public User() {
	}

	public User(
			String email, 
			String password, 
			String fullName, 
			String gender, 
			String address, 
			String houseNumber,
			String state, 
			String city, 
			int zipCode, 
			boolean compliance) 
	{
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.houseNumber = houseNumber;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.compliance = compliance;
	}

	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFullName() {
		return fullName;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public boolean isCompliance() {
		return compliance;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}