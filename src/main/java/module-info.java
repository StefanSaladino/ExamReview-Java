module com.example.examreview {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.examreview to javafx.fxml, com.google.gson;
    exports com.example.examreview;
}