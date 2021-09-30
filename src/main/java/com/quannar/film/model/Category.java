package com.quannar.film.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quannar.film.common.ConvertVI;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @SequenceGenerator(
            name = "CATEGORY_SEQUENCE",
            sequenceName = "CATEGORY_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CATEGORY_SEQUENCE"
    )
    @Column(
            name = "ID",
            updatable = false
    )
    private Long id;

    @Column(
            name = "NAME",
            unique = true,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "DESCRIPTION",
            columnDefinition = "TEXT"
    )
    private String description;

    @Transient
    private String slug;

    @Column(
            name = "STATUS",
            columnDefinition = "SMALLINT NOT NULL"
    )
    private Integer status = 1;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    Set<Film> films = new HashSet<>();

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @Column(
            name = "UPDATED_AT"
    )
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, String description) {
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

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
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

    public String getSlug() {
        return ConvertVI.createSlug(this.name);
    }
}
