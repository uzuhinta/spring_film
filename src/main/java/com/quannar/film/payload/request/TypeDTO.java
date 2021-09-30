package com.quannar.film.payload.request;

import javax.validation.constraints.NotBlank;

public class TypeDTO {

    @NotBlank(message = "This field must not be blank")
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
