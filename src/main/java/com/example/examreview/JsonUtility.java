package com.example.examreview;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class JsonUtility {
    public static List<Student> getStudentsFromFile(String fileName)
    {
        Gson gson = new Gson();
        //this is called try...with resources when we use the ().
        //anything created inside the ( ) will automatically have the .close() called once
        //the resource is not required.
        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            Student[] students= gson.fromJson(jsonReader, Student[].class);
            return Arrays.asList(students);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
