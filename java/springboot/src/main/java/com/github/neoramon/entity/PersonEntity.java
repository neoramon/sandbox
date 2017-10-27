package com.github.neoramon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@NamedQueries({ @NamedQuery(name = "PersonEntity.test1", query = "SELECT p FROM PersonEntity p WHERE p.id = ?1"),
        @NamedQuery(name = "PersonEntity.test2", query = "SELECT p FROM PersonEntity p ORDER BY p.name DESC")

})

public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id_person")
    private Long id;

    @Column(name = "nm_person", nullable = false)
    private String name;

    @Column(name = "email", nullable = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ProductEntity [id=" + id + ", name=" + name + ", email=" + email + "]";
    }

}
