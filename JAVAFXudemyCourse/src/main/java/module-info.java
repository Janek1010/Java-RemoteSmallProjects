module com.example.javafxudemycourse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxudemycourse to javafx.fxml;
    exports com.example.javafxudemycourse;
}