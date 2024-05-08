package org.example.firstprojphase2;

import GUI.SetMainScene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stage;
    private static Scene frsScene;
    public static Stage getStage() {
        return stage;
    }
    public static Scene getFrsScene() {
        return frsScene;
    }
    public static void setStage(Stage stage) {
        HelloApplication.stage = stage;
    }
    public static void setFrsScene(Scene frsScene) {
        HelloApplication.frsScene = frsScene;
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = null;
        try {
            scene = new Scene(SetMainScene.setScene(5));
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        try {
            showSuccessfulMessage(stage);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void showSuccessfulMessage(Stage stage1) {
        Stage primaryStage= stage1;
        // Create a new Popup
        Popup popup = new Popup();

        // Create a Pane to hold the content
        Pane pane = new Pane();

        // Create a Rectangle
        Rectangle rectangle = new Rectangle(100,30);
        rectangle.setFill(Color.LIGHTGREEN);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);

        // Create a Label with the text


        // Add the Rectangle and Label to the Pane


        // Set the content of the Popup to the Pane
        popup.getContent().add(pane);

        // Calculate position for bottom left corner
        double x = primaryStage.getX()+10; // Left edge
        double y = primaryStage.getY()+600; // Bottom edge
//
////        // Set position of the Popup
        Button button=new Button("Succesfull");
        button.setStyle("-fx-background-color: green");
        Label label = new Label("It is successful");
        label.setLayoutX(x);
        label.setLayoutY(y-600);
        pane.getChildren().addAll(button);

        popup.setX(x);
        popup.setY(y);

        // Show the Popup
        popup.show(primaryStage);

        // Create a Timeline to close the Popup after 3 seconds
        Duration delay = Duration.seconds(3);
        Timeline timeline = new Timeline(new KeyFrame(delay, event -> popup.hide()));
        timeline.play();
    }
    public static void main(String[] args) {
        launch();
    }
}