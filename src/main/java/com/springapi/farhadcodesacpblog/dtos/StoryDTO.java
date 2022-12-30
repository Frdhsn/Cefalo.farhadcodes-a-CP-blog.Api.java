package com.springapi.farhadcodesacpblog.dtos;

import java.util.Date;

public class StoryDTO {
    private  int id;
    private String author;
    private String title;
    private String description;
    private Date CreationTime;

    public StoryDTO(int id, String authorId, String title, String description) {
        this.id = id;
        this.author = authorId;
        this.title = title;
        this.description = description;
    }

    public StoryDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(Date creationTime) {
        CreationTime = creationTime;
    }
}
