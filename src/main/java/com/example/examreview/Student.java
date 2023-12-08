package com.example.examreview;

import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {
    @SerializedName("STUDENTNUM")
    private int studentNum;

    @SerializedName("FirstName")
    private String firstName;

    public int getStudentNum() {
        return studentNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    private String lastName;

    @SerializedName("Email")
    private String email;

    private ArrayList<Course> courses;

    @Override
    public String toString() {return String.format("%s- %s- %s%nStudent average = %.1f%n", firstName, studentNum, courses, getAvgGrade());}

    public double getAvgGrade()
    {
//        if (courses.size()==0)
//            return -1;
//        else
//        {
//            double sum=0;
//
//            for (StudentCourse course : courses)
//            {
//                sum = sum + course.getGrade();
//            }
//            return sum/courses.size();
//        }
        return courses.stream()
                .mapToDouble(course -> course.getGrade())
                .average()
                .getAsDouble();


    }

    public String getFormattedAvgGrade() {
        double averageGrade = getAvgGrade();

        // Format the result to one decimal point
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(averageGrade);
    }

    public boolean contains(String searchTerm)
    {
        String avgGrade = Double.toString(getAvgGrade());

        searchTerm = searchTerm.toLowerCase();
        //contains is a case sensitive search for a substring
        return (firstName.toLowerCase().contains(searchTerm) ||
                Integer.toString(studentNum).contains(searchTerm) ||
                lastName.contains(searchTerm)) ||
                email.contains(searchTerm) ||
                avgGrade.contains(searchTerm);
    }
}
