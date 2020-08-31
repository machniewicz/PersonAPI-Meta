package br.com.meta.services.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meta.converter.DozerConverter;
import br.com.meta.data.model.Person;
import br.com.meta.data.vo.v2.PersonVOV2;
import br.com.meta.exception.ResourceNotFoundException;
import br.com.meta.repository.PersonRepository;

@Service
public class PersonServicesV2 {
	
	@Autowired
	PersonRepository repository;
		
	public PersonVOV2 create(PersonVOV2 person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVOV2.class);
		return vo;
	}
	
	public List<PersonVOV2> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVOV2.class);
	}	
	
	public PersonVOV2 findById(Long id) {

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVOV2.class);
	}
		
	public PersonVOV2 update(PersonVOV2 person) {
		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setNamePerson(person.getNamePerson());
		entity.setGenderPerson(person.getGenderPerson());
		entity.setMailPerson(person.getMailPerson());
		entity.setDtBirthPerson(person.getDtBirthPerson());
		entity.setNativePerson(person.getNativePerson());
		entity.setNationalityPerson(person.getNationalityPerson());
		entity.setCpfPerson(person.getCpfPerson());
		entity.setAddressPerson(person.getAddressPerson());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVOV2.class);
		
		return vo;
	}	
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

}
