module org.example.firstprojphase2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.media;
    requires annotations;

    opens org.example.firstprojphase2 to javafx.fxml;
    exports org.example.firstprojphase2;
    exports GUI;
    opens GUI to javafx.fxml;
    exports GUI.mainSection;
    opens GUI.mainSection to javafx.fxml;
    exports model.UserAccount;
    opens model.UserAccount to javafx.fxml;
    exports controller;
    opens controller to javafx.fxml;
    exports GUI.mainSection.Home;
    opens GUI.mainSection.Home to javafx.fxml;
}