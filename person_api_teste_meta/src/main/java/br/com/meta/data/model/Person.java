package br.com.meta.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;




@Entity
@Table (name="person")
@EntityListeners(AuditingEntityListener.class)
public class Person  extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column (name="name_person", nullable = false, length = 80)
	private String namePerson;
	
	@Column (name="gender_person", length = 6)
	private String genderPerson;
	
	@Column(name="mail_person", length = 100)
	private String mailPerson;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_birth_person")
	private Date dtBirthPerson;
	
	@Column(name="native_person", length = 40)
	private String nativePerson;
	
	@Column(name="nationality_person", length = 40)
	private String nationalityPerson;
	
	@Column(name="cpf_person", length = 11)
	private String cpfPerson;
	
	/* Auditing BD*/
	@Column(name = "created_by")
	@CreatedBy
	private String createdBy;
	
	@Column(name = "created_date")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "modified_by")
	@LastModifiedBy
	private String modifiedBy;
	
	@Column(name = "modified_date")
	@LastModifiedDate
	private Date modifiedDate;
	
	public Person() {}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpfPerson == null) ? 0 : cpfPerson.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((dtBirthPerson == null) ? 0 : dtBirthPerson.hashCode());
		result = prime * result + ((genderPerson == null) ? 0 : genderPerson.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mailPerson == null) ? 0 : mailPerson.hashCode());
		result = prime * result + ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
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
		Person other = (Person) obj;
		if (cpfPerson == null) {
			if (other.cpfPerson != null)
				return false;
		} else if (!cpfPerson.equals(other.cpfPerson))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
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
		if (id != other.id)
			return false;
		if (mailPerson == null) {
			if (other.mailPerson != null)
				return false;
		} else if (!mailPerson.equals(other.mailPerson))
			return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
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
