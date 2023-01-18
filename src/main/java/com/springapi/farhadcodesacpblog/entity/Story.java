package com.springapi.farhadcodesacpblog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.Objects;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @ManyToOne
    private Users authorId;
    @NotBlank
    @NotEmpty
    @NotNull
    private String title;
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min=0,max=20000)
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreationTime = new Date(System.currentTimeMillis());

    public Story() {

    }
    public Story(int id, Users authorId, String title, String description) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.description = description;
    }

    public Story(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Users authorId) {
        this.authorId = authorId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return id == story.id && authorId.equals(story.authorId) && title.equals(story.title) && description.equals(story.description) && Objects.equals(CreationTime, story.CreationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
