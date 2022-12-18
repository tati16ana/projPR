module com.example.forexamchet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.forexamchet to javafx.fxml;
    exports com.example.forexamchet;
}