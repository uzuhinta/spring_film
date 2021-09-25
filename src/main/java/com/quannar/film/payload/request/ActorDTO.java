package com.quannar.film.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.Date;

public class ActorDTO {

    @NotBlank
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String summary;
    private MultipartFile[] fileDatas;

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

    public MultipartFile[] getFileDatas() {
        return fileDatas;
    }

    public void setFileDatas(MultipartFile[] fileDatas) {
        this.fileDatas = fileDatas;
    }

    @Override
    public String toString() {
        return "ActorDTO{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", summary='" + summary + '\'' +
                ", fileDatas=" + Arrays.toString(fileDatas) +
                '}';
    }
}
