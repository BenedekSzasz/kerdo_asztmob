module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.example.controllers to javafx.fxml;
    // opens com.example.models to javafx.fxml;
    opens com.example to javafx.fxml;
    exports com.example;
}
