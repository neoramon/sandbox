package com.github.neoramon.dto;

import java.io.Serializable;

import com.github.neoramon.entity.PersonEntity;

public class PersonListResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Iterable<PersonEntity> entity;

    private Boolean success;

    private String message;

    public PersonListResponseDto() {
        // nothing to do.
    }

    public PersonListResponseDto(Iterable<PersonEntity> entity, Boolean success, String message) {
        super();
        this.entity = entity;
        this.success = success;
        this.message = message;
    }

    public PersonListResponseDto(Iterable<PersonEntity> entity, Boolean success) {
        super();
        this.entity = entity;
        this.success = success;
    }

    public PersonListResponseDto(Iterable<PersonEntity> entity) {
        super();
        this.entity = entity;
        this.success = true;
    }

    public PersonListResponseDto(Boolean success, String message) {
        super();
        this.entity = null;
        this.success = success;
        this.message = message;
    }

    public Iterable<PersonEntity> getEntity() {
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
        return "PersonListResponseDto [entity=" + entity + ", success=" + success + ", message=" + message + "]";
    }

}
