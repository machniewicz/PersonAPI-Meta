package br.com.meta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meta.converter.DozerConverter;
import br.com.meta.data.model.Person;
import br.com.meta.data.vo.v1.PersonVO;
import br.com.meta.exception.ResourceNotFoundException;
import br.com.meta.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
		
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}	
	
	public PersonVO findById(Long id) {

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
		
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setNamePerson(person.getNamePerson());
		entity.setGenderPerson(person.getGenderPerson());
		entity.setMailPerson(person.getMailPerson());
		entity.setDtBirthPerson(person.getDtBirthPerson());
		entity.setNativePerson(person.getNativePerson());
		entity.setNationalityPerson(person.getNationalityPerson());
		entity.setCpfPerson(person.getCpfPerson());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;
	}	
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

}
