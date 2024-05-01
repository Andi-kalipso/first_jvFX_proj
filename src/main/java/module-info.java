module com.example.first_jvfx_proj {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.first_jvfx_proj to javafx.fxml;
    exports com.example.first_jvfx_proj;
    exports com.example.first_jvfx_proj.structClasses;
    opens com.example.first_jvfx_proj.structClasses to javafx.fxml;
}