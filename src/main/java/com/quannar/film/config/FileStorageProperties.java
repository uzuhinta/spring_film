package com.quannar.film.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.FileSystems;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

    private String uploadDir;

    public String getUploadDirActor() {
        return uploadDir + FileSystems.getDefault().getSeparator() + "/actor";
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
