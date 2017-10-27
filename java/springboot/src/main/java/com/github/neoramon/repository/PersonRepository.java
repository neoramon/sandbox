package com.github.neoramon.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.neoramon.entity.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, Long>, PersonRepositoryCustom {

}