package com.quannar.film.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quannar.film.common.ConvertVI;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "TYPE")
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
            unique = true,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "DESCRIPTION",
            columnDefinition = "TEXT"
    )
    private String description;

    @OneToMany(mappedBy = "type")
    private Set<Film> films = new HashSet<>();

    @Transient
    private String slug;

    @Column(
            name = "STATUS",
            columnDefinition = "SMALLINT NOT NULL"
    )
    private Integer status = 1;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.DATE)
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

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", films=" + films +
                ", slug='" + slug + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
