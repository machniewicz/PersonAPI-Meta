package br.com.meta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meta.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}