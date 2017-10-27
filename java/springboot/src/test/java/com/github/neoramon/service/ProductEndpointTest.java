package com.github.neoramon.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.neoramon.dto.PersonResponseDto;
import com.github.neoramon.entity.PersonEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String PRODUCT_URL = "/v1/person";

    private static final String DEFAULT_PERSON_NAME = "Ramon";

    @Test
    public void createAndReadProduct() {
        Class<PersonResponseDto> responseType = PersonResponseDto.class;
        PersonEntity person = new PersonEntity();
        person.setName(DEFAULT_PERSON_NAME);
        person.setEmail("123@test.com");

        ResponseEntity<PersonResponseDto> response = this.restTemplate.postForEntity(PRODUCT_URL, person, responseType);

        PersonResponseDto dto = response.getBody();

        assertThat(dto.getSuccess()).isTrue();
        assertThat(dto.getEntity()).isNotNull();
        assertThat(dto.getEntity().getId()).isNotNull();

        ResponseEntity<PersonResponseDto> read = this.restTemplate
                .getForEntity(PRODUCT_URL + "/" + dto.getEntity().getId(), responseType);

        dto = read.getBody();
        assertThat(dto.getSuccess()).isTrue();
        PersonEntity entity = dto.getEntity();
        assertThat(entity.getName()).isEqualTo(DEFAULT_PERSON_NAME);

    }

    @Test
    public void createAndDelete() {
        Class<PersonResponseDto> responseType = PersonResponseDto.class;
        PersonEntity person = new PersonEntity();
        person.setName(DEFAULT_PERSON_NAME);
        person.setEmail("123@test.com");

        ResponseEntity<PersonResponseDto> response = this.restTemplate.postForEntity(PRODUCT_URL, person, responseType);

        PersonResponseDto dto = response.getBody();

        this.restTemplate.delete(PRODUCT_URL + "/" + dto.getEntity().getId());

        ResponseEntity<PersonResponseDto> resp = this.restTemplate
                .getForEntity(PRODUCT_URL + "/" + dto.getEntity().getId(), responseType);
        assertThat(resp.getBody().getSuccess()).isFalse();
        assertThat(resp.getBody().getMessage()).isEqualTo("Entity not found!");

    }

    @Test
    public void createAndUpdate() {
        Class<PersonResponseDto> responseType = PersonResponseDto.class;
        PersonEntity person = new PersonEntity();
        person.setName(DEFAULT_PERSON_NAME);
        person.setEmail("123@test.com");

        ResponseEntity<PersonResponseDto> response = this.restTemplate.postForEntity(PRODUCT_URL, person, responseType);

        PersonResponseDto dto = response.getBody();

        PersonEntity newName = dto.getEntity();

        newName.setName("newName");

        ResponseEntity<PersonResponseDto> updateResponse = this.restTemplate.postForEntity(PRODUCT_URL, newName,
                responseType);
        assertThat(updateResponse.getBody().getSuccess()).isTrue();
        ResponseEntity<PersonResponseDto> resp = this.restTemplate.getForEntity(PRODUCT_URL + "/" + newName.getId(),
                responseType);

        assertThat(resp.getBody().getEntity().getName()).isEqualTo("newName");
    }

}
