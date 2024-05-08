package com.example.movies.utils;

public class MovieModel {
    public String id;
    public String name;
    public String backgroundpicture;
    public String picture;
    public String description;
    public String video;

    public String getVideo() {
        return video;
    }

    public MovieModel(String id, String name, String backgroundpicture, String picture, String description, String video) {
        this.id = id;
        this.name = name;
        this.backgroundpicture = backgroundpicture;
        this.picture = picture;
        this.description = description;
        this.video = video;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackgroundpicture() {
        return backgroundpicture;
    }

    public void setBackgroundpicture(String backgroundpicture) {
        this.backgroundpicture = backgroundpicture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
