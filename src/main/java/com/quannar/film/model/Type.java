package com.quannar.film.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.*;

public class Type {

    @Id
    @SequenceGenerator(
            name = "TYPE_SEQUENCE",
            sequenceName = "TYPE_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "TYPE_SEQUENCE"
    )
    @Column(
            name = "ID",
            updatable = false
    )
    private Long id;

    @Column(
            name = "NAME",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "DESCRIPTION",
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Type() {
    }

    public Type(String name) {
        this.name = name;
    }

    public Type(String name, String description) {
        this.name = name;
        this.description = description;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}