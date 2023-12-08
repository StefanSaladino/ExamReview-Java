package com.example.examreview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<Student> students = JsonUtility.getStudentsFromFile("students.json");
        List<Student> passingStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getAvgGrade() > 50) {
                passingStudents.add(student);
            }
        }
        System.out.printf("Passing avg students: %d%n", passingStudents.size());
//
//
        //loop over all students
        ArrayList<Student> comp1008Students = new ArrayList<>();
        for (Student student : students) {
            List<Course> courses = student.getCourses();
            for (Course course : courses) {
                if (course.getCourseCode().equals("COMP1008") && course.getGrade() > 50)
                    comp1008Students.add(student);
            }
        }
        System.out.printf("Number of students passing COMP1008: %d%n", comp1008Students.size());

        int fourPlusCourses = 0;
        for (Student student : students) {
            List<Course> courses = student.getCourses();
            int noOfCourses = 0;
            for (Course course : courses) {
                noOfCourses++;
            }
            if (noOfCourses > 3) {
                fourPlusCourses++;
            }
        }
        System.out.printf("No of students taking 4 or more courses: %d%n", fourPlusCourses);

        int fourOrMoreCoursePassingStudents = 0;
        for (Student student : students) {
            List<Course> courses = student.getCourses();
            int passingCourses = 0;
            for (Course course : courses) {
                if (course.getGrade() >= 50) {
                    passingCourses++;
                }
            }
            if (passingCourses >= 4)
                fourOrMoreCoursePassingStudents++;
        }

        System.out.printf("Number of students passing at least four courses: %d%n", fourOrMoreCoursePassingStudents);


//8. What is the average grade for students that have completed the COMP1113 course?
//   Show the result to 2 decimal places
        ArrayList <Course> comp1113Grades = new ArrayList<>();
        double sum=0;

        for (Student student : students) {
            List <Course> courses = student.getCourses();
            for(Course course: courses){
                if(course.getCourseCode().contains("COMP1113")){
                    comp1113Grades.add(course);
                    sum+= course.getGrade();
                }
            }
        }
        double totalNumberOfGrades = comp1113Grades.size();
        double avgGradeComp1113 = sum/totalNumberOfGrades;
        System.out.printf("Average grade in Comp 1113: %.2f / %.2f = %.2f%n", sum, totalNumberOfGrades, avgGradeComp1113);


//9. What is the average grade for students that have completed the COMP1113 course?
//   Create the solution using a Stream and show it accurate 2 decimal places.
//10. Who is the best student?  Find the student with the highest average grade.
        Student bestStudent = students.get(0);
        for(Student student: students){
            if(student.getAvgGrade()>bestStudent.getAvgGrade()){
                bestStudent = student;
            }
        }
        System.out.println(bestStudent);
//11. Create a new thread that will calculate who the worst student is.
//    The worst student is the student with the lowest average grade.
        Thread worstStudentThread = new Thread("worstStudentThread") {
            @Override
            public void run() {
                    try {
                        Student worstStudent = students.get(0);
                        for(Student student: students){
                            if(student.getAvgGrade()<worstStudent.getAvgGrade()){
                                worstStudent = student;
                            }
                        }
                        System.out.println(worstStudent);
                    } catch (RuntimeException e) {
                        throw new RuntimeException(e);
                    }

                }
        };
        worstStudentThread.start();
    }
}
