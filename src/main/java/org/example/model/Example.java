package org.example.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private Integer id;
    @SerializedName("marks")
    private List<Mark> marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
}
