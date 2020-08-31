package br.com.meta.controller.v2;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meta.data.vo.v2.PersonVOV2;
import br.com.meta.services.v2.PersonServicesV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "PersonEndpoint - Version 2")
@RestController
@RequestMapping("/api/person/v2")

public class PersonControllerV2 {
	
	@Autowired
	private PersonServicesV2 service;
		
	@ApiOperation(value = "Find all people" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<PersonVOV2> findAll() {
		List<PersonVOV2> persons =  service.findAll();
		persons
			.stream()
			.forEach(p -> p.add(
					linkTo(methodOn(PersonControllerV2.class).findById(p.getKey())).withSelfRel()
				)
			);
		return persons;
	}	
	
	@ApiOperation(value = "Find a specific person by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVOV2 findById(@PathVariable("id") Long id) {
		PersonVOV2 personVO = service.findById(id);
		personVO.add(linkTo(methodOn(PersonControllerV2.class).findById(id)).withSelfRel());
		return personVO;
	}	
	
	@ApiOperation(value = "Create a new person") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVOV2 create(@RequestBody PersonVOV2 person) {
		PersonVOV2 personVO = service.create(person);
		personVO.add(linkTo(methodOn(PersonControllerV2.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}
	
	@ApiOperation(value = "Update a specific person")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVOV2 update(@RequestBody PersonVOV2 person) {
		PersonVOV2 personVO = service.update(person);
		personVO.add(linkTo(methodOn(PersonControllerV2.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}	
	
	@ApiOperation(value = "Delete a specific person by your ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}