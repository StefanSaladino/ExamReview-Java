package com.example.examreview;

import com.google.gson.annotations.SerializedName;

public class Course {
    private String courseCode;

    @SerializedName("CourseName")
    private String courseName;

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getGrade() {
        return grade;
    }

    @SerializedName("GRADE")
    private int grade;

    @Override public String toString(){return String.format("%s: %d",courseName, grade);}
}
