package GUI;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SuccesPopUp {
    private static Stage stage0;

    public static void setStage1(Stage stage1) {
        stage0 = stage1;
    }

    public static void showSuccessfulMessage() {
        Stage primaryStage= stage0;
        Popup popup = new Popup();
        Pane pane = new Pane();
        popup.getContent().add(pane);
        double x = primaryStage.getX()+10;
        double y = primaryStage.getY()+600;
        Button button=new Button("Succesfull");
        button.setStyle("-fx-background-color: green");
        pane.getChildren().addAll(button);
        popup.setX(x);
        popup.setY(y);
        popup.show(primaryStage);
        Duration delay = Duration.seconds(3);
        Timeline timeline = new Timeline(new KeyFrame(delay, event -> popup.hide()));
        timeline.play();
    }
}
