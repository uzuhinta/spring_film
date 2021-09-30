package com.quannar.film.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class FilmDTO {

    private String name;
    private Integer num_chap;
    private Integer timePerChap;
    private String national;
    private Date releaseAt;
    private String quality;
    private Float score;
    private Integer start;

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
}
