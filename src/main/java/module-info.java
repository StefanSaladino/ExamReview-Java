module com.example.examreview {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.examreview to javafx.fxml;
    exports com.example.examreview;
}