/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.neoramon.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.neoramon.dto.PersonListResponseDto;
import com.github.neoramon.dto.PersonResponseDto;
import com.github.neoramon.entity.PersonEntity;
import com.github.neoramon.repository.PersonRepository;

@Component
@Path("/v1/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonEndpoint {

    @Autowired
    private PersonRepository personRepository;

    private static final Logger log = LoggerFactory.getLogger(PersonEndpoint.class);

    @GET
    public PersonListResponseDto get() {

        PersonListResponseDto dto;

        try {
            dto = new PersonListResponseDto(personRepository.findAll());
        } catch (Exception e) {
            log.error("Fail to get all", e);
            dto = new PersonListResponseDto(false, e.getMessage());
        }

        return dto;
    }

    @GET()
    @Path("{id : \\d+}")
    public PersonResponseDto get(@PathParam("id") Long id) {

        PersonResponseDto dto;
        try {
            PersonEntity entity = personRepository.findOne(id);
            boolean entityFound = entity != null;
            dto = new PersonResponseDto(entity, entityFound, entityFound ? null : "Entity not found!");
        } catch (Exception e) {
            log.error("Fail to get by id: " + id, e);
            dto = new PersonResponseDto(false, e.getMessage());
        }
        return dto;
    }

    @POST
    public PersonResponseDto save(PersonEntity entity) {
        PersonResponseDto dto;
        try {
            dto = new PersonResponseDto(personRepository.save(entity));
        } catch (Exception e) {
            log.error("Can't save: " + entity, e);
            dto = new PersonResponseDto(false, e.getMessage());
        }
        return dto;
    }

    @DELETE
    @Path("{id : \\d+}")
    public void delete(@PathParam("id") Long id) {
        try {
            personRepository.delete(id);
        } catch (Exception e) {
            log.error("Can't delete: " + id, e);
        }
    }
}
