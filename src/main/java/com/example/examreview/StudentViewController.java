package com.example.examreview;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentViewController {

    @FXML
    private TableColumn<Student, String> lNameColumn;

    @FXML
    private TableColumn<Course, Integer> avgColumn;

    @FXML
    private TableColumn<Student, String> fNameColumn;

    @FXML
    private TextField searchBar;

    @FXML
    private Label searchBarLabel;

    @FXML
    private ListView<Course> listView;

    @FXML
    private TableColumn<Student, Integer> studentNumColumn;

    private List<Student> allStudents;

    @FXML
    private TableView<Student> tableView;

    @FXML
    void initialize(){
        allStudents = JsonUtility.getStudentsFromFile("students.json");

        studentNumColumn.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        fNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        avgColumn.setCellValueFactory(new PropertyValueFactory<>("formattedAvgGrade"));

        tableView.getItems().addAll(allStudents);

        updateLabel();

        searchBar.textProperty().addListener((observableValue, oldValue, searchTerm) -> {
            tableView.getItems().clear();
            for (Student student : allStudents)
            {
                if (student.contains(searchTerm))
                {
                    tableView.getItems().add(student);
                }
            }
            updateLabel();

        });
        tableView.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, studentSelected) -> {
            listView.getItems().clear();
            ArrayList<Course> courses = studentSelected.getCourses();
            listView.getItems().addAll(courses);
        }));
    }




    private void updateLabel(){
        searchBarLabel.setText("Number of students: " + tableView.getItems().size());
    }

}