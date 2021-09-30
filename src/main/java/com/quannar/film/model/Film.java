package com.quannar.film.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quannar.film.common.ConvertVI;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FILM")
public class Film {

    @Id
    @SequenceGenerator(
            name = "FILM_SEQUENCE",
            sequenceName = "FILM_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FILM_SEQUENCE"
    )
    @Column(
            name = "ID"
    )
    private Long id;

    @Column(
            name = "NAME",
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "NUM_CHAP",
            columnDefinition = "INT"
    )
    private Integer num_chap;

    @Column(
            name = "TIME_PER_CHAP",
            columnDefinition = "INT"
    )
    private Integer timePerChap;

    @Column(
            name = "NATIONAL",
            columnDefinition = "TEXT"
    )
    private String national;

    @Column(name = "RELEASE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date releaseAt;

    @Column(
            name = "QUALITY",
            columnDefinition = "VARCHAR(10) DEFAULT 'HD'"
    )
    private String quality;

    @Column(
            name = "SCORE",
            columnDefinition = "REAL DEFAULT 8.0"
    )
    private Float score;

    @Column(
            name = "START",
            columnDefinition = "INT DEFAULT 4"
    )
    private Integer start;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "TYPE_ID",
            referencedColumnName = "ID",
            foreignKey = @ForeignKey(
                    name = "FILM_TYPE_FK"
            )
    )
    @JsonIgnore
    private Type type;

    @Column(
            name = "STATUS",
            columnDefinition = "INTEGER DEFAULT 1"
    )
    private Integer status;

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

    public Film() {
    }

    public Film(String name) {
        this.name = name;
    }

    public Film(String name,
                Integer num_chap,
                Integer timePerChap,
                String national,
                Date releaseAt,
                String quality,
                Float score,
                Integer start) {
        this.name = name;
        this.num_chap = num_chap;
        this.timePerChap = timePerChap;
        this.national = national;
        this.releaseAt = releaseAt;
        this.quality = quality;
        this.score = score;
        this.start = start;
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

    public Integer getNum_chap() {
        return num_chap;
    }

    public void setNum_chap(Integer num_chap) {
        this.num_chap = num_chap;
    }

    public Integer getTimePerChap() {
        return timePerChap;
    }

    public void setTimePerChap(Integer timePerChap) {
        this.timePerChap = timePerChap;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public Date getReleaseAt() {
        return releaseAt;
    }

    public void setReleaseAt(Date releaseAt) {
        this.releaseAt = releaseAt;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
        return String.format("%s_%s", this.id, ConvertVI.createSlug(this.name));
    }
}
