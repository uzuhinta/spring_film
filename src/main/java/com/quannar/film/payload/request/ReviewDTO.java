package com.quannar.film.payload.request;

public class ReviewDTO {

    private String summary;

    private String short_description;

    private String content;

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

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "summary='" + summary + '\'' +
                ", short_description='" + short_description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
