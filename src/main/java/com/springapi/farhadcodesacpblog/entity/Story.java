package com.springapi.farhadcodesacpblog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.Objects;

@Entity
public class Story {
    @Id
    @GeneratedValue
    private  int Id;
    @ManyToOne
    private User AuthorId;
    @NotBlank
    @NotEmpty
    @NotNull
    private String Title;
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min=0,max=20000)
    private String Description;
    @NotBlank
    @NotEmpty
    @NotNull
    private String Difficulty;
    @NotBlank
    @NotEmpty
    @NotNull
    private String Topic;
    private Date CreationTime = new Date(System.currentTimeMillis());
    private Date LastModifiedTime = new Date(System.currentTimeMillis());

    public Story(int id, User authorId, String title, String description, String difficulty, String topic) {
        Id = id;
        AuthorId = authorId;
        Title = title;
        Description = description;
        Difficulty = difficulty;
        Topic = topic;
    }

    public Story(String title, String description, String difficulty, String topic) {
        Title = title;
        Description = description;
        Difficulty = difficulty;
        Topic = topic;
    }

    public Story() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public User getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(User authorId) {
        AuthorId = authorId;
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

    public Date getLastModifiedTime() {
        return LastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        LastModifiedTime = lastModifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Id == story.Id && AuthorId == story.AuthorId && Title.equals(story.Title) && Description.equals(story.Description) && Difficulty.equals(story.Difficulty) && Topic.equals(story.Topic) && CreationTime.equals(story.CreationTime) && LastModifiedTime.equals(story.LastModifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, AuthorId);
    }

    @Override
    public String toString() {
        return "Story{" +
                "Id=" + Id +
                ", AuthorId=" + AuthorId +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Difficulty='" + Difficulty + '\'' +
                ", Topic='" + Topic + '\'' +
                ", CreationTime=" + CreationTime +
                ", LastModifiedTime=" + LastModifiedTime +
                '}';
    }
}
