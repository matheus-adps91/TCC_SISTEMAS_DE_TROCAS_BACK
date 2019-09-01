package matheus.adps.com.br.sistemadetrocas.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table( name = "user_entity", schema = "public" )

public class User 
{
	@Id	
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotNull
	@Column( nullable = false )
	private String email;
	
	@NotNull
	@Column( nullable = false)
	private String password;
	
	@NotNull
	@Column( nullable = false )
	private String fullName;
	 
	@NotNull
	@Column( nullable = false)
	private String gender;
	
	@NotNull
	@Column( nullable = false )
	private String address;
	
	@Column( nullable = true )
	private String complement;
	
	@NotNull
	@Column( nullable = false )
	private String state;
	
	@NotNull
	@Column( nullable = false )
	private String city;
	
	@NotNull
	@Column( nullable = false )
	private int zipCode;

	
	public User() {
	}

	public User(
			String email, 
			String password, 
			String fullName, 
			String gender, 
			String address, 
			String complement,
			String state, 
			String city, 
			int zipCode) 
	{
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.complement = complement;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
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

	public void setComplement(String complement) {
		this.complement = complement;
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