package matheus.adps.com.br.sistemadetrocas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSignupDTO
{
	@JsonProperty
	private String email;
	
	@JsonProperty
	private String password;
	
	@JsonProperty
	private String fullName;
	
	@JsonProperty
	private String gender;
	
	@JsonProperty
	private String address;
	
	@JsonProperty
	private String complement;
	
	@JsonProperty
	private String state;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private int zipCode;

	public UserSignupDTO() {			
	}

	public UserSignupDTO(
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

	public String getComplement() {
		return complement;
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
}