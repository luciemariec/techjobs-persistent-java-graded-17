package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

// Add the @MappedSuperclass
@MappedSuperclass
public abstract class AbstractEntity {

    //Add the @Id and @GeneratedValue annotations to the id field
    @Id
    @GeneratedValue
    private int id;

    // Add appropriate validation annotations on the name field so that:
    // 1. a user cannot leave the name field blank
    // 2. there are reasonable limitations on the size of the name string
    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    public int getId() { return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
