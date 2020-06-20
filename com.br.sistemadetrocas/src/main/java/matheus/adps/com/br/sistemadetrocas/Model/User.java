package matheus.adps.com.br.sistemadetrocas.Model;

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
	private String zipCode;
	
	@Column
	private String complement;
	
	@NotNull
	@Column
	private boolean compliance;

	public User() {
	}

	public User(
			final Integer id,
			final String email, 
			final String password, 
			final String fullName, 
			final String gender, 
			final String address, 
			final String houseNumber,
			final String state, 
			final String city, 
			final String zipCode,
			final String complement,
			final boolean compliance) 
	{
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.houseNumber = houseNumber;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.complement = complement;
		this.compliance = compliance;
	}

	public User(
			final String email, 
			final String password, 
			final String fullName, 
			final String gender, 
			final String address, 
			final String houseNumber,
			final String state, 
			final String city, 
			final String zipCode,
			final String complement,
			final boolean compliance) 
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
		this.complement = complement;
		this.compliance = compliance;
	}
	
	public String getComplement() {
		return complement;
	}

	public void setComplement(
			final String complement) {
		this.complement = complement;
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

	public String getZipCode() {
		return zipCode;
	}

	public boolean isCompliance() {
		return compliance;
	}

	public void setEmail(
			final String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}
	
	public void setPassword(
			final String password) {
		this.password = password;
	}

	public void setFullName(
			final String fullName) {
		this.fullName = fullName;
	}

	public void setGender(
			final String gender) {
		this.gender = gender;
	}

	public void setAddress(
			final String address) {
		this.address = address;
	}

	public void setHouseNumber(
			final String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setState(
			final String state) {
		this.state = state;
	}

	public void setCity(
			final String city) {
		this.city = city;
	}

	public void setZipCode(
			final String zipCode) {
		this.zipCode = zipCode;
	}
}