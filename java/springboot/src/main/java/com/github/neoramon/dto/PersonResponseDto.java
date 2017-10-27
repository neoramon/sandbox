package com.github.neoramon.dto;

import java.io.Serializable;

import com.github.neoramon.entity.PersonEntity;

public class PersonResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private PersonEntity entity;

    private Boolean success;

    private String message;

    public PersonResponseDto() {
        // default contructor.
    }

    public PersonResponseDto(PersonEntity entity, Boolean success, String message) {
        super();
        this.entity = entity;
        this.success = success;
        this.message = message;
    }

    public PersonResponseDto(PersonEntity entity, Boolean success) {
        super();
        this.entity = entity;
        this.success = success;
    }

    public PersonResponseDto(PersonEntity entity) {
        super();
        this.entity = entity;
        this.success = true;
    }

    public PersonResponseDto(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public PersonEntity getEntity() {
        return entity;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PersonResponseDto [entity=" + entity + ", success=" + success + ", message=" + message + "]";
    }

}
