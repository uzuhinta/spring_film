package com.quannar.film.payload.response;

import com.quannar.film.common.Constant;

import java.util.LinkedHashMap;

public class ResponseBean {
    private String error;
    private String message;
    private String description;
    private LinkedHashMap<String, Object> data;

    public ResponseBean() {
        this.error = Constant.ERROR_CODE_NOK;
    }

    public void addData(String key, Object obj){
        if(this.data == null){
            this.data = new LinkedHashMap<>();
        }
        this.data.put(key, obj);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedHashMap<String, Object> getData() {
        return data;
    }

    public void setData(LinkedHashMap<String, Object> data) {
        this.data = data;
    }
}
