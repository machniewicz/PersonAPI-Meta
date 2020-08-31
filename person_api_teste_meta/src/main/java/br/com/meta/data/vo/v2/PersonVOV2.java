package br.com.meta.data.vo.v2;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "namePerson", "genderPerson", "mailPerson", 
	"dtBirthPerson", "nativePerson", "nationalityPerson", "cpfPerson", "addressPerson"})
public class PersonVOV2 extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@JsonProperty("id")
	private Long key;
	private String namePerson;
	private String genderPerson;
	private String mailPerson;
	private Date dtBirthPerson;
	private String nativePerson;
	private String nationalityPerson;
	private String cpfPerson;	
	private String addressPerson;
	
	public PersonVOV2() {
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public String getGenderPerson() {
		return genderPerson;
	}

	public void setGenderPerson(String genderPerson) {
		this.genderPerson = genderPerson;
	}

	public String getMailPerson() {
		return mailPerson;
	}

	public void setMailPerson(String mailPerson) {
		this.mailPerson = mailPerson;
	}

	public Date getDtBirthPerson() {
		return dtBirthPerson;
	}

	public void setDtBirthPerson(Date dtBirthPerson) {
		this.dtBirthPerson = dtBirthPerson;
	}

	public String getNativePerson() {
		return nativePerson;
	}

	public void setNativePerson(String nativePerson) {
		this.nativePerson = nativePerson;
	}

	public String getNationalityPerson() {
		return nationalityPerson;
	}

	public void setNationalityPerson(String nationalityPerson) {
		this.nationalityPerson = nationalityPerson;
	}

	public String getCpfPerson() {
		return cpfPerson;
	}

	public void setCpfPerson(String cpfPerson) {
		this.cpfPerson = cpfPerson;
	}

	public String getAddressPerson() {
		return addressPerson;
	}

	public void setAddressPerson(String addressPerson) {
		this.addressPerson = addressPerson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((addressPerson == null) ? 0 : addressPerson.hashCode());
		result = prime * result + ((cpfPerson == null) ? 0 : cpfPerson.hashCode());
		result = prime * result + ((dtBirthPerson == null) ? 0 : dtBirthPerson.hashCode());
		result = prime * result + ((genderPerson == null) ? 0 : genderPerson.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((mailPerson == null) ? 0 : mailPerson.hashCode());
		result = prime * result + ((namePerson == null) ? 0 : namePerson.hashCode());
		result = prime * result + ((nationalityPerson == null) ? 0 : nationalityPerson.hashCode());
		result = prime * result + ((nativePerson == null) ? 0 : nativePerson.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVOV2 other = (PersonVOV2) obj;
		if (addressPerson == null) {
			if (other.addressPerson != null)
				return false;
		} else if (!addressPerson.equals(other.addressPerson))
			return false;
		if (cpfPerson == null) {
			if (other.cpfPerson != null)
				return false;
		} else if (!cpfPerson.equals(other.cpfPerson))
			return false;
		if (dtBirthPerson == null) {
			if (other.dtBirthPerson != null)
				return false;
		} else if (!dtBirthPerson.equals(other.dtBirthPerson))
			return false;
		if (genderPerson == null) {
			if (other.genderPerson != null)
				return false;
		} else if (!genderPerson.equals(other.genderPerson))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (mailPerson == null) {
			if (other.mailPerson != null)
				return false;
		} else if (!mailPerson.equals(other.mailPerson))
			return false;
		if (namePerson == null) {
			if (other.namePerson != null)
				return false;
		} else if (!namePerson.equals(other.namePerson))
			return false;
		if (nationalityPerson == null) {
			if (other.nationalityPerson != null)
				return false;
		} else if (!nationalityPerson.equals(other.nationalityPerson))
			return false;
		if (nativePerson == null) {
			if (other.nativePerson != null)
				return false;
		} else if (!nativePerson.equals(other.nativePerson))
			return false;
		return true;
	}

	
}