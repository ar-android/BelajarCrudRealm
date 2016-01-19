package com.ahmadrosid.belajarrealm.models;

/**
 * Created by ocittwo on 1/19/16.
 */
public class DataModel {
    private int id;
    private String title;
    private String description;

    public DataModel(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
