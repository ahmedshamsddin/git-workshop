module com.ims {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ims to javafx.fxml;
    exports com.ims;
}
