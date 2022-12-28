package com.springapi.farhadcodesacpblog.dtos;

import com.springapi.farhadcodesacpblog.entity.User;

import java.util.Date;

public class StoryDTO {
    private  int Id;
    private String Author;
    private String Title;
    private String Description;
    private String Difficulty;
    private String Topic;
    private Date CreationTime;

    public StoryDTO(int id, String authorId, String title, String description, String difficulty, String topic) {
        Id = id;
        Author = authorId;
        Title = title;
        Description = description;
        Difficulty = difficulty;
        Topic = topic;
    }

    public StoryDTO() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String authorId) {
        Author = authorId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(String difficulty) {
        Difficulty = difficulty;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public Date getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(Date creationTime) {
        CreationTime = creationTime;
    }
}
