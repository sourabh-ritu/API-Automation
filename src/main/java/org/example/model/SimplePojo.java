package org.example.model;

import com.google.gson.annotations.SerializedName;

public class SimplePojo {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", name:" + "\""+name +"\"" +
                "}";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
