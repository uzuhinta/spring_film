package com.quannar.film.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "REVIEW")
public class Review {

    @Id
    @SequenceGenerator(
            name = "REVIEW_SEQUENCE",
            sequenceName = "REVIEW_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "REVIEW_SEQUENCE"
    )
    @Column(
            name = "ID",
            updatable = false
    )
    private Long id;

    @Column(
            name = "SUMMARY",
            columnDefinition = "TEXT"
    )
    private String summary;

    @Column(
            name = "SHORT_DESCRIPTION",
            columnDefinition = "TEXT"
    )
    private String short_description;

    @Column(
            name = "CONTENT",
            columnDefinition = "TEXT"
    )
    private String content;

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

    public Review() {
    }

    public Review(String summary, String short_description, String content) {
        this.summary = summary;
        this.short_description = short_description;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
