package org.example.firstprojphase2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}