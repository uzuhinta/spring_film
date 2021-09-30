package com.quannar.film.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.quannar.film.common.ConvertVI;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "ACTOR")
public class Actor {

    @Id
    @SequenceGenerator(
            name = "ACTOR_SEQUENCE",
            sequenceName = "ACTOR_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "ACTOR_SEQUENCE"
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
            name = "DOB",
            columnDefinition = "DATE"
    )
    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Column(
            name = "SUMMARY",
            columnDefinition = "TEXT"
    )
    private String summary;

    @Column(
            name = "IMG",
            columnDefinition = "TEXT"
    )
    private String img;

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

    @Transient
    private String slug;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    public Actor(String name, Date dob, String summary, String img) {
        this.name = name;
        this.dob = dob;
        this.summary = summary;
        this.img = img;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
        return String.format("%s_%s", this.id, ConvertVI.createSlug(this.name));
    }
}
