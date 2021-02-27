package com.logique.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "url")
public class Url {
    @Id
    private String id;
    private String userId;
    private String urlOriginal;
    private String urlGenerated;
    private Date date;

    public Url() {}

    public Url(String urlOriginal, String urlGenerated, Date date) {
        this.urlOriginal = urlOriginal;
        this.urlGenerated = urlGenerated;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public String getUrlGenerated() {
        return urlGenerated;
    }

    public void setUrlGenerated(String urlGenerated) {
        this.urlGenerated = urlGenerated;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}