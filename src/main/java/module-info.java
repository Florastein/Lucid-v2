module com.lucid {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.lucid to javafx.fxml;
    opens com.lucid.models to javafx.base;
    exports com.lucid;



    opens com.lucid.controllers to javafx.fxml;

}
