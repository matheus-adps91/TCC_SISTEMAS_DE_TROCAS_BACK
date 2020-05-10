package matheus.adps.com.br.sistemadetrocas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateDTO
{
	@JsonProperty
	private String email;
	
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

	public UserUpdateDTO() {				
	}

	public UserUpdateDTO(
			String email,
			String fullName, 
			String gender, 
			String address, 
			String houseNumber, 
			String state, 
			String city,
			String complement,
			String zipCode)
	{
		this.email = email;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.houseNumber = houseNumber;
		this.state = state;
		this.city = city;
		this.complement = complement;
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
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
}