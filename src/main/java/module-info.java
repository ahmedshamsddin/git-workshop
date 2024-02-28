module com.ims {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.ims to javafx.fxml;
    exports com.ims;
}
