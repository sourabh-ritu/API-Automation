package org.example.model;

import com.google.gson.annotations.SerializedName;

public class Mark {

    @SerializedName("Science")
    private Integer science;
    @SerializedName("Maths")
    private Integer maths;
    @SerializedName("English")
    private Integer english;

    public Integer getScience() {
        return science;
    }

    public void setScience(Integer science) {
        this.science = science;
    }

    public Integer getMaths() {
        return maths;
    }

    public void setMaths(Integer maths) {
        this.maths = maths;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

}
