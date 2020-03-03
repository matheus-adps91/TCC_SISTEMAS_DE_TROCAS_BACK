package matheus.adps.com.br.sistemadetrocas.dto;

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
	private String houseNumber;
	
	@JsonProperty
	private String state;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private String zipCode;
	
	@JsonProperty
	private String complement;
	
	@JsonProperty
	private boolean compliance;

	public UserSignupDTO() {			
	}

	public UserSignupDTO(
			final String email, 
			final String password, 
			final String fullName, 
			final String gender, 
			final String address, 
			final String number,
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
		this.houseNumber = number;
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

	public String getZipCode() {
		return zipCode;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public boolean getCompliance() {
		return compliance;
	}
}