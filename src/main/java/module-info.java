module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens DemoClass to javafx.fxml;
    exports DemoClass;

}