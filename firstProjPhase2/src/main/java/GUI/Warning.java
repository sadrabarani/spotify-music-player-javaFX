package GUI;

import javafx.scene.control.Alert;

public class Warning {
    public static void warning(String message,String errorMsg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(errorMsg);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
