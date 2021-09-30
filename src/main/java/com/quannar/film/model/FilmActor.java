package com.quannar.film.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FILM_ACTOR")
public class FilmActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "ROLE",
            columnDefinition = "TEXT NOT NULL"
    )
    private String role;

    @Column(
            name = "DESCRIPTION",
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "IMAGE",
            columnDefinition = "TEXT"
    )
    private String image;

    @ManyToOne
    @JoinColumn(
            name = "FILM_ID",
            referencedColumnName = "ID",
            foreignKey = @ForeignKey(
                    name = "FILM_ACTOR_FK"
            )
    )
    private Film film;

    @ManyToOne
    @JoinColumn(
            name = "ACTOR_ID",
            referencedColumnName = "ID",
            foreignKey = @ForeignKey(
                    name = "ACTOR_FILM_FK"
            )
    )
    private Actor actor;

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

    public FilmActor() {
    }

    public FilmActor(String role, String description, String image, Film film, Actor actor) {
        this.role = role;
        this.description = description;
        this.image = image;
        this.film = film;
        this.actor = actor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
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
