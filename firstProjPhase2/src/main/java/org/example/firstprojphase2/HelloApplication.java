package org.example.firstprojphase2;

import GUI.SetMainScene;
import javafx.application.Application;
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

        Scene scene = null;
        try {
            scene = new Scene(SetMainScene.setScene(9));
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}